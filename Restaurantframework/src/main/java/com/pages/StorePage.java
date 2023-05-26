package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WebElementUtils;
import com.utilities.WebPageutils;

public class StorePage {
	WebDriver driver;
	WebElementUtils elementutil = new WebElementUtils();
	WebPageutils pageutil = new WebPageutils();
	public StorePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Stores']")
	WebElement storelink;
	@FindBy(xpath = "//button[@class='btn btn-add btn-lg']")
	WebElement add_store;
	@FindBy(xpath = "//input[@id='StoreName']")
	WebElement store_name;
	@FindBy(xpath = "//input[@id='email']")
	WebElement store_email;
	@FindBy(xpath = "//input[@id='StorePhone']")
	WebElement store_phone;
	@FindBy(xpath = "//input[@id='Country']")
	WebElement store_country;
	@FindBy(xpath = "//input[@id='City']")
	WebElement store_city;
	@FindBy(xpath = "//input[@id='Adresse']")
	WebElement store_address;
	@FindBy(xpath = "//button[@class='btn btn-add']")
	public WebElement store_submit;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement store_search;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	WebElement storename_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	WebElement storeemail_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	WebElement storephone_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[4]")
	WebElement storecountry_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[5]")
	WebElement storecity_searchresult;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	WebElement storeDelete_Action;
	@FindBy(xpath = "//a[text()='Yes, delete it!']")
	WebElement productdelete_confirm;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	WebElement invalidsearchresult;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	WebElement Storeedit_action;

	
	public boolean isStoreDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, storelink);
		return flag;
	}

	public boolean isAddStoreDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, add_store);
		return flag;
	}

	public void clickOnAddStore() {
		elementutil.clickOnElement(driver, add_store);

	}

	public boolean isStoreNameDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, store_name);
		return flag;
	}

	public boolean isStoreEmailDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, store_email);
		return flag;
	}

	public boolean isStorePhoneDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, store_phone);
		return flag;
	}

	public boolean isStoreCountryDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, store_country);
		return flag;
	}

	public boolean isStoreCityDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, store_city);
		return flag;
	}

	public boolean isStoreAddressDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, store_address);
		return flag;
	}

	public void enterNameOfStore(String name) {
		elementutil.enterValueToTheElement(driver, store_name, name);
	}

	public void enterEmailOfStore(String name) {
		elementutil.enterValueToTheElement(driver, store_email, name);
	}

	public void enterPhonenumberOfStore(String name) {
		elementutil.enterValueToTheElement(driver, store_phone, name);

	}

	public void enterCountrynameOfStore(String name) {
		elementutil.enterValueToTheElement(driver, store_country, name);

	}

	public void enterCityNameOfStore(String name) {
		elementutil.enterValueToTheElement(driver, store_city, name);
	}

	public void enterAddressOfStore(String name) {
		elementutil.enterValueToTheElement(driver, store_address, name);
	}

	public void Storesubmit() {
		elementutil.clickOnElement(driver, store_submit);
	}

	public String StoreSearch(String name) {
		elementutil.enterValueToTheElement(driver, store_search, name);
		return name;

	}

	public String getStorenameFromSearchResults() {
		return elementutil.getTextOfElement(driver, storename_searchresult);
	}

	public String getStoreemaileFromSearchResults() {
		return elementutil.getTextOfElement(driver, storeemail_searchresult);
	}

	public String getStorephonenumberFromSearchResults() {
		return elementutil.getTextOfElement(driver, storephone_searchresult);
	}

	public String getStorecountryFromSearchResults() {
		return elementutil.getTextOfElement(driver, storecountry_searchresult);
	}

	public String getStorecityFromSearchResults() {
		return elementutil.getTextOfElement(driver, storecity_searchresult);
	}

	public void deleteActionOnstore() {
		elementutil.clickOnElement(driver, storeDelete_Action);

	}

	public void deleteConfirmationOnStore() {
		elementutil.clickOnElement(driver, productdelete_confirm);

	}

	public boolean isInvalidresultFromSearch() {
		boolean flag = elementutil.isElementDisplayed(driver, invalidsearchresult);
		return flag;
	}

	public void storeEditAction() {
		elementutil.clickOnElement(driver, Storeedit_action);

	}

	public void clearActionOnstorename() {
		elementutil.clearTheElement(driver, store_name);
		;

	}

	public void clearActionOnphonenumber() {
		elementutil.clearTheElement(driver, store_phone);
		;

	}

}
