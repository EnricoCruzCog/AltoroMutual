package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TransferFundsPage {

    private WebDriver driver;
    private String url = "https://altoro.testfire.net/bank/transfer.jsp";
    private String transferFundsMenuButton = "MenuHyperLink3";
    private String fromAccountSelectField = "fromAccount";
    private String toAccountSelectField = "toAccount";
    private String transferAmountInput = "transferAmount";
    private String transferButton = "transfer";
    private String transferConfirmationText = "_ctl0__ctl0_Content_Main_postResp";

    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return this.url;
    }

    public void accessTransferFundsPage() {
        driver.findElement(By.id(transferFundsMenuButton)).click();
    }

    public void selectAccounts(String fromAccount, String toAccount) {
        Select fromAccountDropdow = new Select(driver.findElement(By.id(fromAccountSelectField)));
        Select toAccountDropdow = new Select(driver.findElement(By.id(toAccountSelectField)));

        fromAccountDropdow.selectByValue(fromAccount);
        toAccountDropdow.selectByValue(toAccount);
    }

    public void typeTheAmountToTransfer(String amountToTransfer) {
        driver.findElement(By.id(transferAmountInput)).sendKeys(amountToTransfer);
    }

    public void clickOnTransferMoneyButton() {
        driver.findElement(By.id(transferButton)).click();
    }
    
    public String getConfirmationMessage() {
        return driver.findElement(By.id(transferConfirmationText)).getText();
    }

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

}
