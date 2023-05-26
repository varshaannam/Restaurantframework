package com.test;
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
import com.pages.PeopleinWaiterPage;
import com.utilities.BrowserUtils;
import com.utilities.ExcelUtil;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;


public class PeopleinWaiterPageTest extends AutomationBase {
	WebDriver driver;
	LoginPage lpage;
	HomePage hpage;
	PeopleinWaiterPage epage;
	Properties prop;
	WaitUtils wait;
	DataSupplier supplier;
	ExcelUtil excelutil;
	PropertyUtil propertyutil = new PropertyUtil();
	BrowserUtils browser = new BrowserUtils();

	

	@Test(priority = 1, enabled = true)
	public void validateElementsOnwaiter()  {
		lpage = new LoginPage(driver);
		wait = new WaitUtils();
		supplier = new DataSupplier();
		excelutil = new ExcelUtil();
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		epage = hpage.navigateToPeopleinWaiterPage();
		epage.clickOnWaitersElement();
		epage.clickOnAddwaitElement();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(epage.isAddwaiterElementDisplayed(), "Failure message:addwaiter is not displayed");
		soft.assertTrue(epage.isNameOfWaiterDisplayed(), "Failure message:nameofwaiter is not displayed");
		soft.assertTrue(epage.isPhonenumberOfWaiterDisplayed(), "Failure message:phonenumber is not displayed");
		soft.assertTrue(epage.isEmailOfWaiterDisplayed(), "Failure message:email is not displayed");
		soft.assertTrue(epage.isStoreOfWaiterDisplayed(), "Failure message:storeofwaiter is not displayed");
		soft.assertAll();
	}

	@Test(priority = 2, enabled = true, dataProvider = "dataProvider", dataProviderClass = DataSupplier.class)
	public void validateAddwaiterFunctionality(String name, String phonenum, String mail,String discount)  {
		lpage = new LoginPage(driver);
		wait = new WaitUtils();
		supplier = new DataSupplier();
		excelutil = new ExcelUtil();
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		epage = hpage.navigateToPeopleinWaiterPage();


		epage.clickOnWaitersElement();
		epage.clickOnAddwaitElement();
		epage.enterNameOfWaiter("name");
		epage.enterPhonenumberOfwaiter("phonenum");
		epage.enterEmailOfwaiter("mail");
		epage.selecttStoreOfWaiter("discount");
		epage.submitofWaiter();
		wait.ElementTobeClickable(driver, epage.waiter_submit, 30);

		/*
		 * epage.enterSearchofWaiterElement("john"); SoftAssert soft = new SoftAssert();
		 * soft.assertEquals(epage.getwaiternameFromSearchResults(), "john",
		 * "Failure message:waitername is not match");
		 * soft.assertEquals(epage.getwaiteremaileFromSearchResults(),
		 * "azxvb@gmail.com","Failure message:waiteremail is not match");
		 * soft.assertEquals(epage.getwaiterphonenumberFromSearchResults(),
		 * "19056788","Failure message:waiterphoneis not match");
		 * 
		 * soft.assertAll();
		 */

	}

	@Test(priority = 3, enabled = true)
	public void validatedeletewaiterFunctionality() {
		lpage = new LoginPage(driver);
		wait = new WaitUtils();
		supplier = new DataSupplier();
		excelutil = new ExcelUtil();
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		epage = hpage.navigateToPeopleinWaiterPage();


		epage.clickOnWaitersElement();
		epage.clickOnAddwaitElement();
		epage.enterNameOfWaiter("alina");
		epage.enterPhonenumberOfwaiter("19056788");
		epage.enterEmailOfwaiter("azxvb@gmail.com");
		epage.selecttStoreOfWaiter("D4");
		epage.submitofWaiter();
		epage.enterSearchofWaiterElement("john");
		epage.deleteActionOnwaiter();
		epage.deleteConfirmationOnwaiter();
		epage.enterSearchofWaiterElement("john");
		Assert.assertTrue(epage.isInvalidresultFromSearch());
	}

	@Test(priority = 4, enabled = true)
	public void validateEditwaiterFunctionality() {
		lpage = new LoginPage(driver);
		wait = new WaitUtils();
		supplier = new DataSupplier();
		excelutil = new ExcelUtil();
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		epage = hpage.navigateToPeopleinWaiterPage();


		epage.clickOnWaitersElement();
		epage.clickOnAddwaitElement();
		epage.enterNameOfWaiter("jithu");
		epage.enterPhonenumberOfwaiter("19056788");
		epage.enterEmailOfwaiter("azxvb@gmail.com");
		epage.selecttStoreOfWaiter("D4");
		epage.submitofWaiter();
		epage.enterSearchofWaiterElement("jithu");
		epage.EditActiononwaiter();
		epage.clearActionOnwaitername();
		epage.enterNameOfWaiter("eric");
		epage.clearActionOnwaiterphonenumber();
		epage.enterPhonenumberOfwaiter("1000000");
		epage.submitofWaiter();
		epage.enterSearchofWaiterElement("eric");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(epage.getwaiternameFromSearchResults(), "eric", "Failure message:waitername is not match");
		soft.assertEquals(epage.getwaiteremaileFromSearchResults(), "azxvb@gmail.com",
				"Failure message:waiteremail is not match");
		soft.assertEquals(epage.getwaiterphonenumberFromSearchResults(), "1000000",
				"Failure message:waiterphoneis not match");

		soft.assertAll();

	}


}
