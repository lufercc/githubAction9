package com.trello.apidemos.ios;

import com.trello.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ApiDemosIos extends BasePage {

    public boolean isImageDisplayed() {
        WebElement image = driver.findElement(new By.ByXPath("//XCUIElementTypeImage[@name=\"Image\"]"));
        return image.isDisplayed();
    }
}
