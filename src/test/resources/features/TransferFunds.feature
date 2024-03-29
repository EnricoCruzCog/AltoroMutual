@TransferFunds @Regression
Feature: Transfer Funds

    Background: Access altoromutual url and access Transfer Funds Page
        Given I access the Altoro Mutual URL
        And I login with username "jsmith" and password "Demo1234"
        And I access the Transfer Funds Page
    
    @TC-012
    Scenario: Valid transfer between different accounts
        When I select a from account "800003" and a to Account "800002"
        And I type a amount to transfer of "1500"
        And click on Transfer Money button
        Then the confirmation message should be displayed "1500.0 was successfully transferred from Account 800003 into Account 800002"

    @TC-013
    Scenario: Invalid transfer between same accounts
        When I select a from account "800003" and a to Account "800003"
        And I type a amount to transfer of "1500"
        And click on Transfer Money button
        Then a pop-up should display with the message "From Account and To Account fields cannot be the same."

    @TC-014
    Scenario: Transfer with invalid amounts
        When I select a from account "800002" and a to Account "4539082039396288"
        And I type a amount to transfer of <amount>
        And click on Transfer Money button
        Then a pop-up should display with the message "Transfer Amount must be a number greater than 0."

        Examples:
            |   amount  |
            |   ""      |
            |   "0"     |
            |   "-1"    |