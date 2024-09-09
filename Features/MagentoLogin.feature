Feature: Login with Valid Credentials

  @regression
  Scenario: Successful Login with Valid Credentials
    Given the user navigates to login page
    When user click to sign in link
    And user enters email as "keshrichandan9561@gmail.com" and password as "Pass12!@"
    And the user clicks on the Login button
    Then the user should be redirected to the MyAccount Page
