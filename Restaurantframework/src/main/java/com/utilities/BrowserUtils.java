package com.utilities;

import org.openqa.selenium.WebDriver;

public class BrowserUtils {
	/**
	 * This method is to launch the given url
	 * 
	 * @param driver
	 * @param url
	 */
	public void launchtheURL(WebDriver driver, String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	/**
	 * This method is used to get the title of the given url
	 * 
	 * @param driver
	 * @return
	 */

	public String getTitleofWebpage(WebDriver driver) {
		String title = null;
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return title;
	}

	/**
	 * This method is used to get current url of webpage
	 * 
	 * @param driver
	 */
	public void getCurrentUrlofWebpage(WebDriver driver) {
		String currenturl = null;
		try {
			currenturl = driver.getCurrentUrl();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return;
	}

	/**
	 * This method is used to get pagesource of webpage
	 * 
	 * @param driver
	 * @return 
	 */
	public String getPageSourceofWebpage(WebDriver driver) {
		String pagesourse = null;
		try {
			pagesourse = driver.getPageSource();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return pagesourse;
	}

	/**
	 * This method is used to navigate to webpage
	 * 
	 * @param driver
	 */

	public void navigatetoWebpage(WebDriver driver,String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	/**
	 * This method is used to navigate forward to webpage
	 * 
	 * @param driver
	 */
	public void navigateForwardtoWebpage(WebDriver driver) {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	/**
	 * This method is used to navigate back to previous page
	 * 
	 * @param driver
	 */

	public void navigateBacktoPreviouspage(WebDriver driver) {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	/**
	 * This method is used to navigate refresh page
	 * 
	 * @param driver
	 */
	public void navigateRefreshPage(WebDriver driver) {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	/**
	 * This method is used to maximize window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method is used to minimize window
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		try {
			driver.manage().window().minimize();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	/**
	 * This method is used to get fullfullscreen window
	 * 
	 * @param driver
	 */

	public void fullSCreenWindow(WebDriver driver) {
		try {
			driver.manage().window().fullscreen();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	/**
	 * This method is used to close window
	 * 
	 * @param driver
	 */
	public void closeWindow(WebDriver driver) {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	/**
	 * This method is used to quit window
	 * 
	 * @param driver
	 */
	public void quitWindow(WebDriver driver) {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

}



