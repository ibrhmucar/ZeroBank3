package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummaryPage {


    public AccountSummaryPage() {
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(xpath = "//a[@href='/bank/account-activity.html?accountId=1']")
    public WebElement savings;

    @FindBy(xpath = "//a[contains(text(), 'Account Activity')]")
    public WebElement accountActivity;

    @FindBy(xpath = "//select[@id='aa_accountId']")
    public WebElement dropMenu;

    @FindBy(xpath = "//*[@href='/bank/account-activity.html?accountId=6']")
    public WebElement brokerageLink;

    @FindBy(id = "aa_accountId")
    public WebElement brokerDrop;

    @FindBy(xpath = "//*[@href='/bank/account-activity.html?accountId=2']")
    public WebElement checking;

    @FindBy(xpath = "//*[@href='/bank/account-activity.html?accountId=5']")
    public WebElement creditCard;

    @FindBy(xpath = "//*[@href='/bank/account-activity.html?accountId=4']")
    public WebElement loan;

    @FindBy(xpath = "//span[contains(text(), 'The payment was successfully submitted')]")
    public WebElement paymentMessage;

    @FindBy (xpath = "//input[@id='sp_amount']")
    public WebElement amoount;

    @FindBy (xpath = "//input[@id='sp_date']")
    public WebElement date;

    @FindBy (xpath = "//a[@href='/bank/redirect.html?url=pay-bills.html']")
    public WebElement payBillsLink;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement payButton;


    public boolean test(){
        boolean a = true;
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        BrowserUtils.waitFor(1);
        accountSummaryPage.date.clear();
        accountSummaryPage.amoount.clear();
        BrowserUtils.waitFor(2);
        accountSummaryPage.date.sendKeys("aa");
        accountSummaryPage.amoount.sendKeys("##");
        accountSummaryPage.payButton.click();
        BrowserUtils.waitFor(1);
        Assert.assertTrue(Driver.get().findElement(By.name("date")).getAttribute("validationMessage").equals("Please fill out this field."));
        BrowserUtils.waitFor(2);
        accountSummaryPage.amoount.clear();
        accountSummaryPage.date.clear();
        BrowserUtils.waitFor(2);
        accountSummaryPage.amoount.sendKeys("$$½½");
        accountSummaryPage.date.sendKeys("2012-09-02");
        accountSummaryPage.payButton.click();
        BrowserUtils.waitFor(3);
        Assert.assertTrue(Driver.get().findElement(By.name("amount")).getAttribute("validationMessage").equals("Please fill out this field."));
        // System.out.println(Driver.get().findElement(By.name("amount")).getAttribute("validationMessage"));
        //  Assert.assertFalse(accountSummaryPage.paymentMessage.getText().equals("The payment was successfully submitted."));

        return a;

    }


}