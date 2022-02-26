package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.findTransactionPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class FindTransactionsStepDefs {
    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        BrowserUtils.waitFor(1);
        new AccountSummaryPage().accountActivity.click();
        BrowserUtils.waitFor(1);
        findTransactionPage findTransactionPage = new findTransactionPage();
        findTransactionPage.findTransActions.click();


    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {

        BrowserUtils.waitFor(1);
        findTransactionPage findTransactionPage = new findTransactionPage();
        BrowserUtils.waitFor(2);
        findTransactionPage.fromDate.sendKeys(fromDate);
        findTransactionPage.toDate.sendKeys(toDate);
        BrowserUtils.waitFor(2);


    }

    @When("the user enters date range froms {string} to {string}")
    public void the_user_enters_date_range_froms_to(String fromDate, String toDate) {
        BrowserUtils.waitFor(1);
        findTransactionPage findTransactionPage = new findTransactionPage();
        Driver.get().navigate().refresh();
        BrowserUtils.waitFor(1);
        findTransactionPage.findTransActions.click();
        findTransactionPage.fromDate.sendKeys(fromDate);
        findTransactionPage.toDate.sendKeys(toDate);
    }

    @When("clicks search")
    public void clicks_search() {
        BrowserUtils.waitFor(2);
        new findTransactionPage().submit.click();

    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {

        findTransactionPage findTransactionPage = new findTransactionPage();
        System.out.println(findTransactionPage.should_only_show_transactions_dates_between_to(fromDate, toDate));
        Assert.assertEquals(findTransactionPage.should_only_show_transactions_dates_between_to(fromDate, toDate), true);


    }


    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        findTransactionPage findTransactionPage = new findTransactionPage();
        System.out.println(findTransactionPage.results_should_be_sorted_by_most_recent_date());
        Assert.assertEquals(findTransactionPage.results_should_be_sorted_by_most_recent_date(), true);
        BrowserUtils.waitFor(3);
        findTransactionPage.fromDate.clear();
        BrowserUtils.waitFor(1);


    }


    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        findTransactionPage findTransactionPage = new findTransactionPage();
        System.out.println(findTransactionPage.nocontains(date));
        Assert.assertEquals(findTransactionPage.nocontains(date), true);


    }

    @Then("results table should only show transactions dates betweens {string} to {string}")
    public void results_table_should_only_show_transactions_dates_betweens_to(String fromDate, String toDate) {

        findTransactionPage findTransactionPage = new findTransactionPage();
        System.out.println(findTransactionPage.betweenTwoDays(fromDate, toDate));
        Assert.assertEquals(findTransactionPage.betweenTwoDays(fromDate, toDate), true);


    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        findTransactionPage findTransactionPage = new findTransactionPage();
        BrowserUtils.waitFor(2);
        findTransactionPage.description.sendKeys(string);


    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {

        findTransactionPage findTransactionPage = new findTransactionPage();
        findTransactionPage.showOnly(string);
        Assert.assertEquals(findTransactionPage.showOnly(string), true);
        BrowserUtils.waitFor(2);
        findTransactionPage.description.clear();
        BrowserUtils.waitFor(2);
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        findTransactionPage findTransactionPage = new findTransactionPage();
        System.out.println(findTransactionPage.showOnly(string));
        Assert.assertEquals(findTransactionPage.showOnly(string), true);


    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        findTransactionPage findTransactionPage = new findTransactionPage();
        System.out.println("deposit" + findTransactionPage.deposit());
        Assert.assertEquals(findTransactionPage.deposit(), true);


    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        findTransactionPage findTransactionPage = new findTransactionPage();
        System.out.println("with" + findTransactionPage.withDrow());
        Assert.assertEquals(findTransactionPage.withDrow(), true);

    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        findTransactionPage findTransactionPage = new findTransactionPage();
        if (string.equals("Deposit")) {
            Select select = new Select(findTransactionPage.type);
            select.selectByVisibleText(string);
            BrowserUtils.waitForClickablility(findTransactionPage.submit, 3);
            BrowserUtils.waitFor(1);
            findTransactionPage.submit.click();
            BrowserUtils.waitFor(3);
        } else if (string.equals(("Withdrawal"))) {
            Select select = new Select(findTransactionPage.type);
            select.selectByVisibleText(string);
            BrowserUtils.waitForClickablility(findTransactionPage.submit, 3);
            BrowserUtils.waitFor(1);
            findTransactionPage.submit.click();
            BrowserUtils.waitFor(3);

        }
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        findTransactionPage findTransactionPage = new findTransactionPage();
        System.out.println("no result under withdrawal " + findTransactionPage.selectedDeposit("Withdrawal"));
        Assert.assertEquals(findTransactionPage.selectedDeposit("Withdrawal"), true);

    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        findTransactionPage findTransactionPage = new findTransactionPage();
        findTransactionPage.zero();
        Assert.assertEquals(findTransactionPage.zero(), true);
    }


}
















