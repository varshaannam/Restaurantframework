package com.base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.constants.AutomationConstants;
import com.pages.LoginPage;
import com.utilities.BrowserUtils;
import com.utilities.PropertyUtil;

public class AutomationBase {
	static WebDriver driver;
	BrowserUtils browser;
	LoginPage lpage;
	PropertyUtil propertyutil;
	Properties prop;

	@BeforeTest
	@Parameters("browserName")

	public void preLaunch(String browserName) {

		launchBrowser(browserName);
		lpage = new LoginPage(driver);
		browser = new BrowserUtils();
		propertyutil = new PropertyUtil();
		try {
			prop = propertyutil.getProperty("config.properties");
		} catch (IOException e) {
			throw new RuntimeException("unable to load config file");
		}
		browser.launchtheURL(driver, prop.getProperty("url"));

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
		driver.manage().window().maximize();
		//browser.fullSCreenWindow(driver);
		//ChromeOptions ops = new ChromeOptions();
		//ops.addArguments("--remote-allow-origins=*");
		//WebDriver driver = new ChromeDriver(ops);
	}

	private void launchEdgeBrowser() {

		driver = new EdgeDriver();
		driver.manage().window().maximize();
		// browser.fullSCreenWindow(driver);
	}

	private void launchFirefoxBrowser() {

		driver = new FirefoxDriver();
		// browser.fullSCreenWindow(driver);

	}

	public static WebDriver getDriver() // to return the driver
	{
		return driver;
	}
}
