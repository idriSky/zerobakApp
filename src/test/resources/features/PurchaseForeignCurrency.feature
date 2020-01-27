@purchaseForeignCurrency
Feature: Purchase Foreign Currency

  @availableCurrencies
  Scenario: Available currencies
    Given the user is on the Login page
    And the user logs in with valid credentials username "username" and password "password"
    And the user navigates to "Pay Bills" module
    And the user navigates to "Purchase Foreign Currency" module
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Hong Kong (dollar)    |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Sweden (krona)        |
      | Singapore (dollar)    |
      | Thailand (baht)       |

  @errorCurrency
  Scenario: Error message for not selecting currency
    Given the user is on the Login page
    And the user logs in with valid credentials username "username" and password "password"
    And the user navigates to "Pay Bills" module
    And the user navigates to "Purchase Foreign Currency" module
    When the user tries to calculate cost without selecting a currency
    Then error message should be displayed

  @errorValue
  Scenario: Error message for not entering value
    Given the user is on the Login page
    And the user logs in with valid credentials username "username" and password "password"
    And the user navigates to "Pay Bills" module
    And the user navigates to "Purchase Foreign Currency" module
    When the user tries to calculate cost without entering a value
    Then error message should be displayed