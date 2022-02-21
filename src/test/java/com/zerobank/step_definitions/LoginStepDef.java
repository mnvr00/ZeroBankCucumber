package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {
    AccountActivityPage activity = new AccountActivityPage();
    LoginPage loginPage = new LoginPage();

    @Given("the user on the login page")
    public void the_user_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enter valid username and password")
    public void the_user_enter_valid_username_and_password() throws InterruptedException {
      loginPage.login();
    }

    @Then("Account Summary page should be displayed")
    public void account_Summary_page_should_be_displayed() {
        Assert.assertEquals(activity.Title, Driver.get().getTitle());
    }

    @When("the user enter invalid username and password")
    public void the_user_enter_invalid_username_and_password() {
        loginPage.invalidLogin();
    }


    @Then("Error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }
}
