package com.globe.dom.service.services.impls;

import com.globe.dom.service.services.GreetingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class GreetingServiceImpl implements GreetingService {

    //10 AM monday through friday: cron = "0 0 10 * * MON-FRI"
    //every 5 seconds: fixedRate = 5000
    @Scheduled(cron = "0 42 10 ? * MON-FRI")
    public void greeting(){
        log.info("Hello Again!");
    }


}
