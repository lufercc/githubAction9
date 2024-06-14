package com.trello.steps;

import com.trello.apidemos.ios.ApiDemosIos;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ApiDemosIsoStepdefs {
    private ApiDemosIos apiDemosIos;
    public ApiDemosIsoStepdefs(ApiDemosIos apiDemosIos) {
        this.apiDemosIos = apiDemosIos;

    }
   @Then("^I should see super meet boy displayed$")
   public void iSeeImageDisplayed() {
       Assert.assertTrue(apiDemosIos.isImageDisplayed());
   }
}
