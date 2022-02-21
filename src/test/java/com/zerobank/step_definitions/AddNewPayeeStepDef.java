package com.zerobank.step_definitions;

import com.zerobank.pages.AddNewPayePage;
import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class AddNewPayeeStepDef {

    @Given("{string} tab")
    public void tab(String string) {
        PayBillsPage payBillsPage = new PayBillsPage();
        for (WebElement tab: payBillsPage.payBillSubTabs) {
            if (tab.getText().equals(string)) {
                tab.click();
            }
        }

    }

    @Given("create new payee using following information")
    public void create_new_payee_using_following_information(Map<String,String> payeeInfo) {

        AddNewPayePage addNewPayePage = new AddNewPayePage();
        addNewPayePage.payeeName.sendKeys(payeeInfo.get("Payee Name"));
        addNewPayePage.address.sendKeys(payeeInfo.get("Payee Address"));
        addNewPayePage.payeAccount.sendKeys(payeeInfo.get("Account"));
        addNewPayePage.details.sendKeys(payeeInfo.get("Payee Details"));
        addNewPayePage.payeeAdd.click();

    }

    @Then("message The new payee The Law Offices of Hyde, Price @ Scharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {
        AddNewPayePage addNewPayePage = new AddNewPayePage();
        Assert.assertTrue(addNewPayePage.message.isDisplayed());
    }


}
