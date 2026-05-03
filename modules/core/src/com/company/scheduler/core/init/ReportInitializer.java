package com.company.scheduler.core.init;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.sys.events.AppContextStartedEvent;
import com.haulmont.cuba.security.app.Authentication;
import com.haulmont.reports.app.service.ReportService;
import com.haulmont.reports.entity.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Импорт отчетов при старте приложения из директории, указанной в app.reports.path
 */

@Component
public class ReportInitializer {

    private final Logger log = LoggerFactory.getLogger(ReportInitializer.class);
    private final String DEFAULT_REPORT_FOLDER = "${user.dir}/../../../reportArchive";

    @Inject
    private DataManager dataManager;
    @Inject
    protected Authentication authentication;
    @Inject
    private ReportService reportService;
    @Value("${app.reports.path:default}")
    private String reportsPath;


    @EventListener
    public void init(AppContextStartedEvent event) {
        Path reportFolder = Path.of(reportsPath);
        log.info("Report archive directory: {}", reportFolder);

        try (Stream<Path> fileList = Files.list(reportFolder)) {
            authentication.begin();

            List<String> reportList = dataManager.load(Report.class).list().stream()
                    .map(Report::getName)
                    .collect(Collectors.toList());
            log.debug("Existing reports: {}", reportList);

            fileList.forEach(path -> {
                String fileName = path.getFileName().toString().trim();
                if (!fileName.endsWith(".zip")) {
                    return;
                }
                int dotIndex = fileName.lastIndexOf('.');
                String nameWithoutExt = (dotIndex == -1)
                        ? fileName
                        : fileName.substring(0, dotIndex);
                if (reportList.contains(nameWithoutExt)) {
                    log.debug("Report already exists, skipping: {}", nameWithoutExt);
                    return;
                }
                try {
                    reportService.importReports(Files.readAllBytes(path));
                    log.info("Import report: {}", nameWithoutExt);
                } catch (IOException e) {
                    log.error("Failed to import report from file: {}", fileName, e);
                }
            });
        } catch (IOException e) {
            log.error("Failed to read report archive directory: {}", reportFolder, e);
        } finally {
            authentication.end();
        }
    }
}
