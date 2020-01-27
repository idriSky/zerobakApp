package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class PayBillsStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @When("the user completes a successful Pay operation with valid credentials amount {string} and date {string}")
    public void the_user_completes_a_successful_Pay_operation_with_valid_credentials_amount_and_date(String amount, String date) {
        payBillsPage.setAmountDate(amount,date);
    }

    @Then("the message {string} should be displayed")
    public void the_message_should_be_displayed(String expectedPaymentMessage) {
        String actualPaymentMessage = payBillsPage.paymentMessage.getText();

        Assert.assertEquals("The payment was successfully submitted. should be displayed.", expectedPaymentMessage,actualPaymentMessage);

    }

    @When("the user tries to make a payment without entering the amount {string} or date {string}")
    public void the_user_tries_to_make_a_payment_without_entering_the_amount_or_date(String amount, String date) {
        payBillsPage.setAmountDate(amount,date);
    }

    @Then("the alert message {string} should be displayed")
    public void theAlertMessageShouldBeDisplayed(String expectedAlertMessage)  {
        String actualAlertMessage = payBillsPage.amount.getAttribute("validationMessage");
        Assert.assertEquals("the alert message 'Please fill out this field.' should be displayed",expectedAlertMessage, actualAlertMessage);

    }

    @When("the user creates new payee using following information")
    public void the_user_creates_new_payee_using_following_information(Map<String, String> data) {
        System.out.println("DataMapSize = " + data.size());
        System.out.println("data = " + data);

        payBillsPage.sendTextToElements(payBillsPage.payeeName,data.get("Payee Name"));
        payBillsPage.sendTextToElements(payBillsPage.payeeAdress,data.get("Payee Address"));
        payBillsPage.sendTextToElements(payBillsPage.payeeAccount,data.get("Account"));
        payBillsPage.sendTextToElements(payBillsPage.payeeDetails,data.get("Payee details"));

        payBillsPage.add.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedCurrencies) {
        List<String> actualCurrencies = payBillsPage.getListCurrency();

        Assert.assertEquals("following currencies should be available", expectedCurrencies,actualCurrencies);
    }

    @When("the user tries to calculate cost without selecting a currency")
    public void the_user_tries_to_calculate_cost_without_selecting_a_currency() {
        payBillsPage.sendTextToElements(payBillsPage.amountOfPurchase,"100");
        payBillsPage.dollarRadioButton.click();
        payBillsPage.calculateCost.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        String str = payBillsPage.getAlertMessage();
        Assert.assertFalse("error message should be displayed",str.isEmpty());
    }

    @When("the user tries to calculate cost without entering a value")
    public void the_user_tries_to_calculate_cost_without_entering_a_value() {
        payBillsPage.getCurrency().selectByVisibleText("Mexico (peso)");
        payBillsPage.calculateCost.click();
    }

}
