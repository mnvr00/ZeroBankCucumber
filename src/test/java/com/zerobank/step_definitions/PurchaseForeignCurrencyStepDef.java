package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.pages.PurchaseForeignCurrencyPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PurchaseForeignCurrencyStepDef {

    PurchaseForeignCurrencyPage purchaseForeignCurrencyPage = new PurchaseForeignCurrencyPage();

    @Given("the user accesses the {string} module")
    public void theUserAccessesTheModule(String string) {
        PayBillsPage payBillsPage = new PayBillsPage();
        for (WebElement tab: payBillsPage.payBillSubTabs) {
            if (tab.getText().equals(string)) {
                tab.click();
            }
        }

        }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedList) {

        List<String> list = new ArrayList<>();

        for (WebElement each : purchaseForeignCurrencyPage.availableCurrencyList().getOptions()) {
            if (each.getText().equals("Select One")) {
                continue;
            } else {
                list.add(each.getText());
            }
        }
        Assert.assertEquals(expectedList, list);

    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        BrowserUtils.waitFor(2);
        purchaseForeignCurrencyPage.amountBox.sendKeys("500");
        purchaseForeignCurrencyPage.purchase.click();

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        BrowserUtils.waitFor(2);
        Alert alert = Driver.get().switchTo().alert();
        Assert.assertEquals( "Please, ensure that you have filled all the required fields with valid values.", alert.getText());
        alert.accept();

    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        BrowserUtils.waitFor(2);
        purchaseForeignCurrencyPage.DollarButton.click();
        purchaseForeignCurrencyPage.purchase.click();

    }


}
