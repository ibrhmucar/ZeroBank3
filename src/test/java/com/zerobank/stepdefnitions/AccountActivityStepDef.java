package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.DashBoardPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.junit.Assert.*;

public class AccountActivityStepDef {

    @Given("the user is logged in")
    public void the_user_is_logged_in() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login();

    }

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
        BrowserUtils.waitFor(3);
        new AccountSummaryPage().savings.click();
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        BrowserUtils.waitFor(1);
        String ExpectedResult = "Account Activity";
        String ActualResult = new AccountSummaryPage().accountActivity.getText();
        assertEquals(ExpectedResult, ActualResult);

    }

    @Then("Account drop down should have Savings selected")
    public void account_drop_down_should_have_Savings_selected() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        Select stateDropDown = new Select(accountSummaryPage.dropMenu);

        String expected = "Savings";
        String actual = stateDropDown.getFirstSelectedOption().getText();
        assertEquals(actual, expected);


    }

    @When("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        BrowserUtils.waitFor(1);
        Driver.get().navigate().refresh();
        accountSummaryPage.brokerageLink.click();


    }

    @Then("Account drop down should have Brokerage selected")
    public void account_drop_down_should_have_Brokerage_selected() {
        BrowserUtils.waitFor(1);
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        Select stateDropDown = new Select(accountSummaryPage.brokerDrop);

        String expected = "Brokerage";
        String actual = stateDropDown.getFirstSelectedOption().getText();
        assertEquals(actual, expected);


    }

    @When("the user clicks on Checking link on the Account Summary page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {

        new AccountSummaryPage().checking.click();


    }

    @Then("Account drop down should have Checking selected")
    public void account_drop_down_should_have_Checking_selected() {

        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        Select stateDropDown = new Select(accountSummaryPage.brokerDrop);

        String expected = "Checking";
        String actual = stateDropDown.getFirstSelectedOption().getText();
        assertEquals(actual, expected);
    }

    @When("the user clicks on Credit card link on the Account Summary page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().creditCard.click();
    }

    @Then("Account drop down should have Credit Card selected")
    public void account_drop_down_should_have_Credit_Card_selected() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        Select stateDropDown = new Select(accountSummaryPage.brokerDrop);

        String expected = "Credit Card";
        String actual = stateDropDown.getFirstSelectedOption().getText();
        assertEquals(actual, expected);
    }

    @When("the user clicks on Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().loan.click();
    }

    @Then("Account drop down should have Loan selected")
    public void account_drop_down_should_have_Loan_selected() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        Select stateDropDown = new Select(accountSummaryPage.brokerDrop);

        String expected = "Loan";
        String actual = stateDropDown.getFirstSelectedOption().getText();
        assertEquals(actual, expected);


    }

    @When("user logs in with valid credentials,")
    public void user_logs_in_with_valid_credentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.navigateToModule("Account Summary", "Account Activity");

    }

    @Then("Account summary page should be displayed")
    public void account_summary_page_should_be_displayed() {
        assertTrue(Driver.get().getTitle().contains("Account Summary"));
        BrowserUtils.waitFor(2);
        LoginPage loginPage = new LoginPage();
        loginPage.dropdownUsername.click();
        BrowserUtils.waitFor(1);
        loginPage.logOut.click();


    }

    @When("Users with wrong username or wrong password should not be able to login")
    public void users_with_wrong_username_or_wrong_password_should_not_be_able_to_login() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        loginPage.logininvalid();

    }

    @Then("error message {string} should be displayed.")
    public void error_message_should_be_displayed(String string) {
        LoginPage loginPage = new LoginPage();
        System.out.println(Driver.get().findElement(By.xpath("//div[@class='alert alert-error']")).getText());
        assertTrue(Driver.get().findElement(By.xpath("//div[@class='alert alert-error']")).getText().contains(string));


    }

    @Then("Account summary page should be displayed2")
    public void account_summary_page_should_be_displayed2() {
        assertTrue(Driver.get().getTitle().contains("Account Summary"));
        BrowserUtils.waitFor(2);
    }

    @Then("Account summary page should have to following account types")
    public void account_summary_page_should_have_to_following_account_types(List dataTable) {

        List<String> pagesName = BrowserUtils.getElementsText(By.xpath("(//div[@class='span12'])[2]//h2"));
        int i = 0;
        for (String s : pagesName) {
            assertEquals(s, dataTable.get(i));
            i++;
        }

        //second and easy way  --- Assert.assertTrue(pagesName.containsAll(dataTable));

    }

    @Then("Credit Accounts table must have columns")
    public void credit_Accounts_table_must_have_columns(List dataTable) {
        List<String> pagesName = BrowserUtils.getElementsText(By.xpath("(//table[@class='table'])[3]//thead//tr//th"));
        int i = 0;
        for (String s : pagesName) {
            assertEquals(s, dataTable.get(i));
            i++;
        }


    }

    @When("Account summary page should be displayed {string}")
    public void account_summary_page_should_be_displayed(String string) {
        SoftAssert softAssertion = new SoftAssert();
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        if (string.contains("Zero - Account Activity")) {
            BrowserUtils.waitFor(1);
            accountSummaryPage.accountActivity.click();
            System.out.println("account");
        } else if (string.contains("Zero - Pay Bills")) {
            BrowserUtils.waitFor(1);
            accountSummaryPage.payBillsLink.click();
            System.out.println("pay");
        }
        BrowserUtils.waitFor(1);
        String ActualResult = Driver.get().getTitle();
        System.out.println(ActualResult);
        Assert.assertTrue(ActualResult.equals(string));


    }

    @Then("Account drop down default option should be Savings")
    public void account_drop_down_default_option_should_be_Savings() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        Select stateDropDown = new Select(accountSummaryPage.dropMenu);

        String expected = "Savings";
        String actual = stateDropDown.getFirstSelectedOption().getText();
        assertEquals(actual, expected);
    }

    @Then("Account drop down should have the following options")
    public void account_drop_down_should_have_the_following_options(List dataTable) {

        List<String> allMenu = BrowserUtils.getElementsText(By.xpath("//div[@class='controls']//option"));

        assertTrue(allMenu.containsAll(dataTable));


    }

    @Then("Transactions table should have column names")
    public void transactions_table_should_have_column_names(List dataTable) {

        List<String> columnsName = BrowserUtils.getElementsText(By.xpath("//table[@class='table table-condensed table-hover']//thead//tr//th"));
        assertTrue(columnsName.containsAll(dataTable));

    }

    @Then("user completes a successful Pay operation, {string} should be displayed.")
    public void user_completes_a_successful_Pay_operation_should_be_displayed(String string) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.payBillsLink.click();
        BrowserUtils.waitFor(1);
        accountSummaryPage.amoount.sendKeys("10");
        accountSummaryPage.date.sendKeys("2012-09-01");
        BrowserUtils.waitFor(1);
        accountSummaryPage.payButton.click();
        assertEquals(accountSummaryPage.paymentMessage.getText(), string);
        BrowserUtils.waitFor(2);

    }


    @When("user tries to make a payment without entering the amount or date {string} should be displayed")
    public void user_tries_to_make_a_payment_without_entering_the_amount_or_date_should_be_displayed(String string) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.date.sendKeys("2012-09-01");
        BrowserUtils.waitFor(2);
        accountSummaryPage.payButton.click();
        Assert.assertTrue(Driver.get().findElement(By.name("amount")).getAttribute("validationMessage").equals(string));
        BrowserUtils.waitFor(1);
        accountSummaryPage.date.clear();
        accountSummaryPage.amoount.sendKeys("10");
        accountSummaryPage.payButton.click();
        BrowserUtils.waitFor(1);
        Assert.assertTrue(Driver.get().findElement(By.name("date")).getAttribute("validationMessage").equals(string));


    }

    @Then("Amount field should not accept alphabetical or special characters. Date field should not accept alphabetical characters.")
    public void amount_field_should_not_accept_alphabetical_or_special_characters_Date_field_should_not_accept_alphabetical_characters() {


      AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
      accountSummaryPage.test();

    }
}


