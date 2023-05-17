package com.test;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.StorePage;
import com.utilities.BrowserUtils;
import com.utilities.ExcelUtil;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;

public class StorePageTest extends AutomationBase {
	WebDriver driver;
	LoginPage lpage;
	HomePage hpage;
	StorePage spage;
	Properties prop;
	WaitUtils wait;
	ExcelUtil excelutil;
	PropertyUtil propertyutil = new PropertyUtil();
	BrowserUtils browser = new BrowserUtils();

	@BeforeMethod
	public void preRun() throws Exception {
		driver = getDriver();
		lpage = new LoginPage(driver);
		wait = new WaitUtils();
		excelutil = new ExcelUtil();

		prop = propertyutil.getProperty("config.properties");
		wait.implicitwait(driver, 30);
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		spage = hpage.navigateTostorePage();
	}

	@Test(priority = 1, enabled = true)
	public void validateElementsOnStore() {
		spage.clickOnAddStore();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(spage.isAddStoreDisplayed(), "Failure message:addstore is not displayed");
		soft.assertTrue(spage.isStoreNameDisplayed(), "Failure message:storename is not displayed");
		soft.assertTrue(spage.isStoreEmailDisplayed(), "Failure message:storeemail is not displayed");
		soft.assertTrue(spage.isStorePhoneDisplayed(), "Failure message:storephone is not displayed");
		soft.assertTrue(spage.isStoreCountryDisplayed(), "Failure message:storecountry is not displayed");
		soft.assertTrue(spage.isStoreCityDisplayed(), "Failure message:storecity is not displayed");
		soft.assertTrue(spage.isStoreAddressDisplayed(), "Failure message:storeaddressr is not displayed");
		soft.assertAll();
	}

	@Test(priority = 2, enabled = true)
	public void validateAddStoreFunctionality() throws IOException {
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
		soft.assertEquals(spage.getStorenameFromSearchResults(), "ALFA", "Failure message:storename is not match");
		soft.assertEquals(spage.getStoreemaileFromSearchResults(), "abcdef@gmail.com",
				"Failure message:storeemail is not match");
		soft.assertEquals(spage.getStorephonenumberFromSearchResults(), "12121212",
				"Failure message:storephoneis not match");
		soft.assertEquals(spage.getStorecountryFromSearchResults(), "india",
				"Failure message:storecountry is not match");
		soft.assertEquals(spage.getStorecityFromSearchResults(), "ijk", "Failure message:storecityis not match");
		// soft.assertEquals(ppage.getProductPriceFromSearchResults(),"20000","Failure
		// message:productprice is not match");
		soft.assertAll();
	}

	@Test(priority = 3, enabled = true)
	public void validateDeleteActionOnStore() throws InterruptedException, IOException {
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
		// wait.waitForElementTobeClickable(driver, element, timeunit);
		Assert.assertTrue(spage.isInvalidresultFromSearch());
	}

	@Test(priority = 4, enabled = true)
	public void validateEditActionOnStore() throws InterruptedException, IOException {
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
		spage.enterNameOfStore("booster");
		spage.clearActionOnphonenumber();
		spage.enterPhonenumberOfStore("11111111");
		spage.Storesubmit();
		wait.presenceOfElementLocated(driver, spage.store_submit, 30);

	}
}



