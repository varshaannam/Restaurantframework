package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
		lpage.login(prop.getProperty("username"), prop.getProperty("password"));
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
		lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		ppage = hpage.navigateToproductPage();
		excelutil = new ExcelUtil();
		ppage.clickOnAddProduct();
		ppage.selectTypeOfProduct(0);
		String pcode = excelutil.readStringData("Product", 2, 2);
		ppage.enterCodeOfProduct(pcode);
		String pname = excelutil.readStringData("Product", 3, 2);
		ppage.enterNameOfProduct(pname);
		ppage.selectCategoryOfProduct(11);
		ppage.selectSupplierOfProduct(1);
		String ppurchaseprice = excelutil.readStringData("Product", 6, 2);
		ppage.enterPurchasePriceOfProduct(ppurchaseprice);
		String ptax = excelutil.readStringData("Product", 7, 2);
		ppage.enterTaxOfProduct(ptax);
		ppage.selectTaxMethod(0);
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
		soft.assertEquals(ppage.getProductTaxFromSearchResults(), "20", AutomationConstants.ErrorMessage);
		soft.assertAll();
	}

	@Test(priority = 5, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateAddProductWithStockFunctionality() {
		lpage = new LoginPage(driver);
		hpage = new HomePage(driver);
		propertyutil = new PropertyUtil();
		prop = propertyutil.getProperty("config.properties");
		lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		ppage = hpage.navigateToproductPage();
		excelutil = new ExcelUtil();
		ppage.clickOnAddProduct();
		ppage.selectTypeOfProduct(0);
		String scode = excelutil.readStringData("Product", 15, 2);
		ppage.enterCodeOfProduct(scode);
		String sName = excelutil.readStringData("Product", 16, 2);
		ppage.enterNameOfProduct(sName);
		ppage.selectCategoryOfProduct(11);
		ppage.selectSupplierOfProduct(1);
		String sPurchaseprice = excelutil.readStringData("Product", 19, 2);
		ppage.enterPurchasePriceOfProduct(sPurchaseprice);
		String sTax = excelutil.readStringData("Product", 20, 2);
		ppage.enterTaxOfProduct(sTax);
		ppage.selectTaxMethod(0);
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
		lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		ppage = hpage.navigateToproductPage();
		excelutil = new ExcelUtil();
		ppage.clickOnAddProduct();
		ppage.selectTypeOfProduct(0);
		String dCode = excelutil.readStringData("Product", 30, 2);
		ppage.enterCodeOfProduct(dCode);
		String dName = excelutil.readStringData("Product", 31, 2);
		ppage.enterNameOfProduct(dName);
		ppage.selectCategoryOfProduct(11);
		ppage.selectSupplierOfProduct(1);
		String dPurchaseprice = excelutil.readStringData("Product", 34, 2);
		ppage.enterPurchasePriceOfProduct(dPurchaseprice);
		String dTax = excelutil.readStringData("Product", 35, 2);
		ppage.enterTaxOfProduct(dTax);
		ppage.selectTaxMethod(0);
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
		ppage.selectTypeOfProduct(0);
		String vCode = excelutil.readStringData("Product", 45, 2);
		ppage.enterCodeOfProduct(vCode);
		String vName = excelutil.readStringData("Product", 46, 2);
		ppage.enterNameOfProduct(vName);
		ppage.selectCategoryOfProduct(11);
		ppage.selectSupplierOfProduct(1);
		String vPurchaseprice = excelutil.readStringData("Product", 49, 2);
		ppage.enterPurchasePriceOfProduct(vPurchaseprice);
		String vTax = excelutil.readStringData("Product", 50, 2);
		ppage.enterTaxOfProduct(vTax);
		ppage.selectTaxMethod(0);
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
		ppage.ProductSearch(vCode);
		ppage.productViewAction();
		ppage.productviewclose();
		ppage.ProductSearch(vCode);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ppage.getProducNameFromSearchResults(), "home", AutomationConstants.ErrorMessage);
		soft.assertEquals(ppage.getProductTaxFromSearchResults(), "20", AutomationConstants.ErrorMessage);
		soft.assertAll();

	}

	@Test(priority = 8, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateEditActionOnProduct() {
		lpage = new LoginPage(driver);
		hpage = new HomePage(driver);
		propertyutil = new PropertyUtil();
		prop = propertyutil.getProperty("config.properties");
		lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		ppage = hpage.navigateToproductPage();
		excelutil = new ExcelUtil();
		ppage.clickOnAddProduct();
		ppage.selectTypeOfProduct(0);
		String eCode = excelutil.readStringData("Product", 60, 2);
		ppage.enterCodeOfProduct(eCode);
		String eName = excelutil.readStringData("Product", 61, 2);
		ppage.enterNameOfProduct(eName);
		ppage.selectCategoryOfProduct(11);
		ppage.selectSupplierOfProduct(1);
		String ePurchaseprice = excelutil.readStringData("Product", 64, 2);
		ppage.enterPurchasePriceOfProduct(ePurchaseprice);
		String eTax = excelutil.readStringData("Product", 65, 2);
		ppage.enterTaxOfProduct(eTax);
		ppage.selectTaxMethod(0);
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
		ppage.ProductSearch(eCode);
		ppage.productEditAction();
		// String eEditCode = excelutil.readStringData("Product", 71, 2);
		// ppage.enterCodeOfProduct(eEditCode);
		String eEditname = excelutil.readStringData("Product", 72, 2);
		ppage.enterNameOfProduct(eEditname);
		ppage.productWithStoreSubmit();
		ppage.ProductSearch(eCode);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ppage.getProductTaxFromSearchResults(), "20", AutomationConstants.ErrorMessage);
		soft.assertAll();
	}

	@Test(priority = 9, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateModifyStocktActionOnProduct() {
		lpage = new LoginPage(driver);
		hpage = new HomePage(driver);
		propertyutil = new PropertyUtil();
		prop = propertyutil.getProperty("config.properties");
		lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		ppage = hpage.navigateToproductPage();
		excelutil = new ExcelUtil();
		ppage.clickOnAddProduct();
		ppage.selectTypeOfProduct(0);
		String mCode = excelutil.readStringData("Product", 74, 2);
		ppage.enterCodeOfProduct(mCode);
		String mName = excelutil.readStringData("Product", 75, 2);
		ppage.enterNameOfProduct(mName);
		ppage.selectCategoryOfProduct(11);
		ppage.selectSupplierOfProduct(1);
		String mPurchaseprice = excelutil.readStringData("Product", 78, 2);
		ppage.enterPurchasePriceOfProduct(mPurchaseprice);
		String mTax = excelutil.readStringData("Product", 79, 2);
		ppage.enterTaxOfProduct(mTax);
		ppage.selectTaxMethod(0);
		String mprice = excelutil.readStringData("Product", 81, 2);
		ppage.enterPriceOfProduct(mprice);
		String mProductunit = excelutil.readStringData("Product", 82, 2);
		ppage.enterProductUnit(mProductunit);
		String mAlert = excelutil.readStringData("Product", 83, 2);
		ppage.enterAlertQuantityofProduct(mAlert);
		ppage.productWithStoreSubmit();
		String mMncquantity = excelutil.readStringData("Product", 84, 2);
		ppage.enterMncStoreQuantity(mMncquantity);
		String mMncprice = excelutil.readStringData("Product", 85, 2);
		ppage.enterMncStorePrice(mMncprice);
		ppage.ClickStoresubmit();
		ppage.ProductSearch(mCode);
		ppage.modifyStockAction();
		String editMncquantity = excelutil.readStringData("Product", 86, 2);
		ppage.enterMncStoreQuantity(editMncquantity);
		String editMncprice = excelutil.readStringData("Product", 87, 2);
		ppage.enterMncStorePrice(editMncprice);
		ppage.ClickStoresubmit();
		ppage.ProductSearch(mCode);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ppage.getProductTaxFromSearchResults(), "20", AutomationConstants.ErrorMessage);
		soft.assertAll();

	}

	@AfterMethod
	public void postRun() {
		ppage.closeTheWindow();
	}

}
