package com.utilities;
import java.io.File;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;


public class GenericUtils {
	
		public void capturePageScreenshot(WebDriver driver,String path,String name)throws Exception {
			try {
				String filepath ="path";
				String fileNm = "name";
				File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(src, new File(filepath+fileNm+".png"));
			}catch(Exception e) {
				throw new Exception ("capturePageScreenshot :"+e.getMessage());

	}}
		/*
		 * These methods are for random data generation
		 */
		public String generateAlphaNumericData(int limit) {
			String random = RandomStringUtils.randomAlphanumeric(limit);   
			return random; 
		}
		public String generateNumericData(int limit) {
			String random = RandomStringUtils.randomNumeric(limit);   
			return random; 
		}
		public String generateAlphabeticData(int limit) {
			String random = RandomStringUtils.randomAlphabetic(limit);   
			return random;
		}
}



