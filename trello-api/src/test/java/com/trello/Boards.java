package com.trello;

//import io.restassured.RestAssured;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.module.jsv.JsonSchemaValidator;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.HashMap;
//
//import static org.hamcrest.Matchers.equalTo;

public class Boards {
//    RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri("https://api.trello.com").build();
//    String boardId = "";
//    String boardName = "";
//    String apiKey = "";
//    String apiToken = "";

//    @Test(priority = 1)
//    public void test_create_board() throws URISyntaxException {
//        boardName = "at-09-1-TEST-22";
//
//        String endpoint = "/1/boards/?name=" + boardName + "&key=" + apiKey + "&token=" + apiToken;
//
//        var headers = new HashMap<String, String>();
//        headers.put("Content-Type", "application/json");
//
//        var queryParams = new HashMap<String, String>();
//        queryParams.put("key", apiKey);
//        queryParams.put("token", apiToken);
//
//        Response response = RestAssured.given().spec(requestSpec).log().all()
//                .when()
//                .headers(headers)
//                .queryParams(queryParams)
//                .post(new URI(endpoint))
//                .then().log().all().assertThat().statusCode(200)
//                .body(
//                        "name", equalTo(boardName))
//                .extract().response();
//
//        Assert.assertEquals(response.jsonPath().get("name"), boardName);
//        boardId = response.jsonPath().get("id");
//        System.out.println("board id: " + boardId);
//    }
//
//    @Test(priority = 2)
//    public void test_practice() {
//        System.out.println("this is a test");
//        String endpoint = String.format("/1/boards/%s?key=%s&token=%s", boardId, apiKey, apiToken);
//        Response response = RestAssured.given().spec(requestSpec).log().all()
//                .when()
//                .get(endpoint)
//                .then().log().all().assertThat().statusCode(200)
//                .body("id", equalTo(boardId),
//                        "name", equalTo(boardName))
//                .body(
//                        "name", result -> equalTo(boardName))
//                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("get_board_schema.json"))
//                .extract().response();
//        System.out.println(response.body().asString());
//        Assert.assertTrue(response.body().jsonPath().get("name").equals(boardName));
//    }
//
//    @Test(priority = 3)
//    public void test_delete_board() {
//        String endpoint = String.format("/1/boards/%s?key=%s&token=%s", boardId, apiKey, apiToken);
//        Response response = RestAssured.given().spec(requestSpec).log().all()
//                .when()
//                .delete(endpoint)
//                .then().log().all().assertThat().statusCode(200)
//                .extract().response();
//        System.out.println("Delete board response: \n" + response.body().asString());
//        Assert.assertEquals(response.getBody().asString(), "{\"_value\":null}\n");
//    }

}
