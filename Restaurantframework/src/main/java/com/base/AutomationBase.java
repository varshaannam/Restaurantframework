package com.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.constants.AutomationConstants;
import com.pages.LoginPage;
import com.utilities.BrowserUtils;
import com.utilities.PropertyUtil;

public class AutomationBase {
	public WebDriver driver;
	BrowserUtils browser = new BrowserUtils();
	LoginPage lpage;
	PropertyUtil propertyutil;
	Properties prop;

	@BeforeMethod
	@Parameters("browserName")
	public void preLaunch(String browserName) {
		launchBrowser(browserName);
		propertyutil = new PropertyUtil();
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
	}

	@BeforeGroups("Smoke")
	@Parameters("browserName")
	public void grouping(String browserName) {
		launchBrowser(browserName);
		lpage = new LoginPage(driver);
		browser = new BrowserUtils();
		propertyutil = new PropertyUtil();
		prop = propertyutil.getProperty("config.properties");
		browser.launchtheURL(driver, prop.getProperty("url"));
		browser.maximizeWindow(driver);
	}

	public void launchBrowser(String browserName) {
		switch (browserName) {
		case "Chrome":
			launchChromeBrowser();
			break;
		case "Edge":
			launchEdgeBrowser();
			break;
		case "Firefox":
			launchFirefoxBrowser();
			break;
		default:
			throw new RuntimeException(AutomationConstants.browserNameCheck);
		}
	}

	private void launchChromeBrowser() {
		driver = new ChromeDriver();
		browser.maximizeWindow(driver);
	}

	private void launchEdgeBrowser() {
		driver = new EdgeDriver();
		browser.maximizeWindow(driver);
	}

	private void launchFirefoxBrowser() {
		driver = new FirefoxDriver();
		browser.maximizeWindow(driver);
	}

	public WebDriver getDriver() {
		return driver;
	}

}
