package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.BrowserUtils;
import com.utilities.WebElementUtils;

public class SettingPage {
	WebDriver driver;
	WebElementUtils elementutil = new WebElementUtils();
	BrowserUtils browserutil = new BrowserUtils();
	BrowserUtils util = new BrowserUtils();

	public SettingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='companyName']")
	WebElement companyname;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement companyphone;
	@FindBy(xpath = "//input[@id='currency']")
	WebElement currencycode;
	@FindBy(xpath = "//input[@id='DefaultDiscount']")
	WebElement defaultdiscount;
	@FindBy(xpath = "(//button[text()='Submit'])[1]")
	WebElement setsubmit;

	public boolean isCompanynameDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, companyname);
		return flag;
	}

	public boolean iscompanyphoneDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, companyphone);
		return flag;
	}

	public boolean iscurrencycodeeDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, currencycode);
		return flag;
	}

	public boolean isdefaultdiscountDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, defaultdiscount);
		return flag;
	}

	public boolean isSetsubmitDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, setsubmit);
		return flag;
	}

	public void enterNameOfCompany(String name) {
		elementutil.clearTheElement(driver, companyname);
		elementutil.enterValueToTheElement(driver, companyname, name);
	}

	public void enterPhonenumberOfCompany(String name) {
		elementutil.clearTheElement(driver, companyphone);
		elementutil.enterValueToTheElement(driver, companyphone, name);
	}

	public void enterCurrencycodeOfCompany(String name) {
		elementutil.clearTheElement(driver, currencycode);
		elementutil.enterValueToTheElement(driver, currencycode, name);

	}

	public void enterDefaultdiscountOfCompany(String name) {
		elementutil.clearTheElement(driver, defaultdiscount);
		elementutil.enterValueToTheElement(driver, defaultdiscount, name);

	}

	public void clickOnsetsubmit() {
		elementutil.clickOnElement(driver, setsubmit);
	}

	
	public void refreshActionOnSetting() {
		util.navigateRefreshPage(driver);

	}

	public void closeTheWindow() {
		browserutil.quitWindow(driver);
	}

}
