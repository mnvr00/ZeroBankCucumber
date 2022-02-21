package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PayBillsPage {
    public PayBillsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "sp_payee")
    public WebElement payee;

    @FindBy(id = "sp_account")
    public WebElement account;

    @FindBy(id = "sp_amount")
    public WebElement amount;

    @FindBy(id = "sp_date")
    public WebElement date;

    @FindBy(id = "sp_description")
    public WebElement description;

    @FindBy(id = "pay_saved_payees")
    public WebElement Pay;

    @FindBy(id = "alert_content")
    public WebElement succesfullMessage;

    @FindBy(css = "a[href*='ui-tabs']")
    public List<WebElement> payBillSubTabs;


    public void forPayee(){
        Select dropDownelement = new Select(payee);
        dropDownelement.selectByValue("bofa");
    }
    public void forAccount(){
        Select dropdownElement = new Select(account);
        dropdownElement.selectByValue("5");
    }
}
