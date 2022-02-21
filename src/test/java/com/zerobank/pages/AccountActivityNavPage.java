package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountActivityNavPage extends AccountActivityPage {
    @FindBy(id = "aa_accountId")
    public WebElement selectDropDown;

    @FindBy(xpath = "(//tr[1]/td[1])[2]")
    public WebElement brokerage;

    @FindBy(xpath = "(//tr[1]/td[1])[1]")
    public WebElement savings;

    @FindBy(xpath = "//tr/td[1]")
    public List<WebElement> allAccounts;


    public void clickTheAccount(String accountName){
        Driver.get().findElement(By.xpath("//td/a[.='"+accountName+"']")).click();
    }


}
