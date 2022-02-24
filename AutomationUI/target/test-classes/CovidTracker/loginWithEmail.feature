@run_it
Feature: Login the application with email
  Background:
    Given Person launched the login page


  Scenario: Successful Login with Valid Email and Password
    When Person enters valid Email and Password
    And Person clicks on the Login button

  Scenario Outline: Not valid Login
    When Person enters invalid Email and Password from line <expectedLine>
    And Person clicks on the Login button
    Then Error message is displayed

    Examples: # Add the lines you expect to test from wrongLoginData.csv
      | expectedLine |
      | 1            |
      | 2            |