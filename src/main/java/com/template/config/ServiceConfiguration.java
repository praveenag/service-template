package com.template.config;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceConfiguration {

    @JsonProperty
    private String baseUrl;

    @JsonProperty
    private String adminBaseUrl;

    private ServiceConfiguration() {
    }

    public ServiceConfiguration(String baseUrl, String adminBaseUrl) {
        this.baseUrl = baseUrl;
        this.adminBaseUrl = adminBaseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getAdminBaseUrl() {
        return adminBaseUrl;
    }

    @Override
    public String toString() {
        return "ServiceConfiguration{" +
                "baseUrl='" + baseUrl + '\'' +
                ", adminBaseUrl='" + adminBaseUrl + '\'' +
                '}';
    }
}
