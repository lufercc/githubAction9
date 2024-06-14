package com.trello.pages;

import com.trello.appium.AppiumCommonActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    @AndroidFindBy(id = "com.trello:id/add_fab")
    private WebElement addButton;

    @AndroidFindBy(id = "com.trello:id/add_card_fab")
    private WebElement addCardButton;

    private String boardLoactor = "//android.widget.TextView[@resource-id='boardName' and @text='%s']";

    public boolean isAddButtonDisplayed() {
        return addButton.isDisplayed();
    }

    public void clickAddButton() {
        addButton.click();
    }

    public void clickAddCardButton() {
        this.addCardButton.click();
    }

    public void openBoard(String boardName) {
        AppiumCommonActions.findElementByXpath(String.format(boardLoactor, boardName)).click();
    }
}
