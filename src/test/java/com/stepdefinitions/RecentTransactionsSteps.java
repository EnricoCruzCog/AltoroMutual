package com.stepdefinitions;

import org.junit.Assert;

import com.pages.RecentTransactionsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RecentTransactionsSteps {
    
    private RecentTransactionsPage recentTransactionsPage = new RecentTransactionsPage(Hooks.getDriver());

    @When("I access the View Recent Transactions Page")
    public void iAccessTheViewRecentTransactionsPage() {
        recentTransactionsPage.accessRecentTransactionsPage();
    }

    @Then("I should see a {string} operation from account id {string} with amount of {string}")
    public void iShouldSeeAOperationFromAccountIdWithAmountOf(String operation, String account, String amount) {
        Assert.assertTrue(recentTransactionsPage.isTransferOperationDisplayed(operation, account, amount));
    }
}
