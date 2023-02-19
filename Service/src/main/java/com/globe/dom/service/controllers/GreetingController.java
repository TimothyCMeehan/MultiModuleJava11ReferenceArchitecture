package com.globe.dom.service.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class GreetingController {

    @RequestMapping("/")
    public String index() {
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");

        return greeting("Howdy! Check out the Logs to see the output...");
    }

    public String greeting(String message){
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED).toString();
    }



}
