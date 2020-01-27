package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class PayBillsPage extends BasePage{

    @FindBy(id = "sp_amount")
    public WebElement amount;

    @FindBy(id = "sp_date")
    public WebElement date;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    public void setAmountDate(String amountStr, String dateStr){
        amount.sendKeys(amountStr);
        date.sendKeys(dateStr);
        payButton.click();
    }

    @FindBy(xpath = "//*[@id=\"alert_content\"]")
    public WebElement paymentMessage;


    public String getAlertMessage(){
        BrowserUtils.waitFor(1);
        Alert alert = Driver.get().switchTo().alert();
        String text = alert.getText();
        alert.accept();

        return text;
    }

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeName;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAdress;

    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccount;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetails;

    @FindBy(id = "add_new_payee")
    public WebElement add;

    @FindBy(id = "pc_currency")
    public WebElement currency;

    public Select getCurrency(){
        return new Select(currency);
    }

    public List<String> getListCurrency(){
        List<String> listOfCurrencies = new ArrayList<>();

        for (int i = 1; i < getCurrency().getOptions().size(); i++) {
             listOfCurrencies.add(getCurrency().getOptions().get(i).getText());
        }

        return listOfCurrencies;
    }

    @FindBy(id = "purchase_cash")
    public WebElement purchase;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCost;

    @FindBy(id = "pc_amount")
    public WebElement amountOfPurchase;

    @FindBy(id = "pc_inDollars_true")
    public WebElement dollarRadioButton;

}
