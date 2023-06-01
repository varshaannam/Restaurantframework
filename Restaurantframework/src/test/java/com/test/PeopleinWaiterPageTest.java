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
import com.pages.PeopleinWaiterPage;
import com.utilities.BrowserUtils;
import com.utilities.ExcelUtil;
import com.utilities.PropertyUtil;

public class PeopleinWaiterPageTest extends AutomationBase {
	WebDriver driver;
	LoginPage lpage;
	HomePage hpage;
	PeopleinWaiterPage epage;
	Properties prop;
	DataSupplier supplier;
	ExcelUtil excelutil;
	PropertyUtil propertyutil = new PropertyUtil();
	BrowserUtils browser = new BrowserUtils();

	@Test(priority = 25, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateElementsOnwaiter() {
		lpage = new LoginPage(driver);
		supplier = new DataSupplier();
		excelutil = new ExcelUtil();
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		epage = hpage.navigateToPeopleinWaiterPage();
		epage.clickOnWaitersElement();
		epage.clickOnAddwaitElement();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(epage.isAddwaiterElementDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(epage.isNameOfWaiterDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(epage.isPhonenumberOfWaiterDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(epage.isEmailOfWaiterDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(epage.isStoreOfWaiterDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 26, enabled = true, dataProvider = "dataProvider", dataProviderClass = DataSupplier.class)
	public void validateAddwaiterFunctionality(String name, String phonenum, String mail, String discount) {
		lpage = new LoginPage(driver);
		supplier = new DataSupplier();
		excelutil = new ExcelUtil();
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		epage = hpage.navigateToPeopleinWaiterPage();
		epage.clickOnWaitersElement();
		epage.clickOnAddwaitElement();
		epage.enterNameOfWaiter("name");
		epage.enterPhonenumberOfwaiter("phonenum");
		epage.enterEmailOfwaiter("mail");
		epage.selecttStoreOfWaiter("discount");
		epage.submitofWaiter();
		epage.enterSearchofWaiterElement("name");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(epage.getwaiternameFromSearchResults(), "john", AutomationConstants.ErrorMessage);
		soft.assertEquals(epage.getwaiteremaileFromSearchResults(), "azxvb@gmail.com",AutomationConstants.ErrorMessage);
		soft.assertEquals(epage.getwaiterphonenumberFromSearchResults(), "19056788", AutomationConstants.ErrorMessage);
		soft.assertAll();

	}

	@Test(priority =27, enabled = false, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validatedeletewaiterFunctionality() {
		lpage = new LoginPage(driver);
		supplier = new DataSupplier();
		excelutil = new ExcelUtil();
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		epage = hpage.navigateToPeopleinWaiterPage();
		epage.clickOnWaitersElement();
		epage.clickOnAddwaitElement();
		String wname = excelutil.readStringData("waiter", 1, 2);
		epage.enterNameOfWaiter(wname);
		String wphone = excelutil.readStringData("waiter", 2, 2);
		epage.enterPhonenumberOfwaiter(wphone);
		String wmail = excelutil.readStringData("waiter", 3, 2);
		epage.enterEmailOfwaiter(wmail);
		String wstore = excelutil.readStringData("waiter", 4, 2);
		epage.selecttStoreOfWaiter(wstore);
		epage.submitofWaiter();
		epage.enterSearchofWaiterElement(wname);
		epage.deleteActionOnwaiter();
		epage.deleteConfirmationOnwaiter();
		epage.enterSearchofWaiterElement(wname);
		Assert.assertTrue(epage.isInvalidresultFromSearch());
	}

	@Test(priority = 28, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateEditwaiterFunctionality() {
		lpage = new LoginPage(driver);
		supplier = new DataSupplier();
		excelutil = new ExcelUtil();
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		epage = hpage.navigateToPeopleinWaiterPage();
		epage.clickOnWaitersElement();
		epage.clickOnAddwaitElement();
		String Zname = excelutil.readStringData("waiter", 5, 2);
		epage.enterNameOfWaiter(Zname);
		String Zphone = excelutil.readStringData("waiter", 6, 2);
		epage.enterPhonenumberOfwaiter(Zphone);
		String Zemail = excelutil.readStringData("waiter", 7, 2);
		epage.enterEmailOfwaiter(Zemail);
		String Zstore = excelutil.readStringData("waiter", 8, 2);
		epage.selecttStoreOfWaiter(Zstore);
		epage.submitofWaiter();
		epage.enterSearchofWaiterElement(Zname);
		epage.EditActiononwaiter();
		epage.clearActionOnwaitername();
		String ZEditname = excelutil.readStringData("waiter", 9, 2);
		epage.enterNameOfWaiter(ZEditname);
		epage.clearActionOnwaiterphonenumber();
		String ZEditphone = excelutil.readStringData("waiter", 10, 2);
		epage.enterPhonenumberOfwaiter(ZEditphone);
		epage.submitofWaiter();
		epage.enterSearchofWaiterElement("eric");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(epage.getwaiternameFromSearchResults(), "eric", AutomationConstants.ErrorMessage);
		soft.assertEquals(epage.getwaiteremaileFromSearchResults(), "azxvb@gmail.com", AutomationConstants.ErrorMessage);
		soft.assertEquals(epage.getwaiterphonenumberFromSearchResults(), "1000000", AutomationConstants.ErrorMessage);
		soft.assertAll();

	}
	@AfterMethod
	public void postRun() {
		epage.closeTheWindow();
	}


}
