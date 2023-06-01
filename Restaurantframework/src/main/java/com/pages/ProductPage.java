package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;
import com.utilities.WebPageutils;
import com.utilities.BrowserUtils;


public class ProductPage {
	WebDriver driver;
	WebElementUtils elementutil = new WebElementUtils();
	WebPageutils pageutil = new WebPageutils();
	WaitUtils waitutil = new WaitUtils();
	BrowserUtils browserutil = new BrowserUtils();
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[text()='Product']")
	private WebElement productlink;
	@FindBy(xpath = "//button[text()='Add Product']")
	private WebElement addProduct;
	@FindBy(xpath = "//select[@id='Type']")
	private WebElement producttype;
	@FindBy(xpath = "//input[@id='ProductCode']")
	private WebElement productcode;
	@FindBy(xpath = "//input[@id='ProductName']")
	private WebElement productname;
	@FindBy(xpath = "//select[@id='Category']")
	private WebElement productcategory;
	@FindBy(xpath = "//select[@name='supplier']")
	private WebElement productsupplier;
	@FindBy(xpath = "//input[@id='PurchasePrice']")
	private WebElement productpurchaseprice;
	@FindBy(xpath = "//input[@id='Tax']")
	private WebElement producttax;
	@FindBy(xpath = "//select[@id='taxType']")
	private WebElement producttaxMethod;
	@FindBy(xpath = "//input[@id='Price']")
	private WebElement productprice;
	@FindBy(xpath = "//input[@id='Unit']")
	private WebElement productunit;
	@FindBy(xpath = "//input[@id='AlertQt']")
	private WebElement productAlertquantity;
	@FindBy(xpath = "//textarea[@id='ProductOptions']")
	private WebElement productOptions;
	@FindBy(xpath = "")
	private WebElement productimageinput;
	@FindBy(xpath = "//div[@class='note-editable panel-body']")
	private WebElement productDescription;
	@FindBy(xpath = "//label[@class='btn color02 active']")
	private WebElement productColour;
	@FindBy(xpath = "//button[text()='Submit'][1]")
	private WebElement productSubmit;
	@FindBy(xpath = "(//button[text()='Close'])[5]")
	private  WebElement storeclose;
	@FindBy(xpath = "//input[@type='search']")
	private WebElement productSearch;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	private WebElement productcode_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	private WebElement productname_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	private WebElement productcategory_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[5]")
	private WebElement producttax_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[6]")
	private WebElement producprice_searchresult;
	@FindBy(xpath = "(//input[@id='quantity'])[1]")
	private WebElement MNCstore_Quantity;
	@FindBy(xpath = "(//input[@id='pricestr'])[1]")
	private WebElement MNCstore_price;
	@FindBy(xpath = "(//button[@class='btn btn-add hiddenpr'])[2]")
	private WebElement Storesubmit;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	private WebElement Productdelete_action;
	@FindBy(xpath = "//a[text()='Yes, delete it!']")
	private  WebElement productdelete_confirm;
	@FindBy(xpath = "//i[@class='fa fa-file-text']")
	private  WebElement Productview_action;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[3]")
	private WebElement Productedit_action;
	@FindBy(xpath = "(//i[@class='fa fa-tasks'])[1]")
	private WebElement modifyStock_action;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	private WebElement invalidsearchresult;
	@FindBy(xpath ="(//button[text()='Close'])[5]")
	private WebElement Productclose_action;

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
		waitutil.ElementTobeClickable(driver,addProduct,5);
		elementutil.clickOnElement(driver,addProduct);


	}

	public boolean isProductTypeDisplayed() {
		waitutil.ElementTobeClickable(driver,producttype ,20);
		boolean flag = elementutil.isElementDisplayed(driver, producttype);
		return flag;
	}

	public boolean isProductCodeDisplayed() {
		waitutil.ElementTobeClickable(driver,productcode ,20);
		boolean flag = elementutil.isElementDisplayed(driver, productcode);
		return flag;
	}

	public boolean isProductnameDisplayed() {
		waitutil.ElementTobeClickable(driver, productname,20);
		boolean flag = elementutil.isElementDisplayed(driver, productname);
		return flag;
	}

	public boolean isProductcategoryDisplayed() {
		waitutil.ElementTobeClickable(driver, productcategory,20);
		boolean flag = elementutil.isElementDisplayed(driver, productcategory);
		return flag;
	}

	public boolean isProductsupplierDisplayed() {
		waitutil.ElementTobeClickable(driver,productsupplier ,20);
		boolean flag = elementutil.isElementDisplayed(driver, productsupplier);
		return flag;
	}

	public boolean isProductpurchasepricerDisplayed() {
		waitutil.ElementTobeClickable(driver, productpurchaseprice,20);
		boolean flag = elementutil.isElementDisplayed(driver, productpurchaseprice);
		return flag;
	}

	public boolean isProducttaxDisplayed() {
		waitutil.ElementTobeClickable(driver,producttax ,20);
		boolean flag = elementutil.isElementDisplayed(driver, producttax);
		return flag;
	}

	public boolean isProducttaxMethodDisplayed() {
		waitutil.ElementTobeClickable(driver,producttaxMethod ,20);
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

	public void selectTypeOfProduct(int value) {
		elementutil.clearTheElement(driver, producttype);
		pageutil.elementSelectByIndex(driver,producttype,value);
	}

	public void enterCodeOfProduct(String name) {
		elementutil.clearTheElement(driver, productcode);
		elementutil.enterValueToTheElement(driver, productcode, name);
	}

	public void enterNameOfProduct(String name) {
		elementutil.clearTheElement(driver,productname );
		elementutil.enterValueToTheElement(driver, productname, name);
	}

	public void selectCategoryOfProduct(int value) {
		pageutil.elementSelectByIndex(driver,productcategory ,value);


	}

	public void selectSupplierOfProduct(int value) {
		elementutil.clearTheElement(driver,productsupplier );
		pageutil.elementSelectByIndex(driver, productsupplier, value);


	}

	public void enterPurchasePriceOfProduct(String name) {
		elementutil.clearTheElement(driver,productpurchaseprice );
		elementutil.enterValueToTheElement(driver, productpurchaseprice, name);
	}

	public void enterTaxOfProduct(String name) {
		elementutil.clearTheElement(driver,producttax );
		elementutil.enterValueToTheElement(driver, producttax, name);
	}

	public void selectTaxMethod(int value) {
		elementutil.clearTheElement(driver,producttaxMethod );
		pageutil.elementSelectByIndex(driver, producttaxMethod, value);

	}

	public void enterPriceOfProduct(String name) {
		elementutil.clearTheElement(driver, productprice);
		elementutil.enterValueToTheElement(driver, productprice, name);
	}

	public void enterProductUnit(String name) {
		elementutil.clearTheElement(driver, productunit);
		elementutil.enterValueToTheElement(driver, productunit, name);
	}

	public void enterAlertQuantityofProduct(String name) {
		elementutil.clearTheElement(driver,productAlertquantity );
		elementutil.enterValueToTheElement(driver, productAlertquantity, name);
	}

	public void enterProductOption(String name) {
		elementutil.clearTheElement(driver, productOptions);
		elementutil.enterValueToTheElement(driver, productOptions, name);
	}

	public void inputProductimage(String url) {
		elementutil.enterValueToTheElement(driver, productimageinput, url);
	}

	public void enterProductDescription(String name) {
		elementutil.clearTheElement(driver, productDescription);
		elementutil.enterValueToTheElement(driver, productDescription, name);
	}

	public void productsubmit() {
		elementutil.clickOnElement(driver, productSubmit);
		waitutil.ElementTobeClickable(driver,storeclose,15);
		elementutil.clickOnElement(driver, storeclose);
	}

	public void productWithStoreSubmit() {
		elementutil.clickOnElement(driver, productSubmit);

			}

	public String ProductSearch(String name) {
		elementutil.clearTheElement(driver,productSearch );
		waitutil.ElementTobeClickable(driver,productSearch , 5);
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
		waitutil.ElementTobeClickable(driver, Storesubmit, 15);
	}

	public void deleteActionOnProduct() {
		elementutil.clickOnElement(driver, Productdelete_action);

	}

	public void deleteConfirmationOnProduct() {
		elementutil.clickOnElement(driver, productdelete_confirm);

	}

	public void productViewAction() {
		elementutil.clearTheElement(driver,Productview_action );
		waitutil.ElementTobeClickable(driver, Productview_action, 20);
		elementutil.clickOnElement(driver, Productview_action);

	}

	public void modifyStockAction() {
		elementutil.clearTheElement(driver,modifyStock_action );
		elementutil.clickOnElement(driver, modifyStock_action);

	}

	public void productEditAction() {
		elementutil.clearTheElement(driver, Productedit_action);
		elementutil.clickOnElement(driver, Productedit_action);

	}

	public boolean isInvalidresultFromSearch() {
		boolean flag = elementutil.isElementDisplayed(driver, invalidsearchresult);
		return flag;
	}
	public void closeTheWindow() {
		browserutil.quitWindow(driver);
	}
	public void productviewclose() {
		waitutil.ElementTobeClickable(driver, Productclose_action, 15);
		elementutil.clickOnElement(driver, Productclose_action);
	


	}}

