Feature: Trello Home Page

  Scenario: User is able to create a card
    Given I am on trello home page
      And I can click on Add button
      And I click on Add Card button
    When I create a "test card" card in "todo" list in "AT-09" board
    Then I should see trello home page
    When I open "AT-09" board
    Then I should see "test card" card