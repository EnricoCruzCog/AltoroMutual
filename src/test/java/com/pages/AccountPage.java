package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    WebDriver driver;

    private final String signInLink = "LoginLink";

    public AccountPage(WebDriver driver) { this.driver = driver; }

    public boolean isSignOffLinkDisplayed() {
        String signOffLinkText = driver.findElement(By.id(signInLink)).getText();
        return signOffLinkText.equals("Sign Off");
    }

}