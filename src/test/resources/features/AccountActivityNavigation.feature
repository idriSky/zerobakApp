@accountActivityNavigation
Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given the user is on the Login page
    And the user logs in with valid credentials username "username" and password "password"
    When the user navigates to "Account Summary" module

  @savings
  Scenario: Savings account redirect
    And the user clicks on "Savings" link on the Account Summary page
    Then "account-activity" page should be displayed.
    And In the Account drop down default option should be "Savings"

  @brokerage
  Scenario: Brokerage account redirect
    And the user clicks on "Brokerage" link on the Account Summary page
    Then "account-activity" page should be displayed.
    And In the Account drop down default option should be "Brokerage"

  @checking
  Scenario: Checking account redirect
    And the user clicks on "Checking" link on the Account Summary page
    Then "account-activity" page should be displayed.
    And In the Account drop down default option should be "Checking"

  @creditCard @wip
  Scenario: Credit Card account redirect
    And the user clicks on "Credit Card" link on the Account Summary page
    Then "account-activity" page should be displayed.
    And In the Account drop down default option should be "Credit Card"

  @loan
  Scenario: Loan account redirect
    And the user clicks on "Loan" link on the Account Summary page
    Then "account-activity" page should be displayed.
    And In the Account drop down default option should be "Loan"