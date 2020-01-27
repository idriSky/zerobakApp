package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(css = ".input-xlarge")
    public WebElement accountDropdown;

    public Select getAccountDropdown(){
        return new Select(accountDropdown);
    }

    @FindBy(xpath = "//table/thead//th")
    public List<WebElement> transactionsTableColumns;

    @FindBy(id = "aa_description")
    public WebElement descriptions;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    public void enterDates(String fromDateStr, String toDateStr){
        fromDate.clear();
        fromDate.sendKeys(fromDateStr);
        toDate.clear();
        toDate.sendKeys(toDateStr);
    }

    @FindBy(css = ".btn.btn-primary")
    public WebElement find;

    @FindBy(xpath = "(//table)[2]/tbody/tr/td[1]")
    public List<WebElement> dateResults;

    @FindBy(xpath = "(//table)[2]/tbody/tr/td[2]")
    public List<WebElement> descriptionResults;

    @FindBy(xpath = "(//table)[2]/tbody/tr/td[3]")
    public List<WebElement> depositResults;

    @FindBy(xpath = "(//table)[2]/tbody/tr/td[4]")
    public List<WebElement> withdrawalResults;

    public boolean isListEmpty(List<WebElement> list){
        boolean flag = false;
        for (WebElement element : list) {
            if(element.getText().equals("")){
                flag = true;
            }else{
                flag = false;
            }
        }
        return flag;
    }

    @FindBy(css = ".well")
    public WebElement noResult;

    @FindBy(id = "aa_type")
    public WebElement type;

    public Select getTypes(){
        return new Select(type);
    }

    public boolean isDateMostRecent(){
        ArrayList<String> listDates = new ArrayList<>();

        for (WebElement dateResult : dateResults) {
            listDates.add(dateResult.getText());
        }

        ArrayList<String> sortedListDates = new ArrayList<>(listDates);

        Collections.sort(sortedListDates);
        Collections.reverse(sortedListDates);

        return sortedListDates.equals(listDates);
    }

    public List<String> getBetweenDates(String fromDateStr, String toDateStr){
        LocalDate fromDate = LocalDate.parse(fromDateStr);
        LocalDate toDate = LocalDate.parse(toDateStr);

        List<LocalDate> totalDates = new ArrayList<>();
        while (!fromDate.isAfter(toDate)) {
            totalDates.add(fromDate);
            fromDate = fromDate.plusDays(1);
        }

        List<String> dates = new ArrayList<>();

        for (LocalDate totalDate : totalDates) {
            dates.add(totalDate.toString());
        }

        return dates;
    }

}
