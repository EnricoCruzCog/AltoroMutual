package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecentTransactionsPage {

    WebDriver driver;

    private final String recentTransactionsLink = "MenuHyperLink2";
    private final String recentTransactionsTable = "//table[@id='_ctl0__ctl0_Content_Main_MyTransactions']/tbody/";

    public RecentTransactionsPage(WebDriver driver) { this.driver = driver; }

    public void accessRecentTransactionsPage() {
        driver.findElement(By.id(recentTransactionsLink)).click();
    }

    public boolean isTransferOperationDisplayed(String operationExpected, String accountExpected, String amountExpected) {
        String type = "";
        if(operationExpected.equals("Withdrawal")) {
            type = "3";
        } else if(operationExpected.equals("Deposit")) {
            type = "2";
        }

        String operationActual = driver.findElement(By.xpath(recentTransactionsTable + "/tr["+type+"]/td[4]")).getText();
        String accountActual = driver.findElement(By.xpath(recentTransactionsTable + "/tr["+type+"]/td[3]")).getText();
        String amountActual = driver.findElement(By.xpath(recentTransactionsTable + "/tr["+type+"]/td[5]")).getText();

        return operationActual.equals(operationExpected)
               && accountActual.equals(accountExpected)
               && amountActual.equals(amountExpected);
    }    
}
