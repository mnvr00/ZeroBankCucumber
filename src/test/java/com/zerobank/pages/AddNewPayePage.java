package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewPayePage {


    public AddNewPayePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@href='#ui-tabs-2']")
    public WebElement addNew;

    @FindBy(linkText = "Add New Payee")
    public WebElement newPayeeTab;

    @FindBy(id="np_new_payee_name")
    public WebElement payeeName;

    @FindBy(css ="[name=address]")
    public WebElement address;

    @FindBy(xpath = "//input[@name='account']")
    public WebElement payeAccount;

    @FindBy(css = "[name=details]")
    public WebElement details;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement payeeAdd;

    @FindBy(xpath = "//div[@id='alert_content']")
    public WebElement message;








}
