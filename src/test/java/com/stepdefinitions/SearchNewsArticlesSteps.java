package com.stepdefinitions;

import org.junit.Assert;

import com.pages.SearchNewsArticlesPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchNewsArticlesSteps {
    
    SearchNewsArticlesPage searchNewsArticlesPage = new SearchNewsArticlesPage(Hooks.getDriver());

    @Given("I access the Search News Articles page")
    public void iAccessTheSearchNewsArticlesPage() {
        searchNewsArticlesPage.accessTheSearchNewsArticlesPage();
    }

    @When("I type {string} on search input field")
    public void iTypeOnSearchInputField(String query) {
        searchNewsArticlesPage.typeTheKeyword(query);
    }

    @When("I click on Query button")
    public void iClickOnQueryButton() {
        searchNewsArticlesPage.clickOnQueryButton();
    }

    @Then("the corresponding article with the title {string} should be displayed")
    public void theCorrespondingArticleWithTheTitleShouldBeDisplayed(String title) {
        Assert.assertTrue(searchNewsArticlesPage.getQueryResults().contains(title));
    }
}
