package com.trello.steps;

import com.trello.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TrelloStepdefs {

    private HomePage homePage;

    public TrelloStepdefs(HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("^I am on trello home page$")
    public void iAmOnTrelloHomePage() {
        System.out.println("I am on trello home page");
        Assert.assertTrue(homePage.isAddButtonDisplayed());
    }

    @And("I can click on Add button")
    public void iCanClickOnAddButton() {
        System.out.println("I can click on Add button");
        homePage.clickAddButton();
    }


    @Then("I should see trello home page")
    public void iShouldSeeTrelloHomePage() {
        System.out.println("I should see trello home page");
        Assert.assertTrue(homePage.isAddButtonDisplayed());
    }

    @When("I open {string} board")
    public void iOpenBoard(String boardName) {
        System.out.println("I open " + boardName);
        homePage.openBoard(boardName);
    }


    @And("I click on Add Card button")
    public void iClickOnAddCardButton() {
        homePage.clickAddCardButton();
    }
}
