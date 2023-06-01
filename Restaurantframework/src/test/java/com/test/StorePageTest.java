package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.StorePage;
import com.utilities.BrowserUtils;
import com.utilities.ExcelUtil;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;

public class StorePageTest extends AutomationBase {

	LoginPage lpage;
	HomePage hpage;
	StorePage spage;
	Properties prop;
	ExcelUtil excelutil;
	PropertyUtil propertyutil = new PropertyUtil();
	BrowserUtils browser = new BrowserUtils();

	@Test(priority = 10, enabled = true, groups = { "Smoke" }, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateElementsOnStore() {
		lpage = new LoginPage(driver);
		prop = propertyutil.getProperty("config.properties");
		excelutil = new ExcelUtil();
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		spage = hpage.navigateTostorePage();
		spage.clickOnAddStore();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(spage.isStoreEmailDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(spage.isStorePhoneDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(spage.isStoreCountryDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(spage.isStoreCityDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(spage.isStoreAddressDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 11, enabled = true, groups = { "Smoke" }, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateAddStoreFunctionality() {
		lpage = new LoginPage(driver);
		prop = propertyutil.getProperty("config.properties");
		excelutil = new ExcelUtil();
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		spage = hpage.navigateTostorePage();
		spage.clickOnAddStore();
		String storename = excelutil.readStringData("store", 1, 2);
		spage.enterNameOfStore(storename);
		String storemail = excelutil.readStringData("store", 2, 2);
		spage.enterEmailOfStore(storemail);
		String storephone = excelutil.readStringData("store", 3, 2);
		spage.enterPhonenumberOfStore(storephone);
		String storecountry = excelutil.readStringData("store", 4, 2);
		spage.enterCountrynameOfStore(storecountry);
		String storecity = excelutil.readStringData("store", 5, 2);
		spage.enterCityNameOfStore(storecity);
		String storeaddress = excelutil.readStringData("store", 6, 2);
		spage.enterAddressOfStore(storeaddress);
		spage.Storesubmit();
		String st = spage.StoreSearch(storename);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(spage.getStorenameFromSearchResults(), "ALFA", AutomationConstants.ErrorMessage);
		soft.assertEquals(spage.getStoreemaileFromSearchResults(), "abcdef@gmail.com",
				AutomationConstants.ErrorMessage);
		soft.assertEquals(spage.getStorephonenumberFromSearchResults(), "12121212", AutomationConstants.ErrorMessage);
		soft.assertEquals(spage.getStorecountryFromSearchResults(), "india", AutomationConstants.ErrorMessage);
		soft.assertEquals(spage.getStorecityFromSearchResults(), "ijk", AutomationConstants.ErrorMessage);
		soft.assertAll();
	}

	@Test(priority = 12, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateDeleteActionOnStore() {
		lpage = new LoginPage(driver);
		prop = propertyutil.getProperty("config.properties");
		excelutil = new ExcelUtil();
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		spage = hpage.navigateTostorePage();
		spage.clickOnAddStore();
		String storename = excelutil.readStringData("store", 7, 2);
		spage.enterNameOfStore(storename);
		String storemail = excelutil.readStringData("store", 8, 2);
		spage.enterEmailOfStore(storemail);
		String storephone = excelutil.readStringData("store", 9, 2);
		spage.enterPhonenumberOfStore(storephone);
		String storecountry = excelutil.readStringData("store", 10, 2);
		spage.enterCountrynameOfStore(storecountry);
		String storecity = excelutil.readStringData("store", 11, 2);
		spage.enterCityNameOfStore(storecity);
		String storeaddress = excelutil.readStringData("store", 12, 2);
		spage.enterAddressOfStore(storeaddress);
		spage.Storesubmit();
		String st = spage.StoreSearch(storename);
		spage.deleteActionOnstore();
		spage.deleteConfirmationOnStore();
		Assert.assertTrue(spage.isInvalidresultFromSearch());
	}

	@Test(priority = 13, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateEditActionOnStore() {
		lpage = new LoginPage(driver);
		prop = propertyutil.getProperty("config.properties");
		excelutil = new ExcelUtil();
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		spage = hpage.navigateTostorePage();
		spage.clickOnAddStore();
		String storename = excelutil.readStringData("store", 13, 2);
		spage.enterNameOfStore(storename);
		String storemail = excelutil.readStringData("store", 14, 2);
		spage.enterEmailOfStore(storemail);
		String storephone = excelutil.readStringData("store", 15, 2);
		spage.enterPhonenumberOfStore(storephone);
		String storecountry = excelutil.readStringData("store", 16, 2);
		spage.enterCountrynameOfStore(storecountry);
		String storecity = excelutil.readStringData("store", 17, 2);
		spage.enterCityNameOfStore(storecity);
		String storeaddress = excelutil.readStringData("store", 18, 2);
		spage.enterAddressOfStore(storeaddress);
		spage.Storesubmit();
		String st = spage.StoreSearch(storename);
		spage.storeEditAction();
		spage.clearActionOnstorename();
		String editstorename = excelutil.readStringData("store", 19, 2);
		spage.enterNameOfStore(editstorename);
		spage.clearActionOnphonenumber();
		String editphone = excelutil.readStringData("store", 20, 2);
		spage.enterPhonenumberOfStore(editphone);
		spage.Storesubmit();
		spage.StoreSearch(storename);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(spage.getStorenameFromSearchResults(), "mcp store", AutomationConstants.ErrorMessage);
		soft.assertEquals(spage.getStoreemaileFromSearchResults(), "abcdef@gmail.com",
				AutomationConstants.ErrorMessage);
		soft.assertEquals(spage.getStorephonenumberFromSearchResults(), "12121212", AutomationConstants.ErrorMessage);
		soft.assertEquals(spage.getStorecountryFromSearchResults(), "india", AutomationConstants.ErrorMessage);
		soft.assertEquals(spage.getStorecityFromSearchResults(), "ijk", AutomationConstants.ErrorMessage);
		soft.assertAll();

	}

	@AfterMethod
	public void postRun() {
		spage.closeTheWindow();
	}
}
