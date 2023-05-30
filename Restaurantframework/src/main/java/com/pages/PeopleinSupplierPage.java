package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WebElementUtils;
import com.utilities.WebPageutils;

public class PeopleinSupplierPage {

	WebDriver driver;

	WebElementUtils elementutil = new WebElementUtils();
	WebPageutils pageutil = new WebPageutils();
	@FindBy(xpath = "//span[text()='People']")
	WebElement peoplelink;
	@FindBy(xpath = "//span[text()='Suppliers']")
	WebElement suppliers_category;
	@FindBy(xpath = "//button[@class='btn btn-add btn-lg']")
	WebElement Addsupplier;
	@FindBy(xpath = "//input[@id='SupplierName']")
	WebElement supplier_name;
	@FindBy(xpath = "//input[@id='SupplierPhone']")
	WebElement supplier_phone;
	@FindBy(xpath = "//input[@id='SupplierEmail']")
	WebElement supplier_email;
	@FindBy(xpath = "//button[text()='Submit']")
	WebElement customer_submit;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	WebElement invalidsearchresult;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement supplier_search;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	WebElement suppliername_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	WebElement supplierphonenumber_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	WebElement supplieremail_searchresult;

	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	WebElement supplierdelete_action;
	@FindBy(xpath = "//a[text()='Yes, delete it!']")
	WebElement supplierdelete_confirm;
	@FindBy(xpath = "//i[@class='fa fa-pencil']")
	WebElement supplieredit_action;

	public PeopleinSupplierPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddsuppliertElement() {
		elementutil.clickOnElement(driver, supplier_name);
	}

	public boolean isAddSupplierElementDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, Addsupplier);
		return flag;
	}

	public boolean isNameOfsupplierDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, supplier_name);
		return flag;
	}

	public boolean isPhonenumberOfSupplierDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, supplier_phone);
		return flag;
	}

	public boolean isEmailOfSupplierDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, supplier_email);
		return flag;
	}

	public void clickOnSupplierElement() {
		elementutil.clickOnElement(driver, suppliers_category);
	}

	public void clickOnAddSupplierElement() {
		elementutil.clickOnElement(driver, Addsupplier);
	}

	public void enterNameOfSupplier(String name) {
		elementutil.enterValueToTheElement(driver, supplier_name, name);
	}

	public void enterEmailOfSupplier(String name) {
		elementutil.enterValueToTheElement(driver, supplier_email, name);
	}

	public void enterPhonenumberOfSupplier(String name) {
		elementutil.enterValueToTheElement(driver, supplier_phone, name);

	}

	public void submitofsupplier() {
		elementutil.clickOnElement(driver, customer_submit);
	}

	public String enterSearchofsupplierElement(String name) {
		elementutil.enterValueToTheElement(driver, supplier_search, name);
		return name;
	}

	public String getSuppliernameFromSearchResults() {
		return elementutil.getTextOfElement(driver, suppliername_searchresult);
	}

	public String getsupplieremaileFromSearchResults() {
		return elementutil.getTextOfElement(driver, supplieremail_searchresult);
	}

	public String getsupplierphonenumberFromSearchResults() {
		return elementutil.getTextOfElement(driver, supplierphonenumber_searchresult);
	}

	public void deleteActionOnSupplier() {
		elementutil.clickOnElement(driver, supplierdelete_action);

	}

	public void deleteConfirmationOnSupplier() {
		elementutil.clickOnElement(driver, supplierdelete_confirm);

	}

	public void EditActiononSupplier() {
		elementutil.clickOnElement(driver, supplieredit_action);

	}

	public boolean isInvalidresultFromSearch() {
		boolean flag = elementutil.isElementDisplayed(driver, invalidsearchresult);
		return flag;
	}

	public void clearActionOnSuppliername() {
		elementutil.clearTheElement(driver, supplier_name);
		;

	}

}
