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

	@BeforeMethod
	public void preRun() throws Exception {
		driver = getDriver();
		// hpage=new HomePage(driver);
		lpage = new LoginPage(driver);
		// hpage=new HomePage(driver);
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		cpage = hpage.navigateToPeopleinCustomerPage();
		excelutil = new ExcelUtil();


	}

	@Test(priority = 1, enabled = true)
	public void validateElementsOncustomer() throws InterruptedException {
		cpage.clickOnCustomersElement();
		cpage.clickOnAddCustomerElement();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(cpage.isAddcustomerElementDisplayed(), "Failure message:addcustomer is not displayed");
		soft.assertTrue(cpage.isNameOfcustomerrDisplayed(), "Failure message:nameofcustomer is not displayed");
		soft.assertTrue(cpage.isPhonenumberOfcustomerDisplayed(), "Failure message:phonenumber is not displayed");
		soft.assertTrue(cpage.isEmailOfcustomerDisplayed(), "Failure message:email is not displayed");
		soft.assertTrue(cpage.isDiscountOfCustomerDisplayed(), "Failure message:discount is not displayed");
		soft.assertAll();

	}

	@Test(priority = 2, enabled = true)
	public void validateAddcustomerFunctionality() throws IOException {
		cpage.clickOnCustomersElement();
		cpage.clickOnAddCustomerElement();
		String customername = excelutil.readStringData("customer", 1, 2);
		cpage.enterNameOfCustomer(customername);
		String customernum = excelutil.readStringData("customer", 2, 2);
		cpage.enterPhonenumberOfCustomer(customernum);
		String customermail = excelutil.readStringData("customer", 3, 2);
		cpage.enterEmailOfcustomer(customermail);
		String customerdiscount = excelutil.readStringData("customer",4, 2);
		cpage.enterDiscountOfCustomer(customerdiscount);
		cpage.submitofcustomer();
		cpage.enterSearchofcustomerElement("customername");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(cpage.getcustomerrnameFromSearchResults(), "clint",
				"Failure message:customername is not match");
		soft.assertEquals(cpage.getcustomerphonenumberFromSearchResults(), "5123445",
				"Failure message:customeremail is not match");
		soft.assertEquals(cpage.getcustomereremaileFromSearchResults(), "angel@gmail.com",
				"Failure message:customerphone is not match");
		soft.assertEquals(cpage.getDiscountOfcustomerFromSearchResults(), "20",
				"Failure message:customerdiscount is not match");
		soft.assertAll();

	}

	@Test(priority = 3, enabled = true)
	public void validatedeletcustomerFunctionality() throws IOException {
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

	@Test(priority = 4, enabled = true)
	public void validateEditCustomerFunctionality() throws IOException {

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
		soft.assertEquals(cpage.getcustomerrnameFromSearchResults(), "manu",
				"Failure message:customername is not match");
		soft.assertEquals(cpage.getcustomerphonenumberFromSearchResults(), "1012134",
				"Failure message:customeremail is not match");
		soft.assertEquals(cpage.getcustomereremaileFromSearchResults(), "rama@gmail.com",
				"Failure message:customerphone is not match");
		soft.assertEquals(cpage.getDiscountOfcustomerFromSearchResults(), "40",
				"Failure message:customerdiscount is not match");

		soft.assertAll();

	}

}



