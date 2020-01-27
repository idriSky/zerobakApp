package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the Login page")
    public void the_user_is_on_the_Login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user logs in with valid credentials username {string} and password {string}")
    public void the_user_logs_in_with_valid_credentials_username_and_password(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("{string} page should be displayed.")
    public void page_should_be_displayed(String subtitle) {
        String actualPageSubtitle = Driver.get().getCurrentUrl();

        Assert.assertTrue("Page should be displayed"+Driver.get().getTitle(),actualPageSubtitle.contains(subtitle));
    }


    @When("the user tries to login with invalid information username {string} and password {string}")
    public void the_user_tries_to_login_with_invalid_information(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedErrorMessage) {
        String actualErrorMessage = new LoginPage().errorMessage.getText();

        Assert.assertEquals("error message Login and/or password are wrong should be displayed.",expectedErrorMessage,actualErrorMessage);
    }

}
