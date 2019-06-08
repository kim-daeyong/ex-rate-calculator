package example.daeyong.kim.exratecalculator.scheduler;

import example.daeyong.kim.exratecalculator.service.ExRateAPIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Slf4j
public class RenewCurrency {



    @Autowired
    ExRateAPIService exRateAPIService;

    @Scheduled(cron = "0 0 */1 * * *")
    public String renweCurrency(){
        exRateAPIService.renewAPI();

        log.info("updated at : {}", new Date());

        return "index";
    }
}
