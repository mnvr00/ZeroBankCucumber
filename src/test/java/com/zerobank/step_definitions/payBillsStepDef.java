package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class payBillsStepDef {
    @Then("the user should be able to complete and The payment was successfully submitted. should be displayed  with {string} {string} {string} {string} {string}")
    public void the_user_should_be_able_to_complete_and_The_payment_was_successfully_submitted_should_be_displayed_with(String payee, String account, String amount, String date, String description) {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.forPayee();
        payBillsPage.forAccount();
        payBillsPage.amount.sendKeys(amount);
        payBillsPage.date.sendKeys(date);
        payBillsPage.description.sendKeys(description);
        payBillsPage.Pay.click();
        Assert.assertTrue(payBillsPage.succesfullMessage.isDisplayed());

    }

    @Then("the user should get warning message with {string} {string} {string} {string} {string}")
    public void the_user_should_get_warning_message_with(String payee, String account, String amount, String date, String description) {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.forPayee();
        payBillsPage.forAccount();
        payBillsPage.amount.sendKeys(amount);
        payBillsPage.date.sendKeys(date);
        payBillsPage.description.sendKeys(description);
        payBillsPage.Pay.click();

        String actualMessage ="";
        if (amount.isEmpty()) {
            actualMessage = Driver.get().findElement(By.cssSelector("input[name='amount']")).getAttribute("validationMessage");
        } else if (date.isEmpty()) {
            actualMessage = Driver.get().findElement(By.cssSelector("input[name='date']")).getAttribute("validationMessage");
        }

        String expected = "Please fill in this field.";
        Assert.assertEquals(expected,actualMessage);

    }

    @Then("System should not accept alphabetical or special characters for date and amount fields with {string} {string} {string} {string} {string}")
    public void system_should_not_accept_alphabetical_or_special_characters_for_date_and_amount_fields_with(String payee, String account, String amount, String date, String description) {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.forPayee();
        payBillsPage.forAccount();
        payBillsPage.amount.sendKeys(amount);
        payBillsPage.date.sendKeys(date);
        payBillsPage.description.sendKeys(description);
        payBillsPage.Pay.click();
        Assert.assertTrue(payBillsPage.succesfullMessage.isDisplayed());

    }
}
