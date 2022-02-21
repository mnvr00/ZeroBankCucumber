package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityNavPage;
import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityNavigationStepDef {
    AccountActivityPage accountActivity = new AccountActivityPage();
    LoginStepDef loginStepDef = new LoginStepDef();
    AccountActivityNavPage accountActivityNavPage = new AccountActivityNavPage();

    @Given("the user is logged in")
    public void the_user_is_logged_in() throws InterruptedException {
        loginStepDef.the_user_on_the_login_page();
        loginStepDef.the_user_enter_valid_username_and_password();
        Assert.assertEquals(accountActivity.Title, Driver.get().getTitle());
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String string) {
        accountActivityNavPage.clickTheAccount(string);
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String string) {
        Assert.assertTrue(Driver.get().getTitle().contains(string));
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String string) {
        Select select = new Select(new AccountActivityPage().selectDropDown);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),string);
    }





}
