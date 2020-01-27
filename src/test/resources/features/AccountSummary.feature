@accountSummary
Feature: Account Summary Module Test

  Scenario: Account Summary Module
    Given the user is on the Login page
    And the user logs in with valid credentials username "username" and password "password"
    When the user navigates to "Account Summary" module
    Then Page should have the title "Zero - Account Summary"
    And Account summary page should have to following account types:
      | Cash Accounts | Investment Accounts | Credit Accounts | Loan Accounts |
    And Credit Accounts table must have columns:
      | Account | Credit Card | Balance |
