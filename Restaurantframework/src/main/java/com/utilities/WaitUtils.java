package com.utilities;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WaitUtils {
	public WebDriverWait wait;
	/**
	 * this method is to implement implicit wait
	 * @param driver
	 * @param time
	 */
	
	public void implicitwait(WebDriver driver,int timeunit) {
		
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeunit));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		    System.out.println(e.getCause());		}

	}
	/**
	 * this method is to implement explicit wait for visiblity of element
	 * @param driver
	 * @param element
	 * @param timeunit
	 */
	public void visibilityOfElement(WebDriver driver,WebElement element,int timeunit) {
		
		try {
			 wait = new WebDriverWait(driver,Duration.ofSeconds(timeunit));
		wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
	    System.out.println(e.getMessage());
	    System.out.println(e.getCause());		}//throw new exception
		}
	
	/**
	 * this method is to implement explicit wait for visibility of element located
	 * @param driver
	 * @param element
	 * @param timeunit
	 */
	 
	public void visibilityOfElementlocated(WebDriver driver,WebElement element,int timeunit) {
		
			try {
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeunit));
			wait.until(ExpectedConditions.visibilityOfElementLocated( (By) element));
			} catch (Exception e) {
		    System.out.println(e.getMessage());
		    System.out.println(e.getCause());//throw new exception
			}
		

		
	}
	/**
	 * this method is to implement explicit wait for presence of element
	 * @param driver
	 * @param element
	 * @param timeunit
	 * @return 
	 */
	public WebElement presenceOfElementLocated(WebDriver driver,WebElement element,int timeunit ) {
		
		try {
		    wait = new WebDriverWait(driver,Duration.ofSeconds(timeunit));
		    
			wait.until(ExpectedConditions.presenceOfElementLocated((By) (element)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		    System.out.println(e.getCause());
			
		}
		return element;
		

		
	}
	/**
	 * this method is to implement explicit wait for element to be clickable
	 * @param driver
	 * @param element
	 * @param timeunit
	 */
	public void ElementTobeClickable(WebDriver driver,WebElement element,int timeunit ) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeunit));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		    System.out.println(e.getCause());
			
		}}
		/**
		 * This method is to provide wait for pageload timeout
		 */
		public void pageLoadTimeOut(WebDriver driver,int t ) {
        try {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(t));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		    System.out.println(e.getCause());
		}
			
		}}
		
	


