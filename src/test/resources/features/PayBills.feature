@payBills
Feature: Pay Bills Module Test

  @positivePayBills
  Scenario: Pay Bills Module
    Given the user is on the Login page
    And the user logs in with valid credentials username "username" and password "password"
    When the user navigates to "Pay Bills" module
    Then Page should have the title "Zero - Pay Bills"
    When the user completes a successful Pay operation with valid credentials amount "100" and date "2020-01-20"
    Then the message "The payment was successfully submitted." should be displayed

  @negativePayBills
  Scenario: Pay Bills Module
    Given the user is on the Login page
    And the user logs in with valid credentials username "username" and password "password"
    When the user navigates to "Pay Bills" module
    Then Page should have the title "Zero - Pay Bills"
    When the user tries to make a payment without entering the amount "" or date ""
    Then the alert message "Please fill out this field." should be displayed