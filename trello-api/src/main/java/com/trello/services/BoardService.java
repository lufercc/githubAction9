package com.trello.services;

import com.trello.core.ApiRequestHandler;
import com.trello.core.RequestManager;
import com.trello.utils.PropertiesInfo;
import io.restassured.response.Response;

import java.util.HashMap;

public class BoardService {
    private ApiRequestHandler apiRequestHandler;
    private String apiKey = PropertiesInfo.getInstance().getApiKey();
    private String apiToken = PropertiesInfo.getInstance().getApiToken();

    public BoardService() {
        this.apiRequestHandler = new ApiRequestHandler();
        var headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");

        var queryParams = new HashMap<String, String>();
        queryParams.put("key", apiKey);
        queryParams.put("token", apiToken);
        this.apiRequestHandler.setHeaders(headers);
        this.apiRequestHandler.setQueryParam(queryParams);
        RequestManager.init(String.format("%s/%s", PropertiesInfo.getInstance().getBaseApi(),
                PropertiesInfo.getInstance().getApiVersion()));
    }

    public Response createBoard(String boardName) {
        String endpoint = "/boards/?name=" + boardName;
        apiRequestHandler.setEndpoint(endpoint);
        return RequestManager.post(apiRequestHandler);
    }

    public Response deleteBoard(String boardId) {
        String endpoint = String.format("/boards/%s", boardId);
        apiRequestHandler.setEndpoint(endpoint);
        return RequestManager.delete(apiRequestHandler);
    }

    public Response getBoard(String boardId) {
        String endpoint = String.format("/boards/%s", boardId);
        apiRequestHandler.setEndpoint(endpoint);
        return RequestManager.get(apiRequestHandler);
    }
}
