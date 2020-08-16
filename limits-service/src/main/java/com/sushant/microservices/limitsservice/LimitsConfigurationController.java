package com.sushant.microservices.limitsservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfiguration(){

        logger.info("min - {},  max - {}", configuration.getMinimum(), configuration.getMaximum());
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());

    }
}
