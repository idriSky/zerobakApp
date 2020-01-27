@accountActivity
Feature: Account Activity Module Test
  @wip
  Scenario: Account Activity Module
    Given the user is on the Login page
    And the user logs in with valid credentials username "username" and password "password"
    When the user navigates to "Account Activity" module
    Then Page should have the title "Zero - Account Activity"
    And In the Account drop down default option should be "Savings"
    And Account drop down should have the following options:
      | Savings | Checking | Savings | Loan | Credit Card | Brokerage |
    And Transactions table should have column names
      | Date | Description | Deposit | Withdrawal |