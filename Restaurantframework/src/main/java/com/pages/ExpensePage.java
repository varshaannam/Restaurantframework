package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;
import com.utilities.WebPageutils;




public class ExpensePage {
	WebDriver driver;
	WebElementUtils  elementutil = new WebElementUtils();
	WebPageutils pageutil = new WebPageutils();
	WaitUtils waitutil = new WaitUtils();

	public ExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[text()='Expense']")
	WebElement expenselink;
	@FindBy(xpath = "//button[@class='btn btn-add btn-lg']")
	WebElement addexpense;
	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	public WebElement expenseDate;
	@FindBy(xpath = "//input[@id='Reference']")
	WebElement expenseReference;
	@FindBy(xpath = "//select[@id='Category']")
	WebElement expensecategory;
	@FindBy(xpath = "//select[@id='store_id']")
	WebElement expenseStore;
	@FindBy(xpath = "//input[@id='Amount']")
	WebElement expenseAmount;
	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement expenseSubmit;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement expense_search;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	WebElement expensedate_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	WebElement expenseReference_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	WebElement expenseamount_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[4]")
	WebElement expenseCategory_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[5]")
	WebElement expensestore_searchresult;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	WebElement expensedelete_action;
	@FindBy(xpath = "//button[text()='Yes, delete it!']")
	WebElement expensedelete_confirm;
	@FindBy(xpath = "//i[@class='fa fa-pencil']")
	WebElement expenseEdit_action;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	WebElement invalidsearchresult;

		public void clickOnAddexpenseElement() {
		elementutil.clickOnElement(driver, addexpense);
		waitutil.presenceOfElementLocated(driver, addexpense, 5);
	}

	public boolean isAddcustomerElementDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, addexpense);
		return flag;
	}

	public boolean isreferenceOfexpenserDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, expenseReference);
		return flag;
	}

	public boolean isDateOfCustomerDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, expenseDate);
		return flag;
	}

	public boolean isamountOfexpenseDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, expenseAmount);
		return flag;
	}

	public boolean iscategoryOfexpenseDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, expensecategory);
		return flag;

	}

	public boolean isstoreOfexpenseDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, expenseStore);
		return flag;

	}

	public void submitofexpense() {
		elementutil.clickOnElement(driver, expenseSubmit);
		waitutil.ElementTobeClickable(driver,expenseSubmit , 5);
	}

	public void clickOnExpenseElement() {
		elementutil.clickOnElement(driver, expenselink);
	}

	public void clickOnAddExpenseElement() {
		elementutil.clickOnElement(driver, addexpense);
		waitutil.ElementTobeClickable(driver, addexpense,10);
	}

	public void enterDateofExpense(String name) {
		elementutil.enterValueToTheElement(driver, expenseDate, name);
	}

	public void enterRefrerencOfExpense(String name) {
		elementutil.enterValueToTheElement(driver, expenseReference, name);
	}

	public void enterAmountOfExpense(String name) {
		elementutil.enterValueToTheElement(driver, expenseAmount, name);

	}

	public void selectCategoryofExpense(String name) {
		pageutil.elementSelectByValue(driver, expensecategory, name);
	}

	public void selectStoreofExpense(String name) {
		pageutil.elementSelectByValue(driver, expenseStore, name);
	}

	public void submitOfExpense() {
		elementutil.clickOnElement(driver, expenseSubmit);
	}

	public String enterSearchofexpenseElement(String name) {
		elementutil.clearTheElement(driver, expense_search);
		elementutil.enterValueToTheElement(driver, expense_search, name);
		return name;

	}

	public String getexpenseDateFromSearchResults() {
		return elementutil.getTextOfElement(driver, expensedate_searchresult);
	}

	public String getrefrenceOfExpenseFromSearchResults() {
		return elementutil.getTextOfElement(driver, expenseReference_searchresult);
	}

	public String getAmountofExpenseFromSearchResults() {
		return elementutil.getTextOfElement(driver, expenseamount_searchresult);
	}

	public String getstoreofExpenseFromSearchResults() {
		return elementutil.getTextOfElement(driver, expensestore_searchresult);
	}

	public String getCategoryofExpenseFromSearchResults() {
		return elementutil.getTextOfElement(driver, expenseCategory_searchresult);
	}

	public void deleteActionOnExpense() {
		elementutil.clickOnElement(driver, expensedelete_action);

	}

	public void deleteConfirmationOnExpenser() {
		elementutil.clickOnElement(driver, expensedelete_confirm);

	}

	public void clickOnAmountofExpenser() {
		elementutil.clickOnElement(driver, expenseAmount);

	}

	public void EditActiononExpense() {
		elementutil.clickOnElement(driver, expenseEdit_action);

	}

	public boolean isInvalidresultFromSearch() {
		boolean flag = elementutil.isElementDisplayed(driver, invalidsearchresult);
		return flag;
	}

	public void clearActionOnexpenserdate() {
		elementutil.clearTheElement(driver, expenseDate);
		;

	}

}

