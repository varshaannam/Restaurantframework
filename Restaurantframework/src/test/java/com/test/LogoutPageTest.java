package com.test;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.LogoutPage;
import com.pages.StorePage;
import com.utilities.BrowserUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;


public class LogoutPageTest extends AutomationBase {
		WebDriver driver;
		LoginPage lpage;
		HomePage hpage;
		LogoutPage opage;
		Properties prop;
		WaitUtils wait;
		PropertyUtil propertyutil = new PropertyUtil();
		BrowserUtils browser = new BrowserUtils();

		@BeforeMethod
		public void preRun() throws Exception {
			driver = getDriver();
			lpage = new LoginPage(driver);
			wait = new WaitUtils();
			prop = propertyutil.getProperty("config.properties");
			browser.launchtheURL(driver, prop.getProperty("url"));
			wait.implicitwait(driver, 30);
			hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
			opage = hpage.navigateToLogoutPage();

		}

		@Test(priority = 1, enabled = true)
		public void validateclickactionOnLogout() {
			opage.clickActionOnLogout();
			Assert.assertTrue(lpage.isLoginDisplayed(), "Failure message:login is not displayed");
		}

	}


