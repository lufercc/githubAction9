package com.trello.appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class AppiumCommonActions {
    public static WebElement findElementByXpath(String locator) {
        return DriverManager.getInstance().getDriver().findElement(AppiumBy.xpath(locator));
    }

    public static void runJSEScript(String script) {
        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getInstance().getDriver();
        jse.executeScript(script);
    }
}
