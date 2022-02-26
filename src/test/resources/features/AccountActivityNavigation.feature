
Feature: Navigating to specific accounts in Accounts Activity

  Scenario: Savings account redirect
    Given the user is logged in
    When the user clicks on Savings link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have Savings selected


  Scenario: Brokerage account redirect
    Given the user is logged in
    When the user clicks on Brokerage link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have Brokerage selected

  Scenario: Checking account redirect
    Given the user is logged in
    When the user clicks on Checking link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have Checking selected

  Scenario: Credit Card account redirect
    Given the user is logged in
    When the user clicks on Credit card link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have Credit Card selected

  Scenario: Loan account redirect
    Given the user is logged in
    When the user clicks on Loan link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have Loan selected

  Scenario: Login

    Given the user is logged in
    Then Account summary page should be displayed
    When Users with wrong username or wrong password should not be able to login
    Then error message "Login and/or password are wrong" should be displayed.
@wip
  Scenario: Account Summary
    Given the user is logged in
    When Account summary page should be displayed2
    Then Account summary page should have to following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    Then Credit Accounts table must have columns
      | Account     |
      | Credit Card |
      | Balance     |
@wip
  Scenario: Account Activity
    Given the user is logged in
    When Account summary page should be displayed "Zero - Account Activity"
    Then Account drop down default option should be Savings
    Then Account drop down should have the following options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    Then Transactions table should have column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |

@wip
Scenario: Pay Bills
    Given the user is logged in
    When Account summary page should be displayed "Zero - Pay Bills"
    Then user completes a successful Pay operation, "The payment was successfully submitted." should be displayed.
    When user tries to make a payment without entering the amount or date "Please fill out this field." should be displayed
    Then Amount field should not accept alphabetical or special characters. Date field should not accept alphabetical characters.

