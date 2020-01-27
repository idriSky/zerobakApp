package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountActivityStepDefs {

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Then("In the Account drop down default option should be {string}")
    public void in_the_Account_drop_down_default_option_should_be(String expectedOption) {
        accountActivityPage.waitUntilLoaderScreenDisappear();
        String actualOption = accountActivityPage.getAccountDropdown().getFirstSelectedOption().getText();

        Assert.assertEquals("In the Account drop down default option should be Savings",expectedOption,actualOption);
    }

    @Then("Account drop down should have the following options:")
    public void account_drop_down_should_have_the_following_options(List<String> expectedOptions) {
        accountActivityPage.waitUntilLoaderScreenDisappear();
        List<String> actualOptions = BrowserUtils.getElementsText(accountActivityPage.getAccountDropdown().getOptions());

        Assert.assertEquals("Account drop down should have the following options: Savings, Checking, Loan, Credit Card, Brokerage",expectedOptions,actualOptions);

    }

    @Then("Transactions table should have column names")
    public void transactions_table_should_have_column_names(List<String> expectedColumns) {
        accountActivityPage.waitUntilLoaderScreenDisappear();
        List<String> actualColumns = BrowserUtils.getElementsText(accountActivityPage.transactionsTableColumns);

        Assert.assertEquals("Transactions table should have column names Date, Description, Deposit,Withdrawal",expectedColumns,actualColumns);
    }

    @When("the user clicks on {string} link on the Account Activity page")
    public void the_user_clicks_on_link_on_the_page(String link) {

        accountActivityPage.find.click();

    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        accountActivityPage.enterDates(fromDate,toDate);
    }

    @Then("the results table should only show transactions dates between {string} to {string}")
    public void the_results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        BrowserUtils.waitFor(3);
        List<String> expectedBetweenDates = accountActivityPage.getBetweenDates(fromDate,toDate);
        List<String> actualBetweenDates = BrowserUtils.getElementsText(accountActivityPage.dateResults);

        Assert.assertTrue("the results table should only show transactions dates between dates", expectedBetweenDates.contains(actualBetweenDates.get(0)));
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        Assert.assertTrue("The results should be sorted by most recent date",accountActivityPage.isDateMostRecent());
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        List<String> dates = BrowserUtils.getElementsText(accountActivityPage.dateResults);
        Assert.assertFalse("the results table should only not contain transactions dated",dates.contains(date));
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String str) {
        accountActivityPage.descriptions.clear();
        accountActivityPage.descriptions.sendKeys(str);
    }

    @Then("the results table should only show descriptions containing {string}")
    public void the_results_table_should_only_show_descriptions_containing(String str) {
        BrowserUtils.waitFor(3);
        for (WebElement element : accountActivityPage.descriptionResults) {
            System.out.println(str +" = " + element.getText());
            Assert.assertTrue("the results table should only show descriptions containing",element.getText().contains(str));
        }
    }

    @Then("the results table should not show descriptions containing {string}")
    public void the_results_table_should_not_show_descriptions_containing(String str) {
        for (WebElement element : accountActivityPage.descriptionResults) {
            Assert.assertFalse("the results table should not show descriptions containing",element.getText().contains(str));
        }
    }

    @Then("the results table should show at least one result under Deposit")
    public void the_results_table_should_show_at_least_one_result_under_deposit() {
        Assert.assertFalse("the results table should show at least one result under Deposit",accountActivityPage.depositResults.isEmpty());
    }

    @Then("the results table should show at least one result under Withdrawal")
    public void the_results_table_should_show_at_least_one_result_under_withdrawal() {
        Assert.assertFalse("the results table should show at least one result under Withdrawal", accountActivityPage.withdrawalResults.isEmpty());
    }

    @When("the user selects type {string}")
    public void the_user_selects_type(String type) {
        accountActivityPage.getTypes().selectByVisibleText(type);
        accountActivityPage.find.click();
        BrowserUtils.waitFor(1);
    }

    @Then("the results table should show no result under Withdrawal")
    public void the_results_table_should_show_no_result_under_withdrawal() {
        BrowserUtils.waitFor(2);
        System.out.println(accountActivityPage.withdrawalResults.size());
        Assert.assertTrue("the results table should show no result under Withdrawal",accountActivityPage.isListEmpty(accountActivityPage.withdrawalResults));
    }

    @Then("the results table should show no result under Deposit")
    public void the_results_table_should_show_no_result_under_deposit() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue("the results table should show no result under Deposit",accountActivityPage.isListEmpty(accountActivityPage.depositResults));
    }

}
