package com.stepdefinitions;

import com.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    
    private final LoginPage loginPage = new LoginPage(Hooks.getDriver());

    @Given("I access the altoromutual url")
    public void iAccessTheAltoromutualURL() {

    }

    @When("I login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String username, String password) {
        
    }

    @Then("I should be in account page")
    public void iShouldBeInAccountPage() {
        
    }
}
