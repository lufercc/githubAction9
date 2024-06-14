package com.trello.steps.hooks;


import com.trello.appium.AppiumCommonActions;
import com.trello.appium.DriverManager;
import com.trello.appium.Mobile;
import com.trello.utils.PropertiesInfo;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MobileHook {

    private static final Logger LOGGER = LogManager.getLogger(MobileHook.class.getSimpleName());


    @After
    public void tearDown(Scenario scenario) {
        LOGGER.info("After hook for scenario: " + scenario.getName());
        String browserStackStatusMessage = "";
        if (scenario.isFailed()) {
            browserStackStatusMessage = "browserstack_executor: {\"action\": \"setSessionStatus\",\"arguments\": {\"status\": \"failed\", \"reason\": \"TEST FAILED!\"}}";
            LOGGER.info(scenario.getName() + " has failed");
        } else {
            browserStackStatusMessage = "browserstack_executor: {\"action\": \"setSessionStatus\",\"arguments\": {\"status\": \"passed\", \"reason\": \"TEST PASSED!\"}}";
            LOGGER.info(scenario.getName() + " has passed");
        }

        if (PropertiesInfo.getInstance().getPlatformName().equalsIgnoreCase(Mobile.Android_BrowserStack.toString())
                || PropertiesInfo.getInstance().getPlatformName().equalsIgnoreCase(Mobile.Android_BrowserStackIOS.toString())) {

            AppiumCommonActions.runJSEScript(browserStackStatusMessage);
            LOGGER.info("Executed script: " + browserStackStatusMessage);
        }

        DriverManager.getInstance().getDriver().quit();
    }
}

