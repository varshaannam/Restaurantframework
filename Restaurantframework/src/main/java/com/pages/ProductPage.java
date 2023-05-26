package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;
import com.utilities.WebPageutils;

public class ProductPage {
	WebDriver driver;
	WebElementUtils elementutil = new WebElementUtils();
	WebPageutils pageutil = new WebPageutils();
	WaitUtils waitutil = new WaitUtils();
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[text()='Product']")
	WebElement productlink;
	@FindBy(xpath = "//button[text()='Add Product']")
	WebElement addProduct;
	@FindBy(xpath = "//select[@id='Type']")
	WebElement producttype;
	@FindBy(xpath = "//input[@id='ProductCode']")
	WebElement productcode;
	@FindBy(xpath = "//input[@id='ProductName']")
	WebElement productname;
	@FindBy(xpath = "//select[@id='Category']")
	WebElement productcategory;
	@FindBy(xpath = "//select[@name='supplier']")
	WebElement productsupplier;
	@FindBy(xpath = "//input[@id='PurchasePrice']")
	WebElement productpurchaseprice;
	@FindBy(xpath = "//input[@id='Tax']")
	WebElement producttax;
	@FindBy(xpath = "//select[@id='taxType']")
	WebElement producttaxMethod;
	@FindBy(xpath = "//input[@id='Price']")
	WebElement productprice;
	@FindBy(xpath = "//input[@id='Unit']")
	WebElement productunit;
	@FindBy(xpath = "//input[@id='AlertQt']")
	WebElement productAlertquantity;
	@FindBy(xpath = "//textarea[@id='ProductOptions']")
	WebElement productOptions;
	@FindBy(xpath = "")
	WebElement productimageinput;
	@FindBy(xpath = "//div[@class='note-editable panel-body']")
	WebElement productDescription;
	@FindBy(xpath = "//label[@class='btn color02 active']")
	WebElement productColour;
	@FindBy(xpath = "//button[text()='Submit'][1]")
	WebElement productSubmit;
	@FindBy(xpath = "(//button[text()='Close'])[5]")
	public WebElement storeclose;
	@FindBy(xpath = "//input[@type='search']")
	WebElement productSearch;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	WebElement productcode_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	WebElement productname_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	WebElement productcategory_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[5]")
	WebElement producttax_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[6]")
	WebElement producprice_searchresult;
	@FindBy(xpath = "(//input[@id='quantity'])[1]")
	WebElement MNCstore_Quantity;
	@FindBy(xpath = "(//input[@id='pricestr'])[1]")
	WebElement MNCstore_price;
	@FindBy(xpath = "(//button[text()='submit'])[2]")
	public WebElement Storesubmit;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	WebElement Productdelete_action;
	@FindBy(xpath = "//a[text()='Yes, delete it!']")
	public WebElement productdelete_confirm;
	@FindBy(xpath = "//i[@class='fa fa-file-text']")
	public WebElement Productview_action;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[3]")
	WebElement Productedit_action;
	@FindBy(xpath = "(//i[@class='fa fa-tasks'])[1]")
	WebElement modifyStock_action;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	WebElement invalidsearchresult;
	public void implementImplicitWait() {
		waitutil.implicitwait(driver, 5);
	}

	public boolean isProductLinkDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver,productlink);
		return flag;
	}

	public boolean isAddProductDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver,addProduct);
		return flag;
	}

	public void clickOnAddProduct() {
		elementutil.clickOnElement(driver,addProduct);

	}

	public boolean isProductTypeDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, producttype);
		return flag;
	}

	public boolean isProductCodeDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, productcode);
		return flag;
	}

	public boolean isProductnameDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, productname);
		return flag;
	}

	public boolean isProductcategoryDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, productcategory);
		return flag;
	}

	public boolean isProductsupplierDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, productsupplier);
		return flag;
	}

	public boolean isProductpurchasepricerDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, productpurchaseprice);
		return flag;
	}

	public boolean isProducttaxDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, producttax);
		return flag;
	}

	public boolean isProducttaxMethodDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, producttaxMethod);
		return flag;
	}

	public boolean isProductpriceDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, productprice);
		return flag;
	}

	public boolean isProductunitDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, productunit);
		return flag;
	}

	public boolean isProductAlertquantityDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, productAlertquantity);
		return flag;
	}

	public boolean isproductOptionsDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, productOptions);
		return flag;
	}

	public boolean isProductimageinputsDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, productimageinput);
		return flag;
	}

	public boolean isProductDescriptionDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, productDescription);
		return flag;
	}

	public boolean isProductColourDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, productColour);
		return flag;
	}

	public boolean isProductSubmitDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, productSubmit);
		return flag;
	}

	public void selectTypeOfProduct(String name) {
		pageutil.elementSelectByValue(driver, producttype, name);
	}

	public void enterCodeOfProduct(String name) {
		elementutil.enterValueToTheElement(driver, productcode, name);
	}

	public void enterNameOfProduct(String name) {
		elementutil.enterValueToTheElement(driver, productname, name);
	}

	public void selectCategoryOfProduct(String name) {
		pageutil.elementSelectByValue(driver, productcategory, name);

	}

	public void selectSupplierOfProduct(String name) {
		pageutil.elementSelectByValue(driver, productsupplier, name);

	}

	public void enterPurchasePriceOfProduct(String name) {
		elementutil.enterValueToTheElement(driver, productpurchaseprice, name);
	}

	public void enterTaxOfProduct(String name) {
		elementutil.enterValueToTheElement(driver, producttax, name);
	}

	public void selectTaxMethod(String name) {
		pageutil.elementSelectByValue(driver, producttaxMethod, name);
	}

	public void enterPriceOfProduct(String name) {
		elementutil.enterValueToTheElement(driver, productprice, name);
	}

	public void enterProductUnit(String name) {
		elementutil.enterValueToTheElement(driver, productunit, name);
	}

	public void enterAlertQuantityofProduct(String name) {
		elementutil.enterValueToTheElement(driver, productAlertquantity, name);
	}

	public void enterProductOption(String name) {
		elementutil.enterValueToTheElement(driver, productOptions, name);
	}

	public void inputProductimage(String url) {
		elementutil.enterValueToTheElement(driver, productimageinput, url);
	}

	public void enterProductDescription(String name) {
		elementutil.enterValueToTheElement(driver, productimageinput, name);
	}

	public void productsubmit() {
		elementutil.clickOnElement(driver, productSubmit);
	}

	public void storeclose() {
		elementutil.clickOnElement(driver,storeclose);
	}

	public String ProductSearch(String name) {
		elementutil.enterValueToTheElement(driver, productSearch, name);
		return name;

	}

	public String getProductCodeFromSearchResults() {
		return elementutil.getTextOfElement(driver, productcode_searchresult);
	}

	public String getProducNameFromSearchResults() {
		return elementutil.getTextOfElement(driver, productname_searchresult);
	}

	public String getProductCategoryFromSearchResults() {
		return elementutil.getTextOfElement(driver, productcategory_searchresult);
	}

	public String getProductTaxFromSearchResults() {
		return elementutil.getTextOfElement(driver, producttax_searchresult);
	}

	public String getProductPriceFromSearchResults() {
		return elementutil.getTextOfElement(driver, producprice_searchresult);
	}

	/*
	 * public void selectMncStoreQuantity(String name) {
	 * pageutil.elementSelectByValue(driver,MNCstore_Quantity,name); } public void
	 * selectMncStorePrice(String name) {
	 * pageutil.elementSelectByValue(driver,MNCstore_price,name); }
	 */
	public void enterMncStoreQuantity(String name) {
		elementutil.enterValueToTheElement(driver, MNCstore_Quantity, name);
	}

	public void enterMncStorePrice(String name) {
		elementutil.enterValueToTheElement(driver, MNCstore_price, name);
	}

	public void ClickStoresubmit() {
		elementutil.clickOnElement(driver, Storesubmit);
	}

	public void deleteActionOnProduct() {
		elementutil.clickOnElement(driver, Productdelete_action);

	}

	public void deleteConfirmationOnProduct() {
		elementutil.clickOnElement(driver, productdelete_confirm);

	}

	public void productViewAction() {
		elementutil.clickOnElement(driver, Productview_action);
		

	}

	public void modifyStockAction() {
		elementutil.clickOnElement(driver, modifyStock_action);

	}

	public void productEditAction() {
		elementutil.clickOnElement(driver, Productedit_action);

	}

	public boolean isInvalidresultFromSearch() {
		boolean flag = elementutil.isElementDisplayed(driver, invalidsearchresult);
		return flag;
	}

}

