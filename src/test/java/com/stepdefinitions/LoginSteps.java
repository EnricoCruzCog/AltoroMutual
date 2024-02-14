package com.stepdefinitions;

import com.pages.LoginPage;

import org.junit.Assert;

import com.pages.AccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    
    private final LoginPage loginPage = new LoginPage(Hooks.getDriver());
    private final AccountPage accountPage = new AccountPage(Hooks.getDriver());

    @Given("I access the Altoro Mutual URL")
    public void iAccessTheAltoroMutualURL() {
        loginPage.accessAltoroMutualURL();
    }

    @When("I login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String username, String password) {
        loginPage.enterLoginPage();
        loginPage.makeLogin(username, password);
    }

    @Then("I should be in account page")
    public void iShouldBeInAccountPage() {
        Assert.assertTrue(accountPage.isSignOffLinkDisplayed());
    }

    @Then("I should see login failed error")
    public void iShouldSeeLoginFailedError() {
        loginPage.validInvalidLogin();
    }

    @Then("I should see a popup with error message {string}")
    public void iShouldSeeAPopupWithErrorMessage(String errorMessage) {
        String actualAlertText = loginPage.getAlertText();
        Assert.assertEquals(errorMessage, actualAlertText);
    }



}
