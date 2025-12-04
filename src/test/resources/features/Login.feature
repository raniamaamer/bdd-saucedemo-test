Feature: Feature to test login

  Scenario: checks login is successful
    Given user on login page
    When user enters username and password
    And Clicks on login Button
    Then user is navigated to home page
    And Close the browser