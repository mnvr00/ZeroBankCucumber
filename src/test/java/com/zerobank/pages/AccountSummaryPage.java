package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage extends BasePage{
    public AccountSummaryPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(tagName = "h2")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "(//table)[3]//th")
    public List<WebElement> creditAccountHeader;

    public List<String> AccountNames(){
        List<WebElement> options = accountTypes;
        return BrowserUtils.getElementsText(options);
    }

    public List<String> AccountHeaders(){
        List<WebElement> options = creditAccountHeader;
        return BrowserUtils.getElementsText(options);
    }


}
