package com.utilities;



import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementUtils {
	/**This method is to enter Value to the element
	 * 
	 * @param driver
	 * @param element
	 * @param value
	 */

	public void enterValueToTheElement(WebDriver driver, WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	/**This method is to clear the element
	 * 
	 * @param driver
	 * @param element
	 */

	public void clearTheElement(WebDriver driver, WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	/**This method is to click on element
	 * 
	 * @param driver
	 * @param element
	 */

	public void clickOnElement(WebDriver driver, WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	/**This method is to submit on element
	 * 
	 * @param driver
	 * @param element
	 */

	public void submitOnElement(WebDriver driver, WebElement element) {
		try {
			element.submit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	/**This method is to check whether the element is displayed or not
	 * 
	 * @param driver
	 * @param element
	 * @return
	 */

	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		boolean flag=false;
		try {
			flag=element.isDisplayed();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;

	}
	/**This method is to check whether the element is selecttd or not
	 * 
	 * @param driver
	 * @param element
	 * @return
	 */

	public boolean isElementSelected(WebDriver driver, WebElement element) {
		boolean flag=false;
		try {
		   flag=element.isSelected();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;

	}
	/**This method is to check whether element is enabled or not
	 * 
	 * @param driver
	 * @param element
	 * @return
	 */

	public boolean ElementIsEnabled(WebDriver driver, WebElement element) {
		boolean flag=false;
		try {
			flag=element.isEnabled();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;

	}
	/**This method is to get text of element
	 * 
	 * @param driver
	 * @param element
	 * @return
	 */

	public String getTextOfElement(WebDriver driver, WebElement element) {
		String text = null;
		try {
			 text=element.getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return text;

	}
/**This method is to get tag name of element
 * 
 * @param driver
 * @param element
 * @return
 */
	public String getTagNameOfElement(WebDriver driver, WebElement element) {
		String text = null;
		try {
			text=element.getTagName();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return text;

	}
	/**This method is to get attribute of the element
	 * 
	 * @param driver
	 * @param element
	 * @param name
	 * @return
	 */
	 

	public String getAttributeofTheElement(WebDriver driver, WebElement element, String attribute) {
		String text = null;
		try {
			text=element.getAttribute(attribute);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return text;

	}
/**This method is to get css value of the element
 * 
 * @param driver
 * @param element
 * @param propertyName
 * @return
 */
	public String getCssValueOfTheElement(WebDriver driver, WebElement element, String cssvalue) {
		String text = null;
		try {
			text=element.getCssValue(cssvalue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return text;

	}
	/**This method is to get size of the element
	 * 
	 * @param driver
	 * @param element
	 * @return 
	 * @return
	 */

	public Dimension getSizeOfElement(WebDriver driver, WebElement element) {
		Dimension size=null;
		try {
			size=element.getSize();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return size;
			
		
		}
	
public Point getLocationOfElement(WebDriver driver, WebElement element) {
		Point flag = null;
		try {
		flag=	element.getLocation();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
return flag;
	}
	

}



