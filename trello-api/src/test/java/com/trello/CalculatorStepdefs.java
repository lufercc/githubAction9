package com.trello;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculatorStepdefs {
    private Logger logger = LogManager.getLogger(CalculatorStepdefs.class.getSimpleName());

    @Given("I have a calculator")
    public void iHaveACalculator() {
        logger.info("I have a calculator");
    }

    @When("I add {int} and {int}")
    public void iAddAnd(int arg0, int arg1) {
        logger.info(String.format("%s  + %s ", arg0, arg1));
    }

    @Then("I get result {int}")
    public void iGetResult(int arg0) {
        logger.info("result " + arg0);
    }

    @And("I increase results {int}")
    public void iIncreaseResults(int arg0) {
        logger.info("increase result with " + arg0);
    }
}
