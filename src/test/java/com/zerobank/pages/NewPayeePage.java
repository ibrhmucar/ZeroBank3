package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPayeePage {

    public NewPayeePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@href='/bank/redirect.html?url=pay-bills.html']")
    public WebElement PayBillsLink;

    @FindBy(xpath = "//a[@href='#ui-tabs-2']")
    public WebElement AddNewPayee;

    @FindBy(xpath = "//input[@id='np_new_payee_name']")
    public WebElement PayeeName;

    @FindBy(xpath = "//textarea[@id='np_new_payee_address']")
    public WebElement PayeeAdress;

    @FindBy(xpath = "//input[@id='np_new_payee_account']")
    public WebElement Account;

    @FindBy(xpath = "//input[@id='np_new_payee_details']")
    public WebElement Details;

    @FindBy(xpath = "//input[@value='Add']")
    public WebElement Add;

    @FindBy (xpath =  "//div[@id='alert_content']")
    public WebElement AlertContent;
}
