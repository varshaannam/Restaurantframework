package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
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
	PropertyUtil propertyutil = new PropertyUtil();
	BrowserUtils browser = new BrowserUtils();
	GenericUtils genericutil = new GenericUtils();

	@Test(priority = 29, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateElementsOnSetting() {
		lpage = new LoginPage(driver);
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		setpage = hpage.navigateToSettingPage();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(setpage.isCompanynameDisplayed(),AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(setpage.iscompanyphoneDisplayed(),AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(setpage.iscurrencycodeeDisplayed(),AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(setpage.isdefaultdiscountDisplayed(),AutomationConstants.LinkDisplayCheck);
		soft.assertAll();
	}

	@Test(priority =30 , enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateUpdateSettingsInSettingsPage_ByEnteringValuesInTheFieldsProvided() {
		lpage = new LoginPage(driver);
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
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
		Assert.assertNotNull(companyname);
		Assert.assertNotNull(phonenumber);

	}
	@AfterMethod
	public void postRun() {
		setpage.closeTheWindow();
	}
}
