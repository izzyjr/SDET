Feature: Log in to account
  Existing user should be able to log in to account using correct credentials

  Scenario: Log in to account with correct credentials
    Given user navigates to stackoverflow website two
    And user clicks on the login button on homepage two
    And user enters a valid username two
    And user enters a valid password two
    When user clicks on the login button two
    Then user should be taken to the successful login page two