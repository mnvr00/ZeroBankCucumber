package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css="div.alert.alert-error")
    public WebElement errorMessage;

    @FindBy(id = "user_login")
    public WebElement usernameBox;

    @FindBy(id = "user_password")
    public WebElement passwordBox;

    @FindBy(name = "submit")
    public WebElement singIn;


    public void login() throws InterruptedException {
        signInBtn.click();
        Thread.sleep(2000);
        usernameBox.sendKeys(ConfigurationReader.get("username"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        singIn.click();
        Driver.get().navigate().back();
        Driver.get().navigate().to("http://zero.webappsecurity.com/bank/account-summary.html");
        BrowserUtils.waitFor(2);
        }

    public void invalidLogin () {
            signInBtn.click();
            usernameBox.sendKeys("jdjdjnf");
            passwordBox.sendKeys("dfdf48458");
            singIn.click();
        }


}
