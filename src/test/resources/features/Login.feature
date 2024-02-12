Feature: Login

  Scenario: Login with valid credentials
    Given I access the altoromutual url
    When I login with username "jsmith" and password "Demo1234"
    Then I should be in account page