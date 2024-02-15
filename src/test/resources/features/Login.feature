@LoginTests @Regression
Feature: Login

  Background: Access altoromutual url
    Given I access the Altoro Mutual URL
  
  @TC-001
  Scenario: Login with valid credentials
    When I login with username "jsmith" and password "Demo1234"
    Then I should be in account page

  @TC-002
  Scenario: Try to login with invalid credentials
    When I login with username "abc" and password "abc"
    Then I should see login failed error

  @TC-003
  Scenario: Try to login with empty username and empty password
    When I login with username "" and password ""
    Then I should see a popup with error message "You must enter a valid username"

  @TC-004
  Scenario: Try to login with valid username and empty password
    When I login with username "jsmith" and password ""
    Then I should see a popup with error message "You must enter a valid password"

  @TC-005
  Scenario: Try to login with valid password and empty username
    When I login with username "" and password "Demo1234"
    Then I should see a popup with error message "You must enter a valid username"