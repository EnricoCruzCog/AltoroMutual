Feature: Transfer Funds

    Background: Access altoromutual url and access Transfer Funds Page
        Given I access the Altoro Mutual URL
        And I login with username "jsmith" and password "Demo1234"
        And I access the Transfer Funds Page
    
    Scenario: Valid transfer between different accounts
        When I select a from account "800003" and a to Account "800002"
        And I type a valid amount to transfer of "1500"
        And click on Transfer Money button
        Then the confirmation message should be displayed "1500.0 was successfully transferred from Account 800003 into Account 800002"
