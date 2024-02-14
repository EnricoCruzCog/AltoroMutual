package com.stepdefinitions;

import org.junit.Assert;

import com.pages.TransferFundsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransferFundsSteps {
    
    private TransferFundsPage transferFundsPage = new TransferFundsPage(Hooks.getDriver());

    @Given("I access the Transfer Funds Page")
    public void iAccessTheTransferFundsPage() {
        transferFundsPage.accessTransferFundsPage();
    }

    @When("I select a from account {string} and a to Account {string}")
    public void iSelectAFromAccountAndADifferentToAccount(String fromAccount, String toAccount) {
        transferFundsPage.selectAccounts(fromAccount, toAccount);
    }

    @When("I type a valid amount to transfer of {string}")
    public void iTypeAValidAmount(String amountToTransfer) {
        transferFundsPage.typeTheAmountToTransfer(amountToTransfer);
    }

    @When("click on Transfer Money button")
    public void clickOnTransferMoney() {
        transferFundsPage.clickOnTransferMoneyButton();
    }

    @Then("the confirmation message should be displayed {string}")
    public void theConfirmationMessageShouldBeDisplayed(String expectedConfirmationMessage) {
        Assert.assertTrue(transferFundsPage.getConfirmationMessage().contains(expectedConfirmationMessage));
    }

    @Then("a pop-up should display with the message {string}")
    public void a_pop_up_should_display_with_the_message(String expectedAlertMessage) {
        String actualAlertText = transferFundsPage.getAlertText();
        Assert.assertEquals(expectedAlertMessage, actualAlertText);
    }
}
