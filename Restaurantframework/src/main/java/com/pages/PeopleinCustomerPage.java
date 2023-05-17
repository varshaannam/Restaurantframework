package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WebElementUtils;
import com.utilities.WebPageutils;

public class PeopleinCustomerPage {

	WebDriver driver;

	WebElementUtils elementutil = new WebElementUtils();
	WebPageutils pageutil = new WebPageutils();
	@FindBy(xpath = "//span[text()='People']")
	WebElement peoplelink;
	@FindBy(xpath = "//span[text()='Customers']")
	WebElement customers_category;
	@FindBy(xpath = "//button[@class='btn btn-add btn-lg']")
	WebElement Addcustomerr;
	@FindBy(xpath = "//input[@id='CustomerName']")
	WebElement customer_name;
	@FindBy(xpath = "//input[@id='CustomerPhone']")
	WebElement customer_phone;
	@FindBy(xpath = "//button[text()='Submit']")
	WebElement customer_submit;
	@FindBy(xpath = "//input[@id='CustomerEmail']")
	WebElement customer_email;
	@FindBy(xpath = "//input[@id='CustomerDiscount']")
	WebElement customer_discount;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	WebElement invalidsearchresult;
	@FindBy(xpath = "//input[@id='CustomerDiscount']")
	WebElement customerDiscount;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement customer_search;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	WebElement customername_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	WebElement customerphonenumber_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	WebElement customeremail_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[4]")
	WebElement customerdiscount_searchresult;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	WebElement customerdelete_action;
	@FindBy(xpath = "//a[text()='Yes, delete it!']")
	WebElement customerdelete_confirm;
	@FindBy(xpath = "//i[@class='fa fa-pencil']")
	WebElement customeredit_action;

	public PeopleinCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddcustomertElement() {
		elementutil.clickOnElement(driver, Addcustomerr);
	}

	public boolean isAddcustomerElementDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, Addcustomerr);
		return flag;
	}

	public boolean isNameOfcustomerrDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, customer_name);
		return flag;
	}

	public boolean isPhonenumberOfcustomerDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, customer_phone);
		return flag;
	}

	public boolean isEmailOfcustomerDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, customer_email);
		return flag;
	}

	public boolean isDiscountOfCustomerDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, customerDiscount);
		return flag;
	}

	public void clickOnCustomersElement() {
		elementutil.clickOnElement(driver, customers_category);
	}

	public void clickOnAddCustomerElement() {
		elementutil.clickOnElement(driver, Addcustomerr);
	}

	public void enterNameOfCustomer(String name) {
		elementutil.enterValueToTheElement(driver, customer_name, name);
	}

	public void enterEmailOfcustomer(String name) {
		elementutil.enterValueToTheElement(driver, customer_email, name);
	}

	public void enterPhonenumberOfCustomer(String name) {
		elementutil.enterValueToTheElement(driver, customer_phone, name);

	}

	public void enterDiscountOfCustomer(String name) {
		elementutil.enterValueToTheElement(driver, customerDiscount, name);

	}

	public void submitofcustomer() {
		elementutil.clickOnElement(driver, customer_submit);
	}

	public String enterSearchofcustomerElement(String name) {
		elementutil.enterValueToTheElement(driver, customer_search, name);
		return name;

	}

	public String getcustomerrnameFromSearchResults() {
		return elementutil.getTextOfElement(driver, customername_searchresult);
	}

	public String getcustomereremaileFromSearchResults() {
		return elementutil.getTextOfElement(driver, customeremail_searchresult);
	}

	public String getcustomerphonenumberFromSearchResults() {
		return elementutil.getTextOfElement(driver, customerphonenumber_searchresult);
	}

	public String getDiscountOfcustomerFromSearchResults() {
		return elementutil.getTextOfElement(driver, customerdiscount_searchresult);
	}

	public void deleteActionOncustomer() {
		elementutil.clickOnElement(driver, customerdelete_action);

	}

	public void deleteConfirmationOnCustomer() {
		elementutil.clickOnElement(driver, customerdelete_confirm);

	}

	public void EditActiononCustomer() {
		elementutil.clickOnElement(driver, customeredit_action);

	}

	public boolean isInvalidresultFromSearch() {
		boolean flag = elementutil.isElementDisplayed(driver, invalidsearchresult);
		return flag;
	}

	public void clearActionOnCustomername() {
		elementutil.clearTheElement(driver, customer_name);
		;

	}

}
