package com.countries;

import com.trello.core.ApiRequestHandler;
import com.trello.core.RequestManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CountriesTest {

    @Test
    public void getCountriesTest() {
        RequestManager.setRequestSpec("https://countries.trevorblades.com");
        ApiRequestHandler apiRequestHandler = new ApiRequestHandler();
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        apiRequestHandler.setHeaders(headers);
        apiRequestHandler.setBody("{\"query\":\"query Query {\\n  continent(code: \\\"AS\\\") {\\n    code\\n    name\\n    countries {\\n      code\\n      name\\n    }\\n  }\\n}\",\"operationName\":\"Query\"}");
        apiRequestHandler.setEndpoint("/");
        Response response =    RequestManager.post(apiRequestHandler, true);
        Assert.assertTrue(response.body().asString().length() > 0);
        Assert.assertEquals(response.getBody().jsonPath().get("data.continent.countries[0].code"), "AE");
    }
}
