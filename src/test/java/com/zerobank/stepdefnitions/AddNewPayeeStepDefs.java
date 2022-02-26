package com.zerobank.stepdefnitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.NewPayeePage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefs {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        BrowserUtils.waitFor(1);
        NewPayeePage newPayeePage = new NewPayeePage();
        newPayeePage.PayBillsLink.click();
        BrowserUtils.waitFor(1);
        newPayeePage.AddNewPayee.click();


    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> dataTable) {

        NewPayeePage newPayeePage = new NewPayeePage();
        newPayeePage.PayeeName.sendKeys(dataTable.get("Payee Name"));
        newPayeePage.PayeeAdress.sendKeys(dataTable.get("Payee Address"));
        newPayeePage.Account.sendKeys(dataTable.get("Account"));
        newPayeePage.Details.sendKeys(dataTable.get("Payee details"));
        BrowserUtils.waitFor(1);
        newPayeePage.Add.click();

        newPayeePage.AddNewPayee.click();
        BrowserUtils.waitFor(1);






    }

    @Then("message {string} .should be displayed")
    public void message_should_be_displayed(String string) {

        NewPayeePage newPayeePage = new NewPayeePage();

//        System.out.println(string);
//        System.out.println(new NewPayeePage().AlertContent.getText());

        Assert.assertEquals(string.contains(newPayeePage.AlertContent.getText()),true);


    }


}
