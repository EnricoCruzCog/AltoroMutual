package com.stepdefinitions;

import com.pages.AccountDetailsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountDetailsSteps {

    private final AccountDetailsPage accountDetailsPage = new AccountDetailsPage(Hooks.getDriver());

    @When("I select the Account Type {string}")
    public void I_select_the_Account_Type(String accountOption) {
        accountDetailsPage.selectAccountOption(accountOption);
        accountDetailsPage.clickButtonGo();
    }

    @Then("I should be in Account Details Page {string}")
    public void I_should_be_in_Account_Details_Page(String accountNumber) {
        accountDetailsPage.validAccountDetailsPage(accountNumber);
    }

    @When("I login with password {string}")
    public void I_login_with_password(String password) {
        accountDetailsPage.accessApplication(password);
    }

    @When("I click on Here link to apply")
    public void I_click_on_Here_link_to_apply() {
        accountDetailsPage.accessHereLink();    
    }

    @Then("I should see failed error")
    public void I_should_see_failed_error() {
        accountDetailsPage.validErrorMessage();
    }

    @Then("I should see an application page")
    public void I_should_see_an_application_page() {
        // To Be Implemented
    }
  
}
