package com.trello.steps;

import com.trello.pages.BoardPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class BoardSteps {
    private BoardPage boardPage;

    public BoardSteps(BoardPage boardPage) {
        this.boardPage = boardPage;
    }

    @Then("I should see {string} card")
    public void iShouldSeeCard(String cardName) {
        System.out.println("I should see " + cardName);

        Assert.assertTrue(boardPage.isCardDisplayed(cardName));
    }
}
