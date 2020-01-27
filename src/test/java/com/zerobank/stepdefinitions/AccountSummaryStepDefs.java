package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class AccountSummaryStepDefs {

    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @When("the user navigates to {string} module")
    public void the_user_navigates_to_module(String module) {
        accountSummaryPage.waitUntilLoaderScreenDisappear();
        accountSummaryPage.navigateToModule(module);
    }

    @Then("Page should have the title {string}")
    public void page_should_have_the_title(String expectedPageTitle) {
        String actualPageTitle = Driver.get().getTitle();

        Assert.assertEquals("Account summary page should have the title Zero – Account summary", expectedPageTitle, actualPageTitle);
    }

    @Then("Account summary page should have to following account types:")
    public void account_summary_page_should_have_to_following_account_types(List<String> expectedAccountTypes) {
        List<String> actualAccountTypes = BrowserUtils.getElementsText(accountSummaryPage.accountTypes);

        Assert.assertEquals("Account summary page should have to following account types",expectedAccountTypes,actualAccountTypes);
    }

    @Then("Credit Accounts table must have columns:")
    public void credit_Accounts_table_must_have_columns(List<String> expectedColumns) {
        List<String> actualColumns = BrowserUtils.getElementsText(accountSummaryPage.creditAccountsTableColumns);

        Assert.assertEquals("Accounts table must have columns 'Account Credit Card and Balance'",expectedColumns,actualColumns);
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_page(String link) {
        accountSummaryPage.waitUntilLoaderScreenDisappear();

        accountSummaryPage.getLinkElement(link).click();
    }
}
