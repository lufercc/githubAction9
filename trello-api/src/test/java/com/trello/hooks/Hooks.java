package com.trello.hooks;

import com.trello.Context;
import com.trello.core.RequestManager;
import com.trello.services.BoardService;
import com.trello.utils.PropertiesInfo;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {
    private static final Logger LOGGER = LogManager.getLogger(Hooks.class.getSimpleName());

    private ResponseSpecification responseSpec;
    private Context context;
    private BoardService boards;

    public Hooks(Context context, BoardService boards) {
        this.context = context;
        this.boards = boards;
        responseSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Before()
    public void beforeAllHook() {
        System.out.println("This is the before all hook.");
        RequestManager.setRequestSpec(String.format("%s/%s", PropertiesInfo.getInstance().getBaseApi(),
                PropertiesInfo.getInstance().getApiVersion()));
    }

    @Before("@createBoard")
    public void createBoardHook() {
        var boardName = "AT-09 board from hook";
        Response response = boards.createBoard(boardName);
        context.setResponse(response);
        String boardID = response.getBody().path("id");
        context.setProperty("boardId", boardID);
        LOGGER.info(String.format("boardID: %s", boardID));
    }

    @After("@deleteBoard")
    public void deleteBoardHook() {
        String boardId = context.getProperty("boardId");
        LOGGER.info(String.format("BoardId %s from hook ", boardId));


        var response = this.boards.deleteBoard(boardId);
        response.then()
                .spec(responseSpec).extract().response();
        LOGGER.info("Board deleted by hook: ".concat(response.getBody().asPrettyString()));
    }

}
