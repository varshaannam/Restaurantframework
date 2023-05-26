package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WebElementUtils;

public class HomePage {
	WebDriver driver;
	WebElementUtils elementutil = new WebElementUtils();
	@FindBy(xpath = "//span[text()='POS']")
	WebElement poslink;
	@FindBy(xpath = "//span[text()='Product']")
	WebElement productlink;
	@FindBy(xpath = "//span[text()='Stores']")
	WebElement storelink;
	@FindBy(xpath = "//span[text()='People']")
	WebElement peoplelink;
	@FindBy(xpath = "//span[text()='Sales']")
	WebElement saleslink;
	@FindBy(xpath = "//span[text()='Expense']")
	WebElement expenselink;
	@FindBy(xpath = "//span[text()='Categories ']")
	WebElement categorieslink;
	@FindBy(xpath = "//span[text()='Setting']")
	WebElement settinglink;
	@FindBy(xpath = "//span[text()='Reports']")
	WebElement reportlink;
	@FindBy(xpath = "//li[@class='dropdown language']")
	WebElement language;
	@FindBy(xpath = "//i[@class='fa fa-sign-out fa-lg']")
	WebElement logout;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method is to check whether elements are displayed
	 * 
	 * @return
	 */

	public boolean isPosLinkDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, poslink);
		return flag;
	}

	public boolean isProductDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, productlink);
		return flag;
	}

	public boolean isStoreDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, storelink);
		return flag;
	}

	public boolean isPeopleDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, peoplelink);
		return flag;
	}

	public boolean isSalesDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, saleslink);
		return flag;
	}

	public boolean isExpenseDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, expenselink);
		return flag;
	}

	public boolean isCategoriesDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, categorieslink);
		return flag;
	}

	public boolean isSettingDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, settinglink);
		return flag;
	}

	public boolean isReportDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, reportlink);
		return flag;
	}

	public boolean islanguageDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, language);
		return flag;
	}

	public boolean islogoutDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, logout);
		return flag;
	}
	/**
	 * This methods are used to navigate to corresponding pages
	 * 
	 * @return
	 */

	public void navigatedToPosMenu() {
		elementutil.clickOnElement(driver, poslink);

	}

	public void navigatedToProductMenu() {
		elementutil.clickOnElement(driver, productlink);

	}

	public void navigatedToStoreMenu() {
		elementutil.clickOnElement(driver, storelink);

	}

	public void navigatedToPeopleMenu() {
		elementutil.clickOnElement(driver, peoplelink);

	}

	public void navigatedTosalesMenu() {
		elementutil.clickOnElement(driver, saleslink);

	}

	public void navigatedToExpenseMenu() {
		elementutil.clickOnElement(driver, expenselink);

	}

	public void navigatedToCategoriesMenu() {
		elementutil.clickOnElement(driver, categorieslink);

	}

	public void navigatedToSettingMenu() {
		elementutil.clickOnElement(driver, settinglink);

	}

	public void navigatedToReportMenu() {
		elementutil.clickOnElement(driver, reportlink);

	}

	public void navigatedToLanguageMenu() {
		elementutil.clickOnElement(driver, language);

	}

	public void navigatedTologoutMenu() {
		elementutil.clickOnElement(driver, logout);

	}

	public ProductPage navigateToproductPage()  {
		navigatedToProductMenu();
		return new ProductPage(driver);

	}

	public StorePage navigateTostorePage()  {
		navigatedToStoreMenu();
		return new StorePage(driver);
	}

	public PeopleinWaiterPage navigateToPeopleinWaiterPage()  {
		navigatedToPeopleMenu();
		return new PeopleinWaiterPage(driver);

	}

	public PeopleinCustomerPage navigateToPeopleinCustomerPage()  {
		navigatedToPeopleMenu();
		return new PeopleinCustomerPage(driver);

	}

	public PeopleinSupplierPage navigateToPeopleinSupplierrPage() {
		navigatedToPeopleMenu();
		return new PeopleinSupplierPage(driver);
	}

	public ExpensePage navigateToExpensePage()  {
		navigatedToPeopleMenu();
		return new ExpensePage(driver);
	}

	public LogoutPage navigateToLogoutPage() {
		navigatedTologoutMenu();
		return new LogoutPage(driver);
	}

	public SettingPage navigateToSettingPage()  {
		navigatedToSettingMenu();
		return new SettingPage(driver);
	}

}
