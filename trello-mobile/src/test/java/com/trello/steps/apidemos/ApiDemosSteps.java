package com.trello.steps.apidemos;

import com.trello.apidemos.ApiDemosHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ApiDemosSteps {

    private ApiDemosHomePage apiDemosHomePage;

    public ApiDemosSteps(ApiDemosHomePage apiDemosHomepage) {
        this.apiDemosHomePage = apiDemosHomepage;
    }

    @When("^I click on App$")
    public void iClickOnApp() {
        this.apiDemosHomePage.openApp();
    }

    @Then("I see {string} option")
    public void iSeeMenuOption(String optionName) {
        Assert.assertTrue(this.apiDemosHomePage.isOptionDisplayed(optionName));
    }
}
