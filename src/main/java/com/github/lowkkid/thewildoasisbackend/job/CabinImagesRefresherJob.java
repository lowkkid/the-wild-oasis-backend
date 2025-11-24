package com.github.lowkkid.thewildoasisbackend.job;

import com.github.lowkkid.thewildoasisbackend.service.CabinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CabinImagesRefresherJob {

    private final CabinService cabinService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void execute() {
        log.info("Starting daily URL refresh at midnight...");
        boolean result = cabinService.refreshCabinImages();
        if (result) {
            log.info("Daily URL refresh complete");
        } else {
            log.error("Daily URL refresh failed, see logs for more details");
        }
    }

}
