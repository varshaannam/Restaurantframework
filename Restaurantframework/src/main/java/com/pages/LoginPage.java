package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WebElementUtils;

public class LoginPage {
	WebDriver driver;
	WebElementUtils elementutil = new WebElementUtils();
	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//input[@name='submit']")
	WebElement login;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterValuetoUsername(String name) {
		elementutil.enterValueToTheElement(driver, username, name);
	}

	public void enterValuetopassword(String pwsd) {
		elementutil.enterValueToTheElement(driver, password, pwsd);
	}

	public void clickOnLogin() {
		elementutil.clickOnElement(driver, login);
	}

	public boolean isLoginDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, login);
		return flag;
	}

	public void performlogin(String username, String password) throws Exception {
		enterValuetoUsername(username);
		enterValuetopassword(password);
		clickOnLogin();
	}

	public HomePage login(String username, String password) throws Exception {
		enterValuetoUsername(username);
		enterValuetopassword(password);
		clickOnLogin();
		return new HomePage(driver);
	}

}
