package com.utilities;
import java.io.File;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;


public class WebPageutils {
	private List<WebElement> list;


	public void elementSelectByValue(WebDriver driver, WebElement element,String value) {
		try {
			Select sel =new Select(element);
			sel.selectByValue(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}}
		public void elementSelectByIndex(WebDriver driver, WebElement element,int value) {
			try {
				Select sel =new Select(element);
				sel.selectByIndex(value);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}}
		public void elementSelectByVisibleText(WebDriver driver, WebElement element,String value) {
			try {
				Select sel =new Select(element);
				sel.selectByVisibleText(value);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}}
		
		
		
		public List<WebElement> multiElementGetOption(WebDriver driver, WebElement element) {
			List<WebElement>list = null;
			try {
				Select sel =new Select(element);
				 list = sel.getOptions();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return list;
			}
		public void multiSelectGetAllSelectedOption(WebDriver driver, Select sel) {
			try {
				sel.getAllSelectedOptions();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}}
		public String multiElementGetFirstSelectedOption(WebDriver driver, WebElement element) {
			String firstoption = null ;
			try {
				Select sel =new Select(element);
				 firstoption = sel.getFirstSelectedOption().getText();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return firstoption;
			}
		public void multiSelectdeSelectByValue(WebDriver driver, Select sel,String value) {
			try {
				sel.deselectByValue(value);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}}
		public void multiSelectdeSelectByIndex(WebDriver driver, Select sel,int index) {
			try {
				sel.deselectByIndex(index);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}}
		public void multiSelectdeSelectByVisibleText(WebDriver driver, Select sel,String text) {
			try {
				sel.deselectByVisibleText(text);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}}
		public void multiSelectdeSelectAll(WebDriver driver, Select sel) {
			try {
				sel.deselectAll();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}}
		
		
			public void capturePageScreenshot(WebDriver driver,String path,String name)throws Exception {
				try {
					String filepath ="path";
					String fileNm = "name";
					File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src, new File(filepath+fileNm+".png"));
				}catch(Exception e) {
					throw new Exception ("capturePageScreenshot :"+e.getMessage());
				}}}



	

