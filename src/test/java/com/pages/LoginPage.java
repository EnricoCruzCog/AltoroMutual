package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    private static String signInLink = "LoginLink";
    private static String usernameField = "uid";
    private static String passwordField = "passw";
    private static String loginButton = "btnSubmit";

    public LoginPage(WebDriver driver) { this.driver = driver; }

    public void accessAltoromutualURL() {
        driver.get("https://demo.testfire.net/");
    }

    public void clickSignInLink() {
        driver.findElement(By.id(signInLink)).click();
    }
    
    public void makeLogin(String username, String password) {
        driver.findElement(By.id(usernameField)).sendKeys(username);
        driver.findElement(By.id(passwordField)).sendKeys(password);
        driver.findElement(By.name(loginButton)).click();
    }

}