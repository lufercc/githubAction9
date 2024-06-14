package com.trello.steps;

import io.cucumber.java.en.When;
import com.trello.pages.CreateCardFormPage;

public class CreateCardFormSteps {
    private CreateCardFormPage newCardForm;

    public CreateCardFormSteps(CreateCardFormPage newCardForm) {
        this.newCardForm = newCardForm;
    }

    @When("I create a {string} card in {string} list in {string} board")
    public void iCreateACardInListInBoard(String cardName, String listName, String boardName) {
        System.out.println("I create a card in " + listName + " in " + boardName);
        newCardForm.setBoard(boardName);
        newCardForm.setList(listName);
        newCardForm.setCardName(cardName);
        newCardForm.clickSaveButton();
    }
}
