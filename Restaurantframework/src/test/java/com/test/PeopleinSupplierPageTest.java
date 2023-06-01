package com.test;

import java.time.Duration;
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
import com.pages.PeopleinSupplierPage;
import com.utilities.BrowserUtils;
import com.utilities.ExcelUtil;
import com.utilities.PropertyUtil;

public class PeopleinSupplierPageTest extends AutomationBase {
	WebDriver driver;
	LoginPage lpage;
	HomePage hpage;
	PeopleinSupplierPage spage;
	Properties prop;
	ExcelUtil excelutil;
	PropertyUtil propertyutil = new PropertyUtil();
	BrowserUtils browser = new BrowserUtils();

	@Test(priority = 21, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateElementsOnSupplier() {
		lpage = new LoginPage(driver);
		excelutil = new ExcelUtil();
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		spage = hpage.navigateToPeopleinSupplierrPage();
		spage.clickOnSupplierElement();
		spage.clickOnAddSupplierElement();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(spage.isAddSupplierElementDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(spage.isNameOfsupplierDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(spage.isPhonenumberOfSupplierDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(spage.isEmailOfSupplierDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertAll();

	}

	@Test(priority = 22, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateAddsupplierFunctionality() {
		spage.clickOnSupplierElement();
		spage.clickOnAddSupplierElement();
		String suppliername = excelutil.readStringData("supplier", 1, 2);
		spage.enterNameOfSupplier("suppliername");
		String supplierphone = excelutil.readStringData("customer", 2, 2);
		spage.enterPhonenumberOfSupplier("supplierphone");
		String customermail = excelutil.readStringData("customer", 3, 2);
		spage.enterEmailOfSupplier("customermail");
		spage.submitofsupplier();
		spage.enterSearchofsupplierElement("suppliername");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(spage.getSuppliernameFromSearchResults(), "godwin", AutomationConstants.ErrorMessage);
		soft.assertEquals(spage.getsupplierphonenumberFromSearchResults(), "965734123",AutomationConstants.ErrorMessage);
		soft.assertEquals(spage.getsupplieremaileFromSearchResults(), "appu@gmail.com", AutomationConstants.ErrorMessage);
		soft.assertAll();

	}

	@Test(priority = 23, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validatedeletsupplierFunctionality() {
		spage.clickOnSupplierElement();
		spage.clickOnAddSupplierElement();
		String suppliername2 = excelutil.readStringData("supplier", 4, 2);
		spage.enterNameOfSupplier("suppliername2");
		String supplierphone2 = excelutil.readStringData("supplier", 5, 2);
		spage.enterPhonenumberOfSupplier("supplierphone2");
		String suppliermail2 = excelutil.readStringData("supplier", 6, 2);
		spage.enterEmailOfSupplier("suppliermail2");
		spage.submitofsupplier();
		spage.enterSearchofsupplierElement("suppliername2");
		spage.deleteActionOnSupplier();
		spage.deleteConfirmationOnSupplier();
		Assert.assertTrue(spage.isInvalidresultFromSearch());
	}

	@Test(priority =24, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateEditSupplierFunctionality() {
		spage.clickOnSupplierElement();
		spage.clickOnAddSupplierElement();
		String suppliername3 = excelutil.readStringData("customer", 7, 2);
		spage.enterNameOfSupplier("suppliername3");
		String supplierphone3 = excelutil.readStringData("customer", 8, 2);
		spage.enterPhonenumberOfSupplier("supplierphone3");
		String suppliermail3 = excelutil.readStringData("customer", 9, 2);
		spage.enterEmailOfSupplier("suppliermail3");
		spage.submitofsupplier();
		spage.enterSearchofsupplierElement("suppliername3");
		spage.EditActiononSupplier();
		spage.clearActionOnSuppliername();
		String suppliername4 = excelutil.readStringData("customer", 10, 2);
		spage.enterNameOfSupplier("suppliername4");
		spage.submitofsupplier();
		spage.enterSearchofsupplierElement("suppliername4");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(spage.getSuppliernameFromSearchResults(), "kuku", AutomationConstants.ErrorMessage);
		soft.assertEquals(spage.getsupplierphonenumberFromSearchResults(), "9090909090", AutomationConstants.ErrorMessage);
		soft.assertEquals(spage.getsupplieremaileFromSearchResults(), "brijitha@gmail.com",AutomationConstants.ErrorMessage);
		soft.assertAll();
	}
	@AfterMethod
	public void postRun() {
		spage.closeTheWindow();
	}

}
