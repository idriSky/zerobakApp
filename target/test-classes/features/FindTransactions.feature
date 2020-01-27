@findTransactions
Feature: Find Transactions in Account Activity

  Background:
    Given the user is on the Login page
    And the user logs in with valid credentials username "username" and password "password"
    And the user navigates to "Account Activity" module
    And the user navigates to "Find Transactions" module

  @dateRange
  Scenario: Search date range
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And the user clicks on "Find" link on the Account Activity page
    Then the results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date
    When the user enters date range from "2012-09-02" to "2012-09-06"
    And the user clicks on "Find" link on the Account Activity page
    Then the results table should only show transactions dates between "2012-09-02" to "2012-09-06"
    And the results table should only not contain transactions dated "2012-09-01"

  @description
  Scenario: Search description
    When the user enters description "ONLINE"
    And the user clicks on "Find" link on the Account Activity page
    Then the results table should only show descriptions containing "ONLINE"
    When the user enters description "OFFICE"
    And the user clicks on "Find" link on the Account Activity page
    Then the results table should only show descriptions containing "OFFICE"
    But the results table should not show descriptions containing "ONLINE"
  @descriptionCase
  Scenario: Search description case insensitive
    When the user enters description "ONLINE"
    And the user clicks on "Find" link on the Account Activity page
    Then the results table should only show descriptions containing "ONLINE"
    When the user enters description "online"
    And the user clicks on "Find" link on the Account Activity page
    Then the results table should only show descriptions containing "ONLINE"
  @type
  Scenario: Type
    And the user clicks on "Find" link on the Account Activity page
    Then the results table should show at least one result under Deposit
    Then the results table should show at least one result under Withdrawal
    When the user selects type "Deposit"
    Then the results table should show at least one result under Deposit
    But the results table should show no result under Withdrawal
    When the user selects type "Withdrawal"
    Then the results table should show at least one result under Withdrawal
    But the results table should show no result under Deposit