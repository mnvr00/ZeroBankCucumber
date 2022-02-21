@login @All
Feature: User should be able to login

  Scenario: Login as a valid credentials
    Given the user on the login page
    When the user enter valid username and password
    Then Account Summary page should be displayed

  Scenario: Login as a invalid page
    Given the user on the login page
    When the user enter invalid username and password
    Then Error message should be displayed

