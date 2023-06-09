package com.test;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.ExpensePage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.utilities.BrowserUtils;
import com.utilities.ExcelUtil;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;

public class ExpensePageTest extends AutomationBase {
	LoginPage lpage;
	HomePage hpage;
	ExpensePage npage;
	Properties prop;
	ExcelUtil excelutil;
	PropertyUtil propertyutil;
	BrowserUtils browser = new BrowserUtils();

	@Test(priority = 14, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateElementsOnExpense() {

		lpage = new LoginPage(driver);
		hpage = new HomePage(driver);
		propertyutil = new PropertyUtil();
		prop = propertyutil.getProperty("config.properties");
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		npage = hpage.navigateToExpensePage();
		excelutil = new ExcelUtil();
		npage.clickOnExpenseElement();
		npage.clickOnAddExpenseElement();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(npage.isDateOfCustomerDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(npage.isreferenceOfexpenserDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(npage.iscategoryOfexpenseDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(npage.isstoreOfexpenseDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertTrue(npage.isamountOfexpenseDisplayed(), AutomationConstants.LinkDisplayCheck);
		soft.assertAll();

	}

	@Test(priority = 14, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateAddexpenseFunctionality() {
		lpage = new LoginPage(driver);
		hpage = new HomePage(driver);
		propertyutil = new PropertyUtil();
		prop = propertyutil.getProperty("config.properties");
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		npage = hpage.navigateToExpensePage();
		excelutil = new ExcelUtil();
		npage.clickOnExpenseElement();
		npage.clickOnAddExpenseElement();
		String expensedate = excelutil.readStringData("expense", 1, 2);
		npage.enterDateofExpense(expensedate);
		npage.clickOnAmountofExpenser();
		String expenseamount = excelutil.readStringData("expense", 2, 2);
		npage.enterAmountOfExpense(expenseamount);
		String expenseReference = excelutil.readStringData("expense", 3, 2);
		npage.enterRefrerencOfExpense(expenseReference);
		String expensecategory = excelutil.readStringData("expense", 4, 2);
		npage.selectCategoryofExpense(expensecategory);
		String expenseStore = excelutil.readStringData("expense", 5, 2);
		npage.selectStoreofExpense(expenseStore);
		npage.submitofexpense();
		npage.enterSearchofexpenseElement(expensedate);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(npage.getexpenseDateFromSearchResults(), "23/03/2023",AutomationConstants.ErrorMessage);
		soft.assertEquals(npage.getAmountofExpenseFromSearchResults(), "20000", AutomationConstants.ErrorMessage);
		soft.assertEquals(npage.getrefrenceOfExpenseFromSearchResults(), "refrence note",
				AutomationConstants.ErrorMessage);
		soft.assertEquals(npage.getCategoryofExpenseFromSearchResults(), "Fruits", AutomationConstants.ErrorMessage);
		soft.assertEquals(npage.getstoreofExpenseFromSearchResults(), "D4", AutomationConstants.ErrorMessage);
		soft.assertAll();
	}

	@Test(priority = 15, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validatedeleteExpenseFunctionality() {
		lpage = new LoginPage(driver);
		hpage = new HomePage(driver);
		propertyutil = new PropertyUtil();
		prop = propertyutil.getProperty("config.properties");
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		npage = hpage.navigateToExpensePage();
		excelutil = new ExcelUtil();
		npage.clickOnExpenseElement();
		npage.clickOnAddExpenseElement();
		String expensedate = excelutil.readStringData("expense", 6, 2);
		npage.enterDateofExpense(expensedate);
		String expenseamount = excelutil.readStringData("expense", 7, 2);
		npage.enterAmountOfExpense(expenseamount);
		String expenseReference = excelutil.readStringData("expense", 8, 2);
		npage.enterRefrerencOfExpense(expenseReference);
		String expensecategory = excelutil.readStringData("expense", 9, 2);
		npage.selectCategoryofExpense(expensecategory);
		String expenseStore = excelutil.readStringData("expense", 10, 2);
		npage.selectStoreofExpense(expenseStore);
		npage.submitofexpense();
		npage.enterSearchofexpenseElement(expensedate);
		npage.deleteActionOnExpense();
		npage.deleteConfirmationOnExpenser();
		npage.enterSearchofexpenseElement(expensedate);
		Assert.assertTrue(npage.isInvalidresultFromSearch());
	}

	@Test(priority = 16, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateEditExpenseFunctionality() {
		lpage = new LoginPage(driver);
		hpage = new HomePage(driver);
		propertyutil = new PropertyUtil();
		prop = propertyutil.getProperty("config.properties");
		hpage = lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		npage = hpage.navigateToExpensePage();
		excelutil = new ExcelUtil();
		npage.clickOnExpenseElement();
		npage.clickOnAddExpenseElement();
		String expensedate = excelutil.readStringData("expense", 11, 2);
		npage.enterDateofExpense(expensedate);
		String expenseamount = excelutil.readStringData("expense", 12, 2);
		npage.enterAmountOfExpense(expenseamount);
		String expenseReference = excelutil.readStringData("expense", 13, 2);
		npage.enterRefrerencOfExpense(expenseReference);
		String expensecategory = excelutil.readStringData("expense", 14, 2);
		npage.selectCategoryofExpense(expensecategory);
		String expensestore = excelutil.readStringData("expense", 15, 2);
		npage.selectStoreofExpense(expensestore);
		npage.submitofexpense();
		npage.enterSearchofexpenseElement(expensedate);
		npage.EditActiononExpense();
		npage.clearActionOnexpenserdate();
		String expensedate1 = excelutil.readStringData("expense", 16, 2);
		npage.enterDateofExpense(expensedate1);
		npage.submitOfExpense();
		npage.enterSearchofexpenseElement(expensedate1);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(npage.getexpenseDateFromSearchResults(), "14/04/2023", AutomationConstants.ErrorMessage);
		soft.assertEquals(npage.getAmountofExpenseFromSearchResults(), "20000", AutomationConstants.ErrorMessage);
		soft.assertEquals(npage.getrefrenceOfExpenseFromSearchResults(), "refrence note",
				AutomationConstants.ErrorMessage);
		soft.assertEquals(npage.getCategoryofExpenseFromSearchResults(), "Fruits", AutomationConstants.ErrorMessage);
		soft.assertEquals(npage.getstoreofExpenseFromSearchResults(), "D4", AutomationConstants.ErrorMessage);
		soft.assertAll();

	}
	@AfterMethod
	public void postRun() {
		npage.closeTheWindow();
	}

}
