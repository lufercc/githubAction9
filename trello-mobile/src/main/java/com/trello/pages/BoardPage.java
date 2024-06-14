package com.trello.pages;

import com.trello.appium.AppiumCommonActions;
import org.openqa.selenium.WebElement;

public class BoardPage extends BasePage {
    private String cardLocator = "//android.widget.TextView[@resource-id='com.trello:id/cardText' and @text='%s']";

    public boolean isCardDisplayed(String cardName) {
        WebElement element = AppiumCommonActions.findElementByXpath(String.format(cardLocator, cardName));
        return element.isDisplayed();
    }
}
