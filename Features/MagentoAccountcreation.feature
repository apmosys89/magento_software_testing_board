Feature: Account Creation

  @regression
  Scenario: Successful account creation with personal information
    Given the user navigate to account creation page
    When the user enters personal information with
      | firstName       | Chandan                     |
      | lastName        | Kumar                       |
      | email           | keshrichandan9561@email.com |
      | password        | Pass@1234                   |
      | confirmPassword | Pass@1234                   |
    And the user clicks on the Create an Account button
    Then the user should see the account dashboard
    And a success message should be displayed
