package com.test;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.LogoutPage;
import com.utilities.BrowserUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;


public class LogoutPageTest extends AutomationBase {
		LoginPage lpage;
		HomePage hpage;
		LogoutPage opage;
		Properties prop;
		PropertyUtil propertyutil = new PropertyUtil();
		BrowserUtils browser = new BrowserUtils();
		@Test(priority = 31, enabled = true)
		public void validateclickactionOnLogout() {
			lpage = new LoginPage(driver);
			prop = propertyutil.getProperty("config.properties");
			browser.launchtheURL(driver, prop.getProperty("url"));
			hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
			opage = hpage.navigateToLogoutPage();
			opage.clickActionOnLogout();
			Assert.assertTrue(lpage.isLoginDisplayed(),AutomationConstants.LinkDisplayCheck);
		}

	}


