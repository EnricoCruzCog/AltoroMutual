package com.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class AccountDetailsPage {

    WebDriver driver;

    public AccountDetailsPage(WebDriver driver) { this.driver = driver; }
    
    private final String hereLink = "//a[@href='apply.jsp']";
    private final String passwordName = "passwd";
    private final String accountField = "listAccounts";
    private final String buttonGo = "//*[@id=\"btnGetAccount\"]";
    private final String buttonSubmit = "Submit";
    private final String msgError = "_ctl0__ctl0_Content_Main_message";
    private final String labelAccountHistory = "h1";

    public void accessHereLink () throws InterruptedException {
        driver.findElement(By.xpath(hereLink)).click();
        Thread.sleep(1000);
    }

    public void selectAccountOption(String accountOption) throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id(accountField));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(accountOption);
        Thread.sleep(1000);
    }

    public void clickButtonGo () {
        driver.findElement(By.xpath(buttonGo)).click();
    }

    public void validAccountDetailsPage (String accountNumber) {
        String actualMessage = driver.findElement(By.tagName(labelAccountHistory)).getText();
        Assert.assertTrue(actualMessage.contains(accountNumber));
    }

    public void accessApplication (String password) {
        driver.findElement(By.name(passwordName)).sendKeys(password);
        driver.findElement(By.name(buttonSubmit)).click();
    }
      
    public void validErrorMessage () throws InterruptedException {
        String msgErrorTxt = driver.findElement(By.id(msgError)).getText();
        Assert.assertEquals(msgErrorTxt, "Login Failed: We're sorry, but this username or password was not found in our system. Please try again.");
        Thread.sleep(1000);
    }
    
}
