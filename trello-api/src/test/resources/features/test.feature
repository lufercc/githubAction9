
@Calculator
Feature: Calculator

  Background:
    Given I have a calculator


  Scenario: Add two numbers and increase twice
    When I add 2 and 4
#      And I increase results 2
    Then I get result 6

  @Calculator2
  Scenario Outline: Add two number outline
    When I add <x> and <y>
    Then I get result <z>
    Examples:
      | x | y | z |
      | 2 | 4 | 6 |
      | 3 | 3 | 6 |
      | 5 | 1 | 6 |