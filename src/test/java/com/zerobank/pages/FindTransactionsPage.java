package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class FindTransactionsPage {
    public FindTransactionsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@id='tabs']/ul/li")
    public List<WebElement> findTransaction;

    @FindBy(xpath = "//*[@id='tabs']/ul/li[2]/a")
    public List<WebElement> findTransactions;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(css = "[type=submit]")
    public WebElement FindButton;

    @FindBy(xpath = "(//table)[2]//tbody/tr/td[1]")
    public List<WebElement> tableDates;

    @FindBy(id = "aa_description")
    public WebElement description;

    @FindBy(xpath = "(//table)[2]/tbody//tr/td[3]")
    public List<WebElement> tableDeposits;

    @FindBy(css = ".btn.btn-primary")
    public WebElement findButton;

    @FindBy(id = "aa_type")
    public WebElement typeOfTransaction;

    @FindBy(xpath = "(//table)[2]/tbody//tr/td[4]")
    public List<WebElement> tableWithdraw;

    @FindBy(xpath = "(//table)[2]//tbody/tr/td[2]")
    public List<WebElement> tableDescription;

    @FindBy(xpath ="(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[2]")
    public List<WebElement> descriptionColumnData;



    public List<Integer> getDaysInteger() {
        List<Integer> dayList = new ArrayList<>();
        for (WebElement tableDate : tableDates) {
            String date = tableDate.getText();
            String[] split = date.split("-");
            dayList.add(Integer.parseInt(split[2]));
        }

        return dayList;
    }

    public int getFromDay(String date){
        String[] splitDate = date.split("-");
        int fromDay = Integer.parseInt(splitDate[2]);
        return fromDay;
    }

    public int getDay(String to) {

        String[] split = to.split("-");

        int toDay = Integer.parseInt(split[2]);

        return toDay;
    }

    public Select selectType(){
        Select select = new Select(typeOfTransaction);
        return select;
    }

    public void goToFindTransaction(String moduleName){
        Driver.get().findElement(By.xpath("//*[.='"+moduleName+"']")).click();

    }


}
