package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.PropertyUtil;

public class HomePageTest extends AutomationBase {
	LoginPage lpage;
	HomePage hpage;
	Properties prop;
	PropertyUtil propertyutil;

	@Test(priority = 2, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateTheMenuItemsDisplayedOntheHomepage() {
		propertyutil = new PropertyUtil();
		lpage = new LoginPage(driver);
		prop = propertyutil.getProperty("config.properties");
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(hpage.isPosLinkDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(hpage.isProductDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(hpage.isStoreDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(hpage.isPeopleDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(hpage.isSalesDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(hpage.isExpenseDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(hpage.isCategoriesDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(hpage.isSettingDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(hpage.isReportDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(hpage.islanguageDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(hpage.islogoutDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertAll();
	}

}
