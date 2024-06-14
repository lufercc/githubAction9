package com.trello.core;

import java.util.HashMap;
import java.util.Map;

public class ApiRequestHandler {
    private Map<String, String> headers;
    private Map<String, String> queryParams;
    private String baseUrl;
    private String endpoint;
    private String body;
    public ApiRequestHandler() {
        headers = new HashMap<>();
        queryParams = new HashMap<>();
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setQueryParam(Map<String, String> queryParam) {
        this.queryParams.putAll(queryParam);
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers.putAll(headers);
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getBaseUrl() {
        return this.baseUrl;
    }

    public void setQueryParam(String key, String value) {
        this.queryParams.put(key, value);
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Map<String, ?> getQueryParams() {
        return this.queryParams;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getBody() {
        return this.body;
    }
}
