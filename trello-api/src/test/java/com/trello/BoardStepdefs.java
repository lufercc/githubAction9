package com.trello;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import com.trello.services.BoardService;

public class BoardStepdefs {
    private String boardName;
    private Response response;
    private Context context;
    private BoardService boardService;

    public BoardStepdefs(Context context, BoardService boardService) {
        this.context = context;
        this.boardService = boardService;
    }

    @Given("I set board name {string}")
    public void iSetBoardName(String arg0) {
        this.boardName = arg0;
    }

    @When("I send create board request")
    public void iSendCreateBoardRequest() {

        this.response = boardService.createBoard(this.boardName);
        this.context.setProperty("boardId", response.jsonPath().get("id"));
    }

    @Then("I get status code {int}")
    public void iGetStatusCode(int statusCode) {
        int actualStatusCode = this.response.statusCode();
        Assert.assertEquals(statusCode, actualStatusCode);
    }

    @And("I see that board name is {string}")
    public void iSeeThatBoardNameIs(String expectedBoardName) {
        String actualBoardName = this.response.getBody().jsonPath().get("name");
        Assert.assertEquals(expectedBoardName, actualBoardName);
    }

    @When("I get the board based on {string}")
    public void iGetTheBoardBasedOn(String contextKey) {
        var boardId = this.context.getProperty(contextKey);
        response = boardService.getBoard(boardId);
    }

    @When("I send delete board based on {string}")
    public void iSendDeleteBoardBasedOn(String contextKey) {
        var boardId = this.context.getProperty(contextKey);
        response = boardService.deleteBoard(boardId);
    }

    @And("I see that response body is {string}")
    public void iSeeThatResponseBodyIs_value(String body) {
        Assert.assertEquals(response.getBody().asString().strip(), body);
    }
}
