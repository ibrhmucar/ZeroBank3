package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseForeignCurrencyPage {

    public PurchaseForeignCurrencyPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@href='/bank/redirect.html?url=pay-bills.html']")
    public WebElement PayBillsLink;

    @FindBy(xpath = "//a[@href='#ui-tabs-3']")
    public WebElement PurchaseForeignCurrencyPageLink;

    @FindBy(id = "pc_currency")
    public WebElement currencDropDown;

    @FindBy (xpath = "//input[@id='pc_amount']")
    public WebElement amount;

    @FindBy (xpath = "//input[@id='pc_calculate_costs']")
    public WebElement calculate;






}
