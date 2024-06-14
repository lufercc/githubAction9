package com.trello.apidemos;

import com.trello.pages.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;

public class ApiDemosHomePage extends BasePage {


    public void openApp() {
        WebElement appMenuItem = driver.findElement(new AppiumBy.ByAccessibilityId("App"));
        appMenuItem.click();
    }

    public boolean isOptionDisplayed(String optionName) {
        return driver.findElement(AppiumBy.accessibilityId(optionName)).isDisplayed();
    }
}
