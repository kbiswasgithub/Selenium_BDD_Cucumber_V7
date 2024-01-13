Feature: Login functionality for OpenCart

  As a user of opencart website
  I want to be able to log in with my account
  so that I can see account details

  Background:
    Given I am on the OpenCart login page

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully

  Scenario Outline: Unsuccessful login with invalid or empty credential
    Given I have entered invalid "<UserName>" and "<Password>"
    When I click on the login button
    Then I should see an error message indicating "<Error_Message>"

    Examples:
      | UserName        | Password | Error_Message                                        |
      | abcd1@gmail.com | abcdef   | Warning: No match for E-Mail Address and/or Password |
      | xyz1@gmail.com  | efgh     | Warning: No match for E-Mail Address and/or Password |
      | test3@gmail.com | test     | Warning: No match for E-Mail Address and/or Password |

  Scenario: Navigate to Forgotten password page
    When I click on the "Forgotten password" Link
    Then I should be redirected to password reset page


