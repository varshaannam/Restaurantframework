package com.test;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SettingPage;
import com.pages.StorePage;
import com.utilities.BrowserUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;

public class SettingPageTest extends AutomationBase {
	WebDriver driver;
	LoginPage lpage;
	HomePage hpage;
	SettingPage setpage;
	Properties prop;
	WaitUtils wait;
	PropertyUtil propertyutil = new PropertyUtil();
	BrowserUtils browser = new BrowserUtils();

	@BeforeMethod
	public void preRun() throws Exception {
		driver = getDriver();
		lpage = new LoginPage(driver);
		wait = new WaitUtils();
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		wait.implicitwait(driver, 30);
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		setpage = hpage.navigateToSettingPage();
	}

	@Test(priority = 1, enabled = true)
	public void validateElementsOnSetting() {
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(setpage.isCompanynameDisplayed(), "Failure message:companyname is not displayed");
		soft.assertTrue(setpage.iscompanyphoneDisplayed(), "Failure message:companyphone is not displayed");
		soft.assertTrue(setpage.iscurrencycodeeDisplayed(), "Failure message:currencycode is not displayed");
		soft.assertTrue(setpage.isdefaultdiscountDisplayed(), "Failure message:defaultdiscount is not displayed");
		soft.assertAll();

	}

	@Test(priority = 2, enabled = true, dataProvider = "dataSupplierProduct", dataProviderClass = DataSupplier.class)
	public void login(String companyname, String phonenumber, String currencycode, String defaultDiscount) {

		setpage.enterNameOfCompany(companyname);
		setpage.enterPhonenumberOfCompany(phonenumber);
		setpage.enterCurrencycodeOfCompany(currencycode);
		setpage.enterDefaultdiscountOfCompany(defaultDiscount);
		setpage.clickOnsetsubmit();
		setpage.refreshActionOnSetting();
	}

}



