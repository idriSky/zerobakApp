@login
Feature: Login to the application

  Background:
    Given the user is on the Login page

  @positiveLogin
  Scenario: Only authorized users should be able to login to the application
    When the user logs in with valid credentials username "username" and password "password"
    Then "account-summary" page should be displayed.

  @negativeLogin
  Scenario: Users with wrong/blank username or wrong/blank password should not be able to login.
    When the user tries to login with invalid information username "user" and password "pass"
    Then error message "Login and/or password are wrong." should be displayed
