package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchNewsArticlesPage {

    private WebDriver driver;
    private String searchNewsArticleMenuButton = "MenuHyperLink4";
    private String queryInputField = "//form/*[@id='query']";
    private String queryButton = "Button1";
    private String queryResults = "QueryXpath";

    public SearchNewsArticlesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void accessTheSearchNewsArticlesPage() {
        driver.findElement(By.id(searchNewsArticleMenuButton)).click();
    }

    public void typeTheKeyword(String query) {
        WebElement queryInput = driver.findElement(By.xpath(queryInputField));
        queryInput.click();
        queryInput.clear();
        queryInput.sendKeys(query);
    }

    public void clickOnQueryButton() {
        driver.findElement(By.id(queryButton)).click();
    }

    public String getQueryResults() {
        return driver.findElement(By.id(queryResults)).getText();
    }

}
