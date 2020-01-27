@addNewPayee @wip
Feature: Add new payee under pay bills
  Scenario: Add a new payee
    Given the user is on the Login page
    And the user logs in with valid credentials username "username" and password "password"
    And the user navigates to "Pay Bills" module
    And the user navigates to "Add New Payee" module
    When the user creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    Then the message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed