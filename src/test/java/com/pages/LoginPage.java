package com.pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage {

    WebDriver driver;

    private static String signInLink = "LoginLink";
    private static String usernameField = "uid";
    private static String passwordField = "passw";
    private static String loginButton = "btnSubmit";
    private static String invalidLoginMessage = "_ctl0__ctl0_Content_Main_message";


    public LoginPage(WebDriver driver) { this.driver = driver; }

    public void accessAltoroMutualURL() {
        driver.get("https://demo.testfire.net/");
    }

    public void enterLoginPage() {
        driver.findElement(By.id(signInLink)).click();
    }
    
    public void makeLogin(String username, String password) {
        driver.findElement(By.id(usernameField)).sendKeys(username);
        driver.findElement(By.id(passwordField)).sendKeys(password);
        driver.findElement(By.name(loginButton)).click();
    }


    public void checkInvalid() {
        String currentMessage = driver.findElement(By.id(invalidLoginMessage)).getText();
        Assert.assertEquals(currentMessage, "Login Failed: We're sorry, but this username or password was not found in our system. Please try again.");

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();

    }

}