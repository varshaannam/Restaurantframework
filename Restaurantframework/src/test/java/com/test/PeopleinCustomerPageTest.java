package com.test;

import java.io.IOException;
import java.time.Duration;
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
import com.pages.PeopleinCustomerPage;
import com.pages.PeopleinWaiterPage;
import com.utilities.BrowserUtils;
import com.utilities.ExcelUtil;
import com.utilities.PropertyUtil;

public class PeopleinCustomerPageTest extends AutomationBase {
	WebDriver driver;
	LoginPage lpage;
	HomePage hpage;
	PeopleinCustomerPage cpage;
	Properties prop;
	ExcelUtil excelutil;
	PropertyUtil propertyutil = new PropertyUtil();
	BrowserUtils browser = new BrowserUtils();

	@Test(priority =17, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateElementsOncustomer() {
		lpage = new LoginPage(driver);
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		cpage = hpage.navigateToPeopleinCustomerPage();
		excelutil = new ExcelUtil();
		cpage.clickOnCustomersElement();
		cpage.clickOnAddCustomerElement();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(cpage.isAddcustomerElementDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(cpage.isNameOfcustomerrDisplayed(), AutomationConstants.LinkDisplayCheck );
		soft.assertTrue(cpage.isPhonenumberOfcustomerDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(cpage.isEmailOfcustomerDisplayed(), AutomationConstants.LinkDisplayCheck );
		soft.assertTrue(cpage.isDiscountOfCustomerDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertAll();

	}

	@Test(priority = 18, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateAddcustomerFunctionality() {
		lpage = new LoginPage(driver);
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		cpage = hpage.navigateToPeopleinCustomerPage();
		excelutil = new ExcelUtil();
		cpage.clickOnCustomersElement();
		cpage.clickOnAddCustomerElement();
		String customername = excelutil.readStringData("customer", 1, 2);
		cpage.enterNameOfCustomer(customername);
		String customernum = excelutil.readStringData("customer", 2, 2);
		cpage.enterPhonenumberOfCustomer(customernum);
		String customermail = excelutil.readStringData("customer", 3, 2);
		cpage.enterEmailOfcustomer(customermail);
		String customerdiscount = excelutil.readStringData("customer", 4, 2);
		cpage.enterDiscountOfCustomer(customerdiscount);
		cpage.submitofcustomer();
		cpage.enterSearchofcustomerElement("customername");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(cpage.getcustomerrnameFromSearchResults(), "clint", AutomationConstants.ErrorMessage);
		soft.assertEquals(cpage.getcustomerphonenumberFromSearchResults(),"5123445", AutomationConstants.ErrorMessage);
		soft.assertEquals(cpage.getcustomereremaileFromSearchResults(), "angel@gmail.com", AutomationConstants.ErrorMessage);
		soft.assertEquals(cpage.getDiscountOfcustomerFromSearchResults(), "20", AutomationConstants.ErrorMessage);
		soft.assertAll();
	}

	@Test(priority = 19, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validatedeletcustomerFunctionality() throws IOException {
		lpage = new LoginPage(driver);
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		cpage = hpage.navigateToPeopleinCustomerPage();
		excelutil = new ExcelUtil();
		cpage.clickOnCustomersElement();
		cpage.clickOnAddCustomerElement();
		String customername2 = excelutil.readStringData("customer", 5, 2);
		cpage.enterNameOfCustomer(customername2);
		String customerphone2 = excelutil.readStringData("customer", 6, 2);
		cpage.enterPhonenumberOfCustomer(customerphone2);
		String customeremail2 = excelutil.readStringData("customer", 7, 2);
		cpage.enterEmailOfcustomer(customeremail2);
		String customerdiscount2 = excelutil.readStringData("customer", 8, 2);
		cpage.enterDiscountOfCustomer(customerdiscount2);
		cpage.submitofcustomer();
		cpage.enterSearchofcustomerElement(customername2);
		cpage.deleteActionOncustomer();
		cpage.deleteConfirmationOnCustomer();
		Assert.assertTrue(cpage.isInvalidresultFromSearch());
	}

	@Test(priority = 20, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateEditCustomerFunctionality() {
		lpage = new LoginPage(driver);
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		cpage = hpage.navigateToPeopleinCustomerPage();
		excelutil = new ExcelUtil();
		cpage.clickOnCustomersElement();
		cpage.clickOnAddCustomerElement();
		String customername3 = excelutil.readStringData("customer", 9, 2);
		cpage.enterNameOfCustomer(customername3);
		String customerphone3 = excelutil.readStringData("customer", 10, 2);
		cpage.enterPhonenumberOfCustomer(customerphone3);
		String customermail3 = excelutil.readStringData("customer", 11, 2);
		cpage.enterEmailOfcustomer(customermail3);
		String customerdiscount3 = excelutil.readStringData("customer", 12, 2);
		cpage.enterDiscountOfCustomer(customerdiscount3);
		cpage.submitofcustomer();
		cpage.enterSearchofcustomerElement(customername3);
		cpage.EditActiononCustomer();
		cpage.clearActionOnCustomername();
		String customername4 = excelutil.readStringData("customer", 13, 2);
		cpage.enterNameOfCustomer(customername4);
		cpage.submitofcustomer();
		cpage.enterSearchofcustomerElement(customername4);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(cpage.getcustomerrnameFromSearchResults(), "manu", AutomationConstants.ErrorMessage);
		soft.assertEquals(cpage.getcustomerphonenumberFromSearchResults(), "1012134", AutomationConstants.ErrorMessage);
		soft.assertEquals(cpage.getcustomereremaileFromSearchResults(), "rama@gmail.com",AutomationConstants.ErrorMessage);
		soft.assertEquals(cpage.getDiscountOfcustomerFromSearchResults(), "40", AutomationConstants.ErrorMessage);
		soft.assertAll();

	}
	@AfterMethod
	public void postRun() {
		cpage.closeTheWindow();
	}

}
