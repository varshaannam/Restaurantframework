package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.BrowserUtils;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;
import com.utilities.WebPageutils;

public class PeopleinWaiterPage {
	WebDriver driver;
	WebElementUtils elementutil = new WebElementUtils();
	WaitUtils waitutil = new WaitUtils();
	WebPageutils pageutil = new WebPageutils();
	BrowserUtils browserutil = new BrowserUtils();

	public PeopleinWaiterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='People']")
	WebElement peoplelink;
	@FindBy(xpath = "//span[text()='Waiters']")
	WebElement waiters_category;
	@FindBy(xpath = "//button[@class='btn btn-add btn-lg']")
	WebElement AddWaiter;
	@FindBy(xpath = "//input[@id='WaiterName']")
	WebElement waiter_name;
	@FindBy(xpath = "//input[@id='WaiterPhone']")
	WebElement waiter_phone;
	@FindBy(xpath = "//input[@id='WaiterEmail']")
	WebElement waiter_email;
	@FindBy(xpath = "//select[@id='WaiterStore']")
	WebElement waiter_store;
	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement waiter_submit;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement waiter_search;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	WebElement waitername_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	WebElement waiterphonenumber_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	WebElement waiteremail_searchresult;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	WebElement waiterdelete_action;
	@FindBy(xpath = "//a[text()='Yes, delete it!']")
	WebElement waiterrdelete_confirm;
	@FindBy(xpath = "//i[@class='fa fa-pencil']")
	WebElement waiteredit_action;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	WebElement invalidsearchresult;

	public void clickOnWaitersElement() {
		elementutil.clickOnElement(driver, waiters_category);
	}

	public void clickOnAddwaitElement() {
		elementutil.clickOnElement(driver, AddWaiter);
	}

	public boolean isAddwaiterElementDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, AddWaiter);
		return flag;
	}

	public boolean isNameOfWaiterDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, waiter_name);
		return flag;
	}

	public boolean isPhonenumberOfWaiterDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, waiter_phone);
		return flag;
	}

	public boolean isEmailOfWaiterDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, waiter_email);
		return flag;
	}

	public boolean isStoreOfWaiterDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, waiter_store);
		return flag;
	}

	public void enterNameOfWaiter(String name) {
		elementutil.enterValueToTheElement(driver, waiter_name, name);
	}

	public void enterEmailOfwaiter(String name) {
		elementutil.enterValueToTheElement(driver, waiter_email, name);
	}

	public void enterPhonenumberOfwaiter(String name) {
		elementutil.enterValueToTheElement(driver, waiter_phone, name);

	}

	public void selecttStoreOfWaiter(String name) {
		pageutil.elementSelectByValue(driver, waiter_store, name);
	}

	public void submitofWaiter() {
		elementutil.clickOnElement(driver, waiter_submit);
		waitutil.ElementTobeClickable(driver, waiter_submit, 10);
	}

	public String enterSearchofWaiterElement(String name) {
		elementutil.enterValueToTheElement(driver, waiter_search, name);
		return name;

	}

	public String getwaiternameFromSearchResults() {
		return elementutil.getTextOfElement(driver, waitername_searchresult);
	}

	public String getwaiteremaileFromSearchResults() {
		return elementutil.getTextOfElement(driver, waiteremail_searchresult);
	}

	public String getwaiterphonenumberFromSearchResults() {
		return elementutil.getTextOfElement(driver, waiterphonenumber_searchresult);
	}

	public void deleteActionOnwaiter() {
		elementutil.clickOnElement(driver, waiterdelete_action);

	}

	public void deleteConfirmationOnwaiter() {
		elementutil.clickOnElement(driver, waiterrdelete_confirm);

	}

	public void EditActiononwaiter() {
		elementutil.clickOnElement(driver, waiteredit_action);

	}

	public boolean isInvalidresultFromSearch() {
		boolean flag = elementutil.isElementDisplayed(driver, invalidsearchresult);
		return flag;
	}

	public void clearActionOnwaitername() {
		elementutil.clearTheElement(driver, waiter_name);
		;

	}

	public void clearActionOnwaiterphonenumber() {
		elementutil.clearTheElement(driver, waiter_phone);

	}

	public void closeTheWindow() {
		browserutil.quitWindow(driver);
	}

}
