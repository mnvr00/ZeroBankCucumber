package com.zerobank.step_definitions;

import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FindTransactionsStepDef {
    FindTransactionsPage findTransactionsPage = new FindTransactionsPage();

    @Given("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String string) {
        BrowserUtils.waitFor(2);
        findTransactionsPage.goToFindTransaction(string);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String DateOne, String DateTwo) {
        BrowserUtils.waitFor(2);
        findTransactionsPage.fromDate.clear();
        findTransactionsPage.toDate.clear();
        findTransactionsPage.fromDate.sendKeys(DateOne);
        findTransactionsPage.toDate.sendKeys(DateTwo);
    }

    @When("clicks search")
    public void clicks_search() {
        findTransactionsPage.FindButton.click();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        BrowserUtils.waitFor(2);

        List<Integer> daysInteger= findTransactionsPage.getDaysInteger();
        int startFromDay = findTransactionsPage.getFromDay(fromDate);
        int toDay = findTransactionsPage.getDay(toDate);

        boolean flag = true;
        for (int i=0; i< daysInteger.size(); i++){
            if(!(daysInteger.get(i) >= startFromDay && daysInteger.get(i)<= toDay)){
                flag = false;
                break;
            }
        }
        Assert.assertTrue ("Verify the dates", flag);

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        List<Integer> dayList = findTransactionsPage.getDaysInteger();
        boolean flag = false;

        if(dayList.size()>1){
            if(dayList.get(0)>= dayList.get(dayList.size()-1)){
                flag=true;
            }
        }else if(dayList.size() == 0){
            flag=true;
        }

        Assert.assertTrue("verify the sorted recent order", flag);

    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String exceptDate) {
        List<String> tableDates = BrowserUtils.getElementsText(new FindTransactionsPage().tableDates);
        boolean flag = true;
        for (String tableDate : tableDates) {
            if (tableDate.equals(exceptDate)) {
                flag = false;
            }
        }
        Assert.assertTrue(flag);


    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        BrowserUtils.waitFor(2);
        findTransactionsPage.description.clear();
        findTransactionsPage.description.sendKeys(description);

    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {
        BrowserUtils.waitFor(3);

        List<WebElement> tableDescription = findTransactionsPage.tableDescription;
        List<String> descriptions = BrowserUtils.getElementsText(tableDescription);

        boolean flag = true;
        for(String option : descriptions){
            if(!option.contains(description)){
                flag = false;
                break;
            }
        }
        if (descriptions.size() == 0) {
            flag = false;
        }
        Assert.assertTrue(flag);

    }



    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        BrowserUtils.waitFor(2);
        List<WebElement> depositTable = new FindTransactionsPage().tableDeposits;
        int a=0;
        for (WebElement deposit:depositTable) {
            if(!deposit.getText().isEmpty()){
                a++;
            }
        }
        Assert.assertTrue("verify deposit table", a>1);

    }



    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        BrowserUtils.waitFor(2);
        List<WebElement> withdrawTable = new FindTransactionsPage().tableWithdraw;
        int a=0;
        for(WebElement withdraw : withdrawTable){
            if(!withdraw.getText().isEmpty()){
                a++;
            }
        }
        Assert.assertTrue("Verify the withdraw ", a<=1);

    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        BrowserUtils.waitFor(2);
        Select selectType = findTransactionsPage.selectType();
        selectType.selectByVisibleText(type);
        findTransactionsPage.findButton.click();
        BrowserUtils.waitFor(5);

    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        BrowserUtils.waitFor(2);
        List<WebElement> withTable = new FindTransactionsPage().tableWithdraw;
        int a =0;
        for(WebElement withdraw : withTable){
            if(!withdraw.getText().isEmpty()){
                a++;
            }
        }
        Assert.assertTrue("Verify no withdraw", a == 0);

    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        BrowserUtils.waitFor(2);
        List<WebElement> depositTable = new FindTransactionsPage().tableDeposits;
        int a = 0;
        for(WebElement deposit : depositTable){
            if(!deposit.getText().isEmpty()){
                a++;
            }
        }
        Assert.assertTrue("verify no deposit", a == 0);
    }


    @Then("results table should not only show descriptions containing {string}")
    public void resultsTableShouldNotOnlyShowDescriptionsContaining(String except) {
            List<String> descriptionElements = BrowserUtils.getElementsText(findTransactionsPage.descriptionColumnData);
            for (String descriptionElement : descriptionElements) {
                Assert.assertTrue(descriptionElement.contains(except));
            }
        }


    }



