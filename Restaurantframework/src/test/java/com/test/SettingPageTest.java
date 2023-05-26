package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SettingPage;
import com.utilities.BrowserUtils;
import com.utilities.GenericUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;

public class SettingPageTest extends AutomationBase {
	LoginPage lpage;
	HomePage hpage;
	SettingPage setpage;
	Properties prop;
	WaitUtils wait;
	PropertyUtil propertyutil = new PropertyUtil();
	BrowserUtils browser = new BrowserUtils();
	GenericUtils genericutil = new GenericUtils();

	@Test(priority = 1, enabled = true)
	public void validateElementsOnSetting() {
		lpage = new LoginPage(driver);
		wait = new WaitUtils();
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		wait.implicitwait(driver, 30);
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		setpage = hpage.navigateToSettingPage();

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(setpage.isCompanynameDisplayed(), "Failure message:companyname is not displayed");
		soft.assertTrue(setpage.iscompanyphoneDisplayed(), "Failure message:companyphone is not displayed");
		soft.assertTrue(setpage.iscurrencycodeeDisplayed(), "Failure message:currencycode is not displayed");
		soft.assertTrue(setpage.isdefaultdiscountDisplayed(), "Failure message:defaultdiscount is not displayed");
		soft.assertAll();

	}

	@Test(priority = 2, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateUpdateSettingsInSettingsPage_ByEnteringValuesInTheFieldsProvided() {
		lpage = new LoginPage(driver);
		wait = new WaitUtils();
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		wait.implicitwait(driver, 30);
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		setpage = hpage.navigateToSettingPage();

		String companyname = genericutil.generateAlphabeticData(7);
		setpage.enterNameOfCompany(companyname);
		String phonenumber = genericutil.generateNumericData(10);
		setpage.enterPhonenumberOfCompany(phonenumber);
		String currencycode = genericutil.generateAlphaNumericData(5);
		setpage.enterCurrencycodeOfCompany(currencycode);
		String defaultdiscount = genericutil.generateNumericData(2);
		setpage.enterDefaultdiscountOfCompany(defaultdiscount);
		setpage.clickOnsetsubmit();
		// setpage.refreshActionOnSetting();
	}

}
