package com.trello.core;

import com.trello.utils.PropertiesInfo;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestManager {
    private static RequestSpecification requestSpec;

    public static RequestSpecification init(String baseUri) {
        if (RequestManager.requestSpec == null) {
            requestSpec = new RequestSpecBuilder()
                    .setBaseUri(baseUri).build();
        }
        return requestSpec;
    }

    public static void setRequestSpec(String baseUri) {
        RequestManager.requestSpec = new RequestSpecBuilder()
                .setBaseUri(baseUri).build();
    }

    public static Response post(ApiRequestHandler apiRequest) {
        return RestAssured.given()
                .spec(requestSpec)
                .log().all().when()
                .headers(apiRequest.getHeaders())
                .queryParams(apiRequest.getQueryParams())
                .post(apiRequest.getEndpoint()).then().log().all()
                .extract().response();
    }

    public static Response post(ApiRequestHandler apiRequestHandler, boolean useBody) {
        if (useBody) {
            return RestAssured.given()
                    .spec(requestSpec)
                    .log().all().when()
                    .headers(apiRequestHandler.getHeaders())
                    .body(apiRequestHandler.getBody())
                    .post(apiRequestHandler.getEndpoint()).then().log().all()
                    .extract().response();
        }
        return RequestManager.post(apiRequestHandler);
    }

    public static Response put(ApiRequestHandler apiRequest) {
        return RestAssured.given()
                .spec(requestSpec)
                .log().all().when()
                .headers(apiRequest.getHeaders())
                .queryParams(apiRequest.getQueryParams())
                .put(apiRequest.getEndpoint());
    }

    public static Response get(ApiRequestHandler apiRequest) {
        return RestAssured.given()
                .spec(requestSpec)
                .log().all().when()
                .headers(apiRequest.getHeaders())
                .queryParams(apiRequest.getQueryParams())
                .get(apiRequest.getEndpoint());
    }

    public static Response delete(ApiRequestHandler apiRequest) {
        return RestAssured.given()
                .spec(requestSpec)
                .log().all().when()
                .headers(apiRequest.getHeaders())
                .queryParams(apiRequest.getQueryParams())
                .delete(apiRequest.getEndpoint());
    }
}


