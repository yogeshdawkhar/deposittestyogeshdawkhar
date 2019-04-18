package com.deposit.yogeshdawkhar.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.deposit.yogeshdawkhar.helper.HelperClass;

/**
 * Class for setting up the excel file for data driven approach
 */
public class UtililtyFunctions extends HelperClass {

	/**
	 * Constructor to initialize Utils class
	 * 
	 * @param WebDriver driver
	 */
	public UtililtyFunctions(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * Instance method to scroll into the web page
	 * 
	 * @param WebElement
	 */
	public void scrollTillElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	/**
	 * This method will check if an element exists on the page
	 * 
	 * @param WebElement
	 * @return boolean
	 */
	public static boolean isElementExists(WebElement ele) {
		try {
			ele.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static boolean isCurrentUrlSame(String url) {
		try {
			if(driver.getCurrentUrl().equalsIgnoreCase(url));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static boolean isCurrentUrlDiffrent(String url) {
			return (!driver.getCurrentUrl().equalsIgnoreCase(url));
	}
	

	/**
	 * This method will get the placeholder attribute value of an element
	 * 
	 * @param WebElement
	 * @return String
	 */
	public static String getPlaceholderAttributeValue(WebElement ele) {
		System.out.println(ele.getAttribute("placeholder"));
		return ele.getAttribute("placeholder");
	}

	/**
	 * This method will refresh the page
	 */
	public static void refreshPage() {
		driver.navigate().refresh();
	}

	/**
	 * Get the name of currently executed function
	 * 
	 * @return String
	 */
	public static String getCurrentMethodName() {
		return Thread.currentThread().getStackTrace()[2].getClassName() + " -> "
				+ Thread.currentThread().getStackTrace()[2].getMethodName();
	}

	
}
