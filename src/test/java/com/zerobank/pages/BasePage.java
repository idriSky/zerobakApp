package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = ".brand")
    public WebElement zeroBank;

    @FindBy(id = "searchTerm")
    public WebElement search;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement settings;

    @FindBy(css = "help_link")
    public WebElement help;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[2]")
    public WebElement username;

    @FindBy(css = "logout_link")
    public WebElement logout;

    public String getPageTitle(){
       return Driver.get().getTitle();
    }

    public void navigateToModule(String module) {

        try {
            BrowserUtils.waitForClickablility(By.linkText(module), 5);
            WebElement tabElement = Driver.get().findElement(By.linkText(module));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.linkText(module), 5);
        }
    }

    @FindBy(css = ".board")
    @CacheLookup
    protected WebElement loaderMask;

    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
            wait.until(ExpectedConditions.visibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendTextToElements(WebElement element, String data){
        element.sendKeys(data);
    }

    public WebElement getLinkElement(String link){
        return Driver.get().findElement(By.linkText(link));
    }
}
