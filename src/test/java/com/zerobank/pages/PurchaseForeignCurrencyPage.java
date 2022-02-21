package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyPage {

    public PurchaseForeignCurrencyPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@id=\"tabs\"]/ul/li[3]/a")
    public WebElement purchaseModule;

    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement purchaseForeignTab;


    @FindBy(id = "pc_currency")
    public WebElement currencyDropdown;

    @FindBy(id = "pc_amount")
    public WebElement amountBox;

    @FindBy(id = "purchase_cash")
    public WebElement purchase;

    @FindBy(id = "pc_inDollars_true")
    public WebElement DollarButton;

    @FindBy(css = "a[href*='ui-tabs']")
    public List<WebElement> payBillSubTabs;

    /*public List<String> dropDownOptions() {
        /Select stateDropdown = new Select(currencyDropdown);
        List<WebElement> options = stateDropdown.getOptions();
        List<String> allList = new ArrayList<>();
        for (WebElement option : options) {
            allList.add(option.getText());
        }
        System.out.println(allList);
        return allList;

         */


    public Select availableCurrencyList() {
        return new Select(currencyDropdown);
    }





}

