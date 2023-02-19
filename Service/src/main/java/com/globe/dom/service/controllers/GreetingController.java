package com.globe.dom.service.controllers;

import com.globe.dom.models.ResponseWrapper;
import com.globe.dom.utilities.ResponseUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("Greetings Controller")
@RequestMapping("/api/greetings")
@Log4j2
public class GreetingController {

    @GetMapping("/warm_greeting")
    public ResponseEntity<ResponseWrapper<String>> index() {
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");

        String data = "Howdy! Check out the Logs to see the output...";

        return ResponseUtils.createResponseForSuccess(data);

    }
}
