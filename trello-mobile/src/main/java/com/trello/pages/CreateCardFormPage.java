package com.trello.pages;

import com.trello.appium.AppiumCommonActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CreateCardFormPage extends BasePage {
    @AndroidFindBy(id = "com.trello:id/board_selection")
    public WebElement selectBoard;
    @AndroidFindBy(id = "com.trello:id/list_selection")
    public WebElement selectList;
    @AndroidFindBy(id = "com.trello:id/card_name_input")
    public WebElement cardName;
    @AndroidFindBy(id = "com.trello:id/confirm")
    public WebElement saveButton;
    private String boardNameLocator = "//android.widget.TextView[@resource-id='com.trello:id/board_name' and @text='%s']";
    private String listOptionFormat = "//android.widget.TextView[@resource-id='com.trello:id/list_name' and @text='%s']";

    public void setBoard(String boardName) {
        selectBoard.click();
        WebElement boardOption = AppiumCommonActions.findElementByXpath(String.format(boardNameLocator, boardName));
        boardOption.click();
    }

    public void setList(String listName) {
        this.selectList.click();
        WebElement listOption = AppiumCommonActions.findElementByXpath(String.format(listOptionFormat, listName));
        listOption.click();
    }

    public void setCardName(String cardName) {
        this.cardName.clear();
        this.cardName.sendKeys(cardName);
    }

    public void clickSaveButton() {
        this.saveButton.click();
    }
}
