package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class findTransactionPage {
    public findTransactionPage() {
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(xpath = "//a[@href='#ui-tabs-2']")
    public WebElement findTransActions;

    @FindBy(xpath = "//input[@id='aa_fromDate']")
    public WebElement fromDate;

    @FindBy(xpath = "//input[@id='aa_toDate']")
    public WebElement toDate;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "((//tbody)[2]//tr//td[1])[1]")
    public WebElement allDateCheck;

    @FindBy(xpath = "//input[@id='aa_description']")
    public WebElement description;

    @FindBy(xpath = "((//tbody)[2]//tr//td[2])")
    public WebElement online;

    @FindBy(xpath = "(//tbody)[2]//tr//td[2]")
    public WebElement office;

    @FindBy(xpath = "//div[@class='well']")
    public WebElement noelement;

    @FindBy(xpath = "((//tbody)[2]//tr//td[3])")
    public WebElement depositt;

    @FindBy(css = "#aa_type")
    public WebElement type;

    //TODO
    public boolean should_only_show_transactions_dates_between_to(String fromDate, String toDate) {

        BrowserUtils.waitForVisibility(Driver.get().findElement(By.id("filtered_transactions_for_account")), 2);

        List<WebElement> days = Driver.get().findElements(By.xpath("((//tbody)[2]//tr//td[1])"));

        BrowserUtils.waitFor(3);


        String day1 = days.get(0).getText();
        String day2 = days.get(1).getText();
        String day3 = days.get(2).getText();

        day1 = day1.replace("-", "");
        day2 = day2.replace("-", "");
        day3 = day3.replace("-", "");

        int day11 = Integer.parseInt(day1);
        int day22 = Integer.parseInt(day2);
        int day33 = Integer.parseInt(day3);


        String fromdate = fromDate.replace("-", "");
        String todate = toDate.replace("-", "");


        int fromdate1 = Integer.parseInt(fromdate);
        int todate1 = Integer.parseInt(todate);


        boolean flag = true;

        if (((fromdate1 <= day11) && (fromdate1 <= day22) && (fromdate1 <= day33)) && ((todate1 >= day11) && (todate1 >= day22) && (todate1 >= day33))) {
            flag = true;
        } else {
            flag = false;
        }

        return flag;
    }

    public boolean results_should_be_sorted_by_most_recent_date() {

        BrowserUtils.waitForVisibility(Driver.get().findElement(By.id("filtered_transactions_for_account")), 2);

        List<WebElement> days = Driver.get().findElements(By.xpath("((//tbody)[2]//tr//td[1])"));

        BrowserUtils.waitFor(3);

        String day1 = days.get(0).getText();
        String day2 = days.get(1).getText();
        String day3 = days.get(2).getText();

        day1 = day1.replace("-", "");
        day2 = day2.replace("-", "");
        day3 = day3.replace("-", "");

        int day11 = Integer.parseInt(day1);
        int day22 = Integer.parseInt(day2);
        int day33 = Integer.parseInt(day3);


        boolean flag = true;

        if (((day11 > day22) && (day11 > day33) && (day22 > day33))) {
            flag = true;
        } else {
            flag = false;
        }

        return flag;

    }

    public boolean nocontains(String date) {

        BrowserUtils.waitForVisibility(Driver.get().findElement(By.id("filtered_transactions_for_account")), 2);

        List<WebElement> days = Driver.get().findElements(By.xpath("((//tbody)[2]//tr//td[1])"));

        BrowserUtils.waitFor(3);

        String day1 = days.get(0).getText();
        String day2 = days.get(1).getText();


        day1 = day1.replace("-", "");
        day2 = day2.replace("-", "");


        int day11 = Integer.parseInt(day1);
        int day22 = Integer.parseInt(day2);

        date = date.replace("-", "");
        int todate1 = Integer.parseInt(date);

        boolean flag = true;
        if ((day11 != todate1) && (day22 != todate1)) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;

    }

    public boolean betweenTwoDays(String fromDate, String toDate) {

        BrowserUtils.waitForVisibility(Driver.get().findElement(By.id("filtered_transactions_for_account")), 2);

        List<WebElement> days = Driver.get().findElements(By.xpath("((//tbody)[2]//tr//td[1])"));

        System.out.println("days.size() = " + days.size());

        BrowserUtils.waitFor(3);

        String day1 = days.get(0).getText();
        String day2 = days.get(1).getText();


        day1 = day1.replace("-", "");
        day2 = day2.replace("-", "");


        int day11 = Integer.parseInt(day1);
        int day22 = Integer.parseInt(day2);


        fromDate = fromDate.replace("-", "");
        toDate = toDate.replace("-", "");

        int fromdate1 = Integer.parseInt(fromDate);
        int todate1 = Integer.parseInt(toDate);


        boolean flag = true;

        if (((fromdate1 <= day11) && (fromdate1 <= day22)) && ((todate1 >= day11) && (todate1 >= day22))) {
            flag = true;
        } else {
            flag = false;
        }

        return flag;
    }


    public boolean showOnly(String string) {
        boolean flag = true;
        String a = " ";

        BrowserUtils.waitForVisibility(Driver.get().findElement(By.id("filtered_transactions_for_account")), 2);
        BrowserUtils.waitFor(2);

        if (string.equals("ONLINE")) {
            a = "((//tbody)[2]//tr//td[2])";
        } else if (string.equals("OFFICE")) {
            a = "(//tbody)[2]//tr//td[2]";
        } else if (string.equals("online")) {
            a = "//div[@class='well']";
        }


        List<WebElement> days = Driver.get().findElements(By.xpath(a));

        if (days.size() > 0) {

            String[] online = new String[days.size()];

            int i = 0;
            for (WebElement day : days) {
                System.out.println(day.getText());
                int b = day.getText().indexOf(" ");
                online[i] = day.getText().substring(0, b);
            }

            if (online[0].contains(string)) {
                flag = true;
            } else {
                flag = false;
            }


            return flag;

        } else if (days.size() == 0) {

            flag = true;
            System.out.println("no ONLINE");
        }


        return flag;


    }

    public boolean showOnlyOfficce(String string) {
        boolean flag = true;

        BrowserUtils.waitForVisibility(Driver.get().findElement(By.id("filtered_transactions_for_account")), 2);

        List<WebElement> days = Driver.get().findElements(By.xpath("(//tbody)[2]//tr//td[2]"));

        String[] online = new String[days.size()];

        int i = 0;
        for (WebElement day : days) {
            System.out.println(day.getText());
            int b = day.getText().indexOf(" ");
            online[i] = day.getText().substring(0, b);
        }

        if (online[0].contains(string)) {
            flag = true;
        } else {
            flag = false;
        }


        return flag;


    }

    public boolean deposit() {

        BrowserUtils.waitFor(2);

        List<String> deposit = BrowserUtils.getElementsText(By.xpath("(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[3]"));


        deposit.remove("");


        int a = deposit.size();

        boolean flag = true;

        if (a >= 1) {
            flag = true;
        } else if (a < 1) {
            flag = false;
        }

        return flag;


    }


    public boolean withDrow() {

        WebElement deposit = Driver.get().findElement(By.xpath("(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[4]"));

        String[] a = new String[1];

        int b = 0;
        b = a.length;


        boolean flag = true;

        if (b == 1) {
            flag = true;
        } else {
            flag = false;
        }

        return flag;


    }


    public boolean selectedDeposit(String string) {


        Select select = new Select(type);


        List<String> depo1;
        List<String> wit1;
        boolean flag = true;
        int a = 0;
        int b = 0;

        if (string.equals("Deposit")) {
            BrowserUtils.waitFor(1);
            select.selectByValue("DEPOSIT");

            depo1 = BrowserUtils.getElementsText(By.xpath("(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[3]"));
            wit1 = BrowserUtils.getElementsText(By.xpath("(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[4]"));


        } else if (string.equals(("Withdrawal"))) {

            BrowserUtils.waitFor(1);
            select.selectByValue("WITHDRAWAL");
            depo1 = BrowserUtils.getElementsText(By.xpath("(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[3]"));
            wit1 = BrowserUtils.getElementsText(By.xpath("(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[4]"));

            wit1.remove("");
            wit1.remove("");

            a = depo1.size();
            b = wit1.size();
        }

        System.out.println(a + " " + b);

        if ((b == 0) && (a >= 1)) {
            flag = true;
        } else if (b == 0) {
            flag = true;
        } else {
            flag = false;
        }

        return flag;

    }

    public boolean zero() {

        Select select = new Select(type);

        WebElement depo1 = Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody//td[3]"));
        String b = depo1.getText();

        int c = b.length();
        System.out.println("c is = " + c);


        boolean flag = true;


        if (b.equals("")) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

}