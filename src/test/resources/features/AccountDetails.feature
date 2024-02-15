@AccountDetails @Regression
Feature: AccountDetails

  Background: Access Account Details in the Altoro Mutual
    Given I access the Altoro Mutual URL
    When I login with username "jsmith" and password "Demo1234"
      
  @TC-006
  Scenario: Access Account Details "800002 Savings"
    When I select the Account Type "800002 Savings"
    Then I should be in "800002 Savings" Account Details Page

  @TC-007
  Scenario: Access Account Details "800003 Checking"
    When I select the Account Type "800003 Checking"
    Then I should be in "800003 Checking" Account Details Page

  @TC-008
  Scenario: Access Account Details "4539082039396288 Credit Card"
    When I select the Account Type "4539082039396288 Credit Card"
    Then I should be in "4539082039396288 Credit Card" Account Details Page

  @TC-009
  Scenario: Try to Access Altoro Gold Visa Application with empty password
    When I click on Here link to apply
     And I login with password "" 
    Then I should see failed error

  @TC-010
  Scenario: Try to Access Altoro Gold Visa Application with incorrect password
    When I click on Here link to apply
     And I login with password "teste123" 
    Then I should see failed error

  @TC-011
  Scenario: Try to Access Altoro Gold Visa Application with correct password
    When I click on Here link to apply
     And I login with password "Demo1234" 
    Then I should see an application page

