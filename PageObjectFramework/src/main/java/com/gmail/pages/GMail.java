package com.gmail.pages;

import com.framework.base.ScriptHelper;
import com.framework.util.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GMail extends ScriptHelper {

    String parentWindow = driver.getWindowHandle();

    @FindBy(xpath = "//span[contains(text(),'Your requested https:')]")
    private WebElement riskSenseMail;

    @FindBy(xpath = "//*[@role='gridcell']/div[2]")
    private WebElement mailBody;

    @FindBy(xpath = "//*[@id=':5']/div[2]/div[1]/div/div[2]/div[3]/div")
    private WebElement deleteInividualMailBtn;

    @FindBy(xpath = "//*[@data-tooltip='More']")
    private WebElement moreDotsInMail;

    @FindBy(xpath = "//*[text()='Delete this message']")
    private WebElement deleteThisMailLink;

    @FindBy(xpath = "//span[contains(text(),'Your requested https:')]/preceding::div[@role='checkbox']")
    private WebElement checkBoxOfRiskSenseMail;

    @FindBy(xpath = "//*[text()='no-reply']/../following-sibling::*")
    private WebElement noOfMailsCount;

    @FindBy(xpath = "//*[@id=':5']/div/div[1]/div[1]/div/div/div[2]/div[3]")
    private WebElement deleteBtnInGmailHomePage;

    private boolean isMultipleMailsPresent = false;

    public GMail() {
        PageFactory.initElements(driver, this);
    }

      public GMail loginIntoGmail(String userName, String password) {
//        WebElement signInBtn = driver.findElement(By.xpath("//*[@data-g-label='Sign in']"));
//        signInBtn.click();

        Log.debug("Enter gmail username");
        WebElement userElement = driver.findElement(By.id("identifierId"));
        userElement.sendKeys(userName);

        Log.debug("Click next on gmail username screen");
        driver.findElement(By.id("identifierNext")).click();

        Log.debug("Enter gmail password");
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys(password);
        Log.debug("Click next on gmail password screen");
        driver.findElement(By.id("passwordNext")).click();
        return this;
    }

}
