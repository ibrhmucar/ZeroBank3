package com.zerobank.stepdefnitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PurchaseForeignCurrencyPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyStepDef {

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        BrowserUtils.waitFor(1);
        PurchaseForeignCurrencyPage purchaseForeignCurrencyPage = new PurchaseForeignCurrencyPage();
        purchaseForeignCurrencyPage.PayBillsLink.click();
        BrowserUtils.waitFor(1);
        purchaseForeignCurrencyPage.PurchaseForeignCurrencyPageLink.click();
        BrowserUtils.waitForPageToLoad(2);


    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
        PurchaseForeignCurrencyPage purchaseForeignCurrencyPage = new PurchaseForeignCurrencyPage();

        Select select = new Select(purchaseForeignCurrencyPage.currencDropDown); // select dropdown,

        List<String> expected = BrowserUtils.getElementsText(select.getOptions()); // get all list,

        Assert.assertTrue(expected.containsAll(dataTable)); // ask, this list included all dataTable information,


    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {

        PurchaseForeignCurrencyPage purchaseForeignCurrencyPage = new PurchaseForeignCurrencyPage();
        BrowserUtils.waitFor(2);
        purchaseForeignCurrencyPage.amount.sendKeys("10");
        purchaseForeignCurrencyPage.calculate.click();


    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

       Alert alert  = Driver.get().switchTo().alert();
       Assert.assertFalse(alert.getText().isEmpty());


    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {

        PurchaseForeignCurrencyPage purchaseForeignCurrencyPage = new PurchaseForeignCurrencyPage();
        BrowserUtils.waitFor(2);
        purchaseForeignCurrencyPage.amount.sendKeys("");
        purchaseForeignCurrencyPage.calculate.click();


    }

}