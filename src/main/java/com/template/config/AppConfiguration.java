package com.template.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static java.util.Arrays.asList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppConfiguration extends Configuration {
    private MongoConfiguration mongo;
    private ServiceConfiguration employerService;

    @JsonProperty("mongo")
    public MongoConfiguration getMongo() {
        return mongo;
    }

    @JsonProperty("employerService")
    public ServiceConfiguration getEmployerService() {
        return employerService;
    }

}
