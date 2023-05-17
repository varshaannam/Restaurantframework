package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.PropertyUtil;

public class LoginPageTest  extends AutomationBase {
	WebDriver driver;
	LoginPage lpage;
	HomePage hpage;
	Properties prop;
	PropertyUtil propertyutil;

	@Test
	public void validateLogin() throws Exception {
		driver = getDriver();
		lpage = new LoginPage(driver);
		hpage = new HomePage(driver);
		propertyutil = new PropertyUtil();
		prop = propertyutil.getProperty("config.properties");
		lpage.performlogin(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertTrue(hpage.isProductDisplayed(), AutomationConstants.loginCheck);
      

	}

}
