package com.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

    WebDriver driver;

    private static String signInLink = "LoginLink";

    public AccountPage(WebDriver driver) { this.driver = driver; }

    public boolean verifySignOffLink() {
        String signOffLinkText = driver.findElement(By.id(signInLink)).getText();
        return signOffLinkText.equals("Sign Off");
    }

}