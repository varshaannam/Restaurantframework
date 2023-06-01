package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.utilities.ExcelUtil;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;

public class ProductPageTest extends AutomationBase {
	LoginPage lpage;
	HomePage hpage;
	ProductPage ppage;
	ExcelUtil excelutil;
	Properties prop;
	PropertyUtil propertyutil;

	@Test(priority = 3, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateElementsOnProduct() {
		lpage = new LoginPage(driver);
		hpage = new HomePage(driver);
		propertyutil = new PropertyUtil();
		prop = propertyutil.getProperty("config.properties");
		lpage.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		ppage = hpage.navigateToproductPage();
		excelutil = new ExcelUtil();
		ppage.clickOnAddProduct();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(ppage.isAddProductDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(ppage.isProductTypeDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(ppage.isProductCodeDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(ppage.isProductnameDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(ppage.isProductcategoryDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(ppage.isProductsupplierDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 4, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateAddProductWithoutStockFunctionality() {
		lpage = new LoginPage(driver);
		hpage = new HomePage(driver);
		propertyutil = new PropertyUtil();
		prop = propertyutil.getProperty("config.properties");
		lpage.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		ppage = hpage.navigateToproductPage();
		excelutil = new ExcelUtil();
		ppage.clickOnAddProduct();
		String ptype = excelutil.readStringData("Product", 1, 2);
		ppage.selectTypeOfProduct(ptype);
		String pcode = excelutil.readStringData("Product", 2, 2);
		ppage.enterCodeOfProduct(pcode);
		String pname = excelutil.readStringData("Product", 3, 2);
		ppage.enterNameOfProduct(pname);
		String pcategory = excelutil.readStringData("Product", 4, 2);
		ppage.selectCategoryOfProduct(pcategory);
		String psupplier = excelutil.readStringData("Product", 5, 2);
		ppage.selectSupplierOfProduct(psupplier);
		String ppurchaseprice = excelutil.readStringData("Product", 6, 2);
		ppage.enterPurchasePriceOfProduct(ppurchaseprice);
		String ptax = excelutil.readStringData("Product", 7, 2);
		ppage.enterTaxOfProduct(ptax);
		String ptaxmethod = excelutil.readStringData("Product", 8, 2);
		ppage.selectTaxMethod(ptaxmethod);
		String pprice = excelutil.readStringData("Product", 9, 2);
		ppage.enterPriceOfProduct(pprice);
		String punit = excelutil.readStringData("Product", 10, 2);
		ppage.enterProductUnit(punit);
		String palertquantity = excelutil.readStringData("Product", 11, 2);
		ppage.enterAlertQuantityofProduct(palertquantity);
		String poption = excelutil.readStringData("Product", 12, 2);
		ppage.enterProductOption(poption);
		String pdescription = excelutil.readStringData("Product", 13, 2);
		ppage.enterProductDescription(pdescription);
		ppage.productsubmit();
		ppage.ProductSearch(pcode);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ppage.getProductCodeFromSearchResults(), "2020", AutomationConstants.ErrorMessage);
		soft.assertEquals(ppage.getProducNameFromSearchResults(), "Casa", AutomationConstants.ErrorMessage);
		soft.assertEquals(ppage.getProductCategoryFromSearchResults(), "Pizza", AutomationConstants.ErrorMessage);
		soft.assertEquals(ppage.getProductTaxFromSearchResults(), "20", AutomationConstants.ErrorMessage);
		soft.assertAll();
	}

	@Test(priority = 5, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateAddProductWithStockFunctionality() {
		lpage = new LoginPage(driver);
		hpage = new HomePage(driver);
		propertyutil = new PropertyUtil();
		prop = propertyutil.getProperty("config.properties");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		lpage.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		ppage = hpage.navigateToproductPage();
		excelutil = new ExcelUtil();
		ppage.clickOnAddProduct();
		String stype = excelutil.readStringData("Product", 14, 2);
		ppage.selectTypeOfProduct(stype);
		String scode = excelutil.readStringData("Product", 15, 2);
		ppage.enterCodeOfProduct(scode);
		String sName = excelutil.readStringData("Product", 16, 2);
		ppage.enterNameOfProduct(sName);
		String sCategory = excelutil.readStringData("Product", 17, 2);
		ppage.selectCategoryOfProduct(sCategory);
		String sSupplier = excelutil.readStringData("Product", 18, 2);
		ppage.selectSupplierOfProduct(sSupplier);
		String sPurchaseprice = excelutil.readStringData("Product", 19, 2);
		ppage.enterPurchasePriceOfProduct(sPurchaseprice);
		String sTax = excelutil.readStringData("Product", 20, 2);
		ppage.enterTaxOfProduct(sTax);
		String sTaxmethod = excelutil.readStringData("Product", 21, 2);
		ppage.selectTaxMethod(sTaxmethod);
		String sPrice = excelutil.readStringData("Product", 22, 2);
		ppage.enterPriceOfProduct(sPrice);
		String sUnit = excelutil.readStringData("Product", 23, 2);
		ppage.enterProductUnit(sUnit);
		String sAlertquantity = excelutil.readStringData("Product", 24, 2);
		ppage.enterAlertQuantityofProduct(sAlertquantity);
		String sOption = excelutil.readStringData("Product", 25, 2);
		ppage.enterProductOption(sOption);
		String sDescription = excelutil.readStringData("Product", 26, 2);
		ppage.enterProductDescription(sDescription);
		ppage.productWithStoreSubmit();
		String sMncstorequantity = excelutil.readStringData("Product", 27, 2);
		ppage.enterMncStoreQuantity(sMncstorequantity);
		String sMncStoreprice = excelutil.readStringData("Product", 28, 2);
		ppage.enterMncStorePrice(sMncStoreprice);
		ppage.ClickStoresubmit();
		String pSearch = excelutil.readStringData("Product", 15, 2);
		ppage.ProductSearch(pSearch);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ppage.getProductCodeFromSearchResults(), "2030", "Failure message:productcode is not match");
		soft.assertEquals(ppage.getProducNameFromSearchResults(), "home", "Failure message:productname is not match");
		soft.assertEquals(ppage.getProductTaxFromSearchResults(), "20", "Failure message:producttax is not match");
		soft.assertAll();

	}

	@Test(priority = 6, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateDeleteActionOnProduct() {
		lpage = new LoginPage(driver);
		hpage = new HomePage(driver);
		propertyutil = new PropertyUtil();
		prop = propertyutil.getProperty("config.properties");
		lpage.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		ppage = hpage.navigateToproductPage();
		excelutil = new ExcelUtil();
		ppage.clickOnAddProduct();
		String dtype = excelutil.readStringData("Product", 29, 2);
		ppage.selectTypeOfProduct(dtype);
		String dCode = excelutil.readStringData("Product", 30, 2);
		ppage.enterCodeOfProduct(dCode);
		String dName = excelutil.readStringData("Product", 31, 2);
		ppage.enterNameOfProduct(dName);
		String dCategory = excelutil.readStringData("Product", 32, 2);
		ppage.selectCategoryOfProduct(dCategory);
		String dSupplier = excelutil.readStringData("Product", 33, 2);
		ppage.selectSupplierOfProduct(dSupplier);
		String dPurchaseprice = excelutil.readStringData("Product", 34, 2);
		ppage.enterPurchasePriceOfProduct(dPurchaseprice);
		String dTax = excelutil.readStringData("Product", 35, 2);
		ppage.enterTaxOfProduct(dTax);
		String dTaxMethod = excelutil.readStringData("Product", 36, 2);
		ppage.selectTaxMethod(dTaxMethod);
		String dPrice = excelutil.readStringData("Product", 37, 2);
		ppage.enterPriceOfProduct(dPrice);
		String dProductunit = excelutil.readStringData("Product", 38, 2);
		ppage.enterProductUnit(dProductunit);
		String Alertquantity = excelutil.readStringData("Product", 39, 2);
		ppage.enterAlertQuantityofProduct(Alertquantity);
		String dOption = excelutil.readStringData("Product", 40, 2);
		ppage.enterProductOption(dOption);
		String dDescription = excelutil.readStringData("Product", 41, 2);
		ppage.enterProductDescription(dDescription);
		ppage.productWithStoreSubmit();
		String dMncstorequantity = excelutil.readStringData("Product", 42, 2);
		ppage.enterMncStoreQuantity(dMncstorequantity);
		String dmncstoreprice = excelutil.readStringData("Product", 43, 2);
		ppage.enterMncStorePrice(dmncstoreprice);
		ppage.ClickStoresubmit();
		ppage.deleteActionOnProduct();
		ppage.deleteConfirmationOnProduct();
		String dsearch = excelutil.readStringData("Product", 30, 2);
		ppage.ProductSearch("dsearch");
		Assert.assertTrue(ppage.isInvalidresultFromSearch());
	}

	@Test(priority = 7, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateViewActionOnProduct() {
		lpage = new LoginPage(driver);
		hpage = new HomePage(driver);
		propertyutil = new PropertyUtil();
		prop = propertyutil.getProperty("config.properties");
		lpage.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		ppage = hpage.navigateToproductPage();
		excelutil = new ExcelUtil();
		ppage.clickOnAddProduct();
		String vType = excelutil.readStringData("Product", 44, 2);
		ppage.selectTypeOfProduct(vType);
		String vCode = excelutil.readStringData("Product", 45, 2);
		ppage.enterCodeOfProduct(vCode);
		String vName = excelutil.readStringData("Product", 46, 2);
		ppage.enterNameOfProduct(vName);
		String vCategory = excelutil.readStringData("Product", 47, 2);
		ppage.selectCategoryOfProduct(vCategory);
		String vSupplier = excelutil.readStringData("Product", 48, 2);
		ppage.selectSupplierOfProduct(vSupplier);
		String vPurchaseprice = excelutil.readStringData("Product", 49, 2);
		ppage.enterPurchasePriceOfProduct(vPurchaseprice);
		String vTax = excelutil.readStringData("Product", 50, 2);
		ppage.enterTaxOfProduct(vTax);
		String vTaxmethod = excelutil.readStringData("Product", 51, 2);
		ppage.selectTaxMethod(vTaxmethod);
		String vprice = excelutil.readStringData("Product", 52, 2);
		ppage.enterPriceOfProduct(vprice);
		String vUnit = excelutil.readStringData("Product", 53, 2);
		ppage.enterProductUnit(vUnit);
		String vAlert = excelutil.readStringData("Product", 54, 2);
		ppage.enterAlertQuantityofProduct(vAlert);
		String voption = excelutil.readStringData("Product", 55, 2);
		ppage.enterProductOption(voption);
		String vDescription = excelutil.readStringData("Product", 56, 2);
		ppage.enterProductDescription(vDescription);
		ppage.productWithStoreSubmit();
		String mncquantity = excelutil.readStringData("Product", 57, 2);
		ppage.enterMncStoreQuantity(mncquantity);
		String mncprice = excelutil.readStringData("Product", 58, 2);
		ppage.enterMncStorePrice(mncprice);
		ppage.ClickStoresubmit();
		ppage.productViewAction();
		ppage.ProductSearch(vCode);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ppage.getProductCodeFromSearchResults(), "2032", AutomationConstants.ErrorMessage);
		soft.assertEquals(ppage.getProducNameFromSearchResults(), "home", AutomationConstants.ErrorMessage);
		soft.assertEquals(ppage.getProductCategoryFromSearchResults(), "Pizza", AutomationConstants.ErrorMessage);
		soft.assertEquals(ppage.getProductTaxFromSearchResults(), "20", AutomationConstants.ErrorMessage);
		soft.assertAll();

	}

	@Test(priority = 8, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateEditActionOnProduct() {
		lpage = new LoginPage(driver);
		hpage = new HomePage(driver);
		propertyutil = new PropertyUtil();
		prop = propertyutil.getProperty("config.properties");
		lpage.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		ppage = hpage.navigateToproductPage();
		excelutil = new ExcelUtil();
		ppage.clickOnAddProduct();
		String eType = excelutil.readStringData("Product", 59, 2);
		ppage.selectTypeOfProduct(eType);
		String eCode = excelutil.readStringData("Product", 60, 2);
		ppage.enterCodeOfProduct(eCode);
		String eName = excelutil.readStringData("Product", 61, 2);
		ppage.enterNameOfProduct(eName);
		String eCategory = excelutil.readStringData("Product", 62, 2);
		ppage.selectCategoryOfProduct(eCategory);
		String eSupplier = excelutil.readStringData("Product", 63, 2);
		ppage.selectSupplierOfProduct(eSupplier);
		String ePurchaseprice = excelutil.readStringData("Product", 64, 2);
		ppage.enterPurchasePriceOfProduct(ePurchaseprice);
		String eTax = excelutil.readStringData("Product", 65, 2);
		ppage.enterTaxOfProduct(eTax);
		String eTaxmethod = excelutil.readStringData("Product", 66, 2);
		ppage.selectTaxMethod(eTaxmethod);
		String eProductunit = excelutil.readStringData("Product", 67, 2);
		ppage.enterPriceOfProduct(eProductunit);
		String eAlert = excelutil.readStringData("Product", 68, 2);
		ppage.enterAlertQuantityofProduct(eAlert);
		ppage.productWithStoreSubmit();
		String eMncquantity = excelutil.readStringData("Product", 69, 2);
		ppage.enterMncStoreQuantity(eMncquantity);
		String eMncprice = excelutil.readStringData("Product", 70, 2);
		ppage.enterMncStorePrice(eMncprice);
		ppage.ClickStoresubmit();
		ppage.productEditAction();
		String eEditCode = excelutil.readStringData("Product", 71, 2);
		ppage.enterCodeOfProduct(eEditCode);
		String eEditname = excelutil.readStringData("Product", 72, 2);
		ppage.enterNameOfProduct(eEditname);
		ppage.productWithStoreSubmit();
		ppage.ProductSearch(eEditCode);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ppage.getProductCodeFromSearchResults(), "2034", AutomationConstants.ErrorMessage);
		soft.assertEquals(ppage.getProducNameFromSearchResults(), "home", AutomationConstants.ErrorMessage);
		soft.assertEquals(ppage.getProductCategoryFromSearchResults(), "Pizza", AutomationConstants.ErrorMessage);
		soft.assertEquals(ppage.getProductTaxFromSearchResults(), "20", AutomationConstants.ErrorMessage);
		soft.assertAll();
	}

	@Test(priority = 9, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateModifyStocktActionOnProduct() {
		lpage = new LoginPage(driver);
		hpage = new HomePage(driver);
		propertyutil = new PropertyUtil();
		prop = propertyutil.getProperty("config.properties");
		lpage.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		ppage = hpage.navigateToproductPage();
		excelutil = new ExcelUtil();
		ppage.clickOnAddProduct();
		String mType = excelutil.readStringData("Product", 73, 2);
		ppage.selectTypeOfProduct(mType);
		String mCode = excelutil.readStringData("Product", 74, 2);
		ppage.enterCodeOfProduct(mCode);
		String mName = excelutil.readStringData("Product", 75, 2);
		ppage.enterNameOfProduct(mName);
		String mCategory = excelutil.readStringData("Product", 76, 2);
		ppage.selectCategoryOfProduct(mCategory);
		String mSupplier = excelutil.readStringData("Product", 77, 2);
		ppage.selectSupplierOfProduct(mSupplier);
		String mPurchaseprice = excelutil.readStringData("Product", 78, 2);
		ppage.enterPurchasePriceOfProduct(mPurchaseprice);
		String mTax = excelutil.readStringData("Product", 79, 2);
		ppage.enterTaxOfProduct(mTax);
		String mTaxmethod = excelutil.readStringData("Product", 80, 2);
		ppage.selectTaxMethod(mTaxmethod);
		String mprice = excelutil.readStringData("Product", 81, 2);
		ppage.enterPriceOfProduct(mprice);
		String mProductunit = excelutil.readStringData("Product", 82, 2);
		ppage.enterProductUnit(mProductunit);
		String mAlert = excelutil.readStringData("Product", 83, 2);
		ppage.enterAlertQuantityofProduct(mAlert);
		ppage.productWithStoreSubmit();
		String mMncquantity = excelutil.readStringData("Product", 84, 2);
		ppage.enterMncStoreQuantity("mMncquantity");
		String mMncprice = excelutil.readStringData("Product", 85, 2);
		ppage.enterMncStorePrice("mMncprice");
		ppage.ClickStoresubmit();
		ppage.modifyStockAction();
		String editMncquantity = excelutil.readStringData("Product", 86, 2);
		ppage.enterMncStoreQuantity("editMncquantity");
		String editMncprice = excelutil.readStringData("Product", 87, 2);
		ppage.enterMncStorePrice("editMncprice");
		ppage.ClickStoresubmit();
		ppage.ProductSearch(mCode);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ppage.getProductCodeFromSearchResults(), "2034", AutomationConstants.ErrorMessage);
		soft.assertEquals(ppage.getProducNameFromSearchResults(), "home", AutomationConstants.ErrorMessage);
		soft.assertEquals(ppage.getProductCategoryFromSearchResults(), "Pizza", AutomationConstants.ErrorMessage);
		soft.assertEquals(ppage.getProductTaxFromSearchResults(), "20", AutomationConstants.ErrorMessage);
		soft.assertAll();

	}

}
