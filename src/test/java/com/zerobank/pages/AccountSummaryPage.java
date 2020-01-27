package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryPage extends BasePage {

    @FindBy(css = ".board-header")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "(//table)[3]/thead//th")
    public List<WebElement> creditAccountsTableColumns;


}
