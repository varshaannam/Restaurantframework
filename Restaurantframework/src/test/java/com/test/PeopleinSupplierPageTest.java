package com.test;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PeopleinCustomerPage;
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

	@BeforeMethod
	public void preRun() throws Exception {
		driver = getDriver();
		// hpage=new HomePage(driver);
		lpage = new LoginPage(driver);
		// hpage=new HomePage(driver);
		excelutil = new ExcelUtil();

		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		spage = hpage.navigateToPeopleinSupplierrPage();

	}

	@Test(priority = 1, enabled = true)
	public void validateElementsOnSupplier() throws InterruptedException {
		spage.clickOnSupplierElement();
		spage.clickOnAddSupplierElement();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(spage.isAddSupplierElementDisplayed(), "Failure message:addsupplier is not displayed");
		soft.assertTrue(spage.isNameOfsupplierDisplayed(), "Failure message:nameofCustomer is not displayed");
		soft.assertTrue(spage.isPhonenumberOfSupplierDisplayed(), "Failure message:phonenumber is not displayed");
		soft.assertTrue(spage.isEmailOfSupplierDisplayed(), "Failure message:email is not displayed");
		soft.assertAll();

	}

	@Test(priority = 2, enabled = true)
	public void validateAddsupplierFunctionality() throws IOException {
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
		soft.assertEquals(spage.getSuppliernameFromSearchResults(), "godwin",
				"Failure message:customername is not match");
		soft.assertEquals(spage.getsupplierphonenumberFromSearchResults(), "965734123",
				"Failure message:customeremail is not match");
		soft.assertEquals(spage.getsupplieremaileFromSearchResults(), "appu@gmail.com",
				"Failure message:customerphone is not match");
		soft.assertAll();

	}

	@Test(priority = 3, enabled = true)
	public void validatedeletsupplierFunctionality() throws IOException {
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

	@Test(priority = 4, enabled = true)
	public void validateEditSupplierFunctionality() throws IOException {
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
		soft.assertEquals(spage.getSuppliernameFromSearchResults(), "kuku",
				"Failure message:suppliername is not match");
		soft.assertEquals(spage.getsupplierphonenumberFromSearchResults(), "9090909090",
				"Failure message:supplieremail is not match");
		soft.assertEquals(spage.getsupplieremaileFromSearchResults(), "brijitha@gmail.com",
				"Failure message:supplierphone is not match");
		soft.assertAll();
	}

}



