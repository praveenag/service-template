package com.template.loggers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLogger {
    private static final String LoggerName = "App";
    private static final Logger logger = LoggerFactory.getLogger("[*** " + LoggerName + " --->]");
    private final String serviceName;

    public AppLogger(String serviceName) {
        this.serviceName = serviceName;
    }

    public void addingCrossOriginFilter() {
        logger.info(String.format("Adding Cross Origin Filters to %s", serviceName));
    }

    public void settingUpMongoIndexes() {
        logger.info(String.format("Setting Up Mongo Indexes for %s", serviceName));
    }
}
