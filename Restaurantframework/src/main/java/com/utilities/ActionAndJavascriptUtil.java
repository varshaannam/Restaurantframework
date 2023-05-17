package com.utilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;


public class ActionAndJavascriptUtil {
	WebDriver driver;
	Actions action;
	JavascriptExecutor js;
	/**perform click action on the webelement
	 * click 
	 * @param driver
	 * @param element
	 */
	public void clickOntheElementbyAction(WebDriver driver,WebElement element) {
		
			try {
				action.click(element).build().perform();
			} catch (Exception e) {
				System.out.println(e.getMessage());			}
	
	}
	/**
	 * perform double click action on the element
	 * @param driver
	 * @param element
	 */
	public void doublleClickOntheElement(WebDriver driver,WebElement element) {
		try {
			action.moveToElement(element).doubleClick().build().perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());		}
		
	}
	/**
	 * perform mousehover action on the webelement
	 * @param driver
	 * @param element
	 */
	public void mousehoverOntheElement(WebDriver driver,WebElement element) {
		try {
			action.moveToElement(element).build().perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());		}
	}
	/**
	 * perform Rightclick action on the webelement
	 * @param driver
	 * @param element
	 */
	public void rightClickOntheElement(WebDriver driver,WebElement element) {
		try {
			action.contextClick(element).build().perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());		}
	}
	/**
	 * perform click and hold action on the element
	 * @param driver
	 * @param element
	 */
	public void clickAndHoldtheElement(WebDriver driver,WebElement element) {
		try {
			action.clickAndHold(element).build().perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());		}
	}
	/**
	 * perform movebyoffset action on the element
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void moveByOffsetActionOnTheElement(WebDriver driver,int x,int y) {
		try {
			action.moveByOffset(x, y).click().build().perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());		}
		
	}
	/**
	 * perform drag and drop action on the webelement
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDropOnTheElement(WebDriver driver,WebElement source,WebElement target ) {
		try {
			action.dragAndDrop(source, target).build().perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());		}
	}



	
/**
 * Method to scroll up the page
 * @param driver
 */
	public void scrollUpThePage(WebDriver driver) {
		try {
			js.executeScript("window.scrollBy(0,600)");
		} catch (Exception e) {
			System.out.println(e.getMessage());		}

}
	/**
	 * Method to Scroll down the page
	 * @param driver
	 */
	public void scrollDownThePage(WebDriver driver) {
		js =(JavascriptExecutor) driver;

		try {
			js.executeScript("window.scrollBy(0,-600)");
		} catch (Exception e) {
			System.out.println(e.getMessage());		}
	}
	/**
	 * perform click action using javascriptexcutor
	 * @param driver
	 * @param element
	 */
	public void clickTheElement(WebDriver driver,WebElement element) {
		js =(JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].click();",element);
		} catch (Exception e) {
			System.out.println(e.getMessage());		}
	}
	/**
	 * Method to scrolltoelement on the page
	 * @param driver
	 * @param element
	 */
	public void scrolltoElement(WebDriver driver,WebElement element) {
		js =(JavascriptExecutor) driver;

	    try {
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			System.out.println(e.getMessage());		}
	}	
}


