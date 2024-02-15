package com.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class AccountDetailsPage {

    WebDriver driver;
    WebDriverWait wait;

    private static String hereLink = "//a[@href='apply.jsp']";
    private static String passwordName = "passwd";
    private static String accountField = "listAccounts";
    private static String buttonGo = "//*[@id=\"btnGetAccount\"]";
    private static String buttonSubmit = "Submit";
    private static String msgError = "_ctl0__ctl0_Content_Main_message";
    private static String labelAccountHistory = "body > table:nth-child(4) > tbody > tr > td:nth-child(2) > div > h1";

    public AccountDetailsPage(WebDriver driver) { this.driver = driver; }
   
    public void accessLink () {
        driver.findElement(By.xpath(hereLink)).click();
    }

    public void selectAccountOption(String accountOption) {
        WebElement dropdownElement = driver.findElement(By.id(accountField));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(accountOption);
    }

    public void clickButtonGo () {
        driver.findElement(By.xpath(buttonGo)).click();
    }

    public void validAccountDetailsPage () {
        Assert.assertTrue(driver.findElement(By.cssSelector(labelAccountHistory)).isDisplayed());
    }

    public void accessApplication (String password) {
        driver.findElement(By.name(passwordName)).sendKeys(password);
        driver.findElement(By.name(buttonSubmit)).click();
    }
      
    public void validErrorMessage () {
        String msgErrorTxt = driver.findElement(By.id(msgError)).getText();
        Assert.assertEquals(msgErrorTxt, "Login Failed: We're sorry, but this username or password was not found in our system. Please try again.");
    }
    
}
