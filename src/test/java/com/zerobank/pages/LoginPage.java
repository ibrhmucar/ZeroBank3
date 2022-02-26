package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement signin_Button;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement logInButton;


    @FindBy(xpath = "//a[@id='logout_link']")
    public WebElement logOut;

    @FindBy(id = "account_activity_link")
    public WebElement linkCount;

    @FindBy(xpath = "//button[@id='details-button']")
    public WebElement advancedButton;

    @FindBy(xpath = "//a[@id='proceed-link']")
    public WebElement proceedLink;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement invalid;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[2]")
    public WebElement dropdownUsername;

    @FindBy (xpath = "//ul//li//a[@id='logout_link']")
    public WebElement logoutLink;

    @FindBy (xpath = "(//div[@class='span12'])[2]//h2")
    public WebElement linkList;



    public void login() throws InterruptedException {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

        BrowserUtils.waitFor(1);


        LoginPage loginPage = new LoginPage();
        signin_Button.click();

        BrowserUtils.waitFor(1);

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        loginPage.userNameInput.sendKeys("username");
        loginPage.passwordInput.sendKeys("password");

        BrowserUtils.waitFor(1);
        loginPage.logInButton.click();

    /*    advancedButton.click();
        BrowserUtils.waitFor(1);
        proceedLink.click();*/

    }

    public void logininvalid() throws InterruptedException {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

        BrowserUtils.waitFor(1);


        LoginPage loginPage = new LoginPage();
        signin_Button.click();

        BrowserUtils.waitFor(1);


        loginPage.userNameInput.sendKeys("user");
        loginPage.passwordInput.sendKeys("pass");

        BrowserUtils.waitFor(1);
        loginPage.logInButton.click();





    }


}
