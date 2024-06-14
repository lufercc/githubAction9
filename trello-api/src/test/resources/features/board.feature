@Board
Feature: Trello Board

  @Board_001 @deleteBoard
  Scenario: Create a board
    Given I set board name "qa-automation"
    When I send create board request
    Then I get status code 200
      And I see that board name is "qa-automation"

  @Board_002 @createBoard @deleteBoard
  Scenario: Get a board
    When I get the board based on "boardId"
    Then I get status code 200
      And I see that board name is "AT-09 board from hook"

  @Board_003 @createBoard
  Scenario: Get a board
    When I send delete board based on "boardId"
    Then I get status code 200
      And I see that response body is "{\"_value\":null}"

