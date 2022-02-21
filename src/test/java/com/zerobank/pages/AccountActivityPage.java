package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityPage extends BasePage {
    public AccountActivityPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@id=\"account_activity_tab\"]/a")
    public WebElement Activity;

    @FindBy(id = "aa_accountId")
    public WebElement selectDropDown;

    @FindBy(tagName = "th")
    public List<WebElement> transactionHeaders;

    @FindBy(id = "aa_accountId")
    public WebElement accountDrop;

    @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> tableColumn;

    @FindBy(id = "aa_type")
    public WebElement types;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findButton;

    public String Title = "Zero - Account Summary";


    public void goToModule(String moduleName) throws InterruptedException {
        Driver.get().findElement(By.xpath("//a[.='"+moduleName+"']")).click();
        Thread.sleep(1000);
    }

    public List<String> dropDownOptions() {
        Activity.click();
        Select stateDropdown = new Select(selectDropDown);
        List<WebElement> options = stateDropdown.getOptions();
        List<String> allList = new ArrayList<>();
        for (WebElement option : options) {
            allList.add(option.getText());
        }
        System.out.println(allList);
        return allList;
    }




}