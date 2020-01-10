Feature: Log in to account
    Existing user should be able to log in to account using correct credentials

  Scenario: Log in to account with correct credentials
    Given user navigates to stackoverflow website
    And user clicks on the login button on homepage
    And user enters a valid username
    And user enters a valid password
    When user clicks on the login button
    Then user should be taken to the successful login page