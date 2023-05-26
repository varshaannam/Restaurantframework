package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WebElementUtils;

public class LogoutPage {
	WebDriver driver;
	WebElementUtils elementutil = new WebElementUtils();
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//i[@class='fa fa-sign-out fa-lg']")
	public WebElement logout;
	public boolean isLogoutDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, logout);
		return flag;
	}

	public void clickActionOnLogout() {
		elementutil.clickOnElement(driver, logout);

	}

}