package com.orangehrm.utils;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends BaseClass {
	
	// ctrl O -- to search far a method();	
	
	/**
	 * This method will send keys
	 * @param WebElement element, String value
	 */
   public static void sendText(WebElement element, String value) {
       element.clear();
       element.sendKeys(value);
   }
   public static void click(WebElement element) {
	   element.click();
   }
	/**
	 * This method will select a specified value from a drop down
	 * @author Syntax 
	 * @param Select element, String text
	 */
	  public static void selectValueFromDD(WebElement element, String text) {
		  Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			boolean isSelected = false;
			for (WebElement option : options) {
				String optionText = option.getText();
				if (optionText.equals(text)) {
					select.selectByVisibleText(text);
					System.out.println("Option with text " + text + " is selected");
					isSelected = true;
					break;
				}
			}
			if (!isSelected) {
				System.out.println("Option with text +" + text + "is not available");
			}
		}
	  
	  /**
		 * This method will select a specified value from a drop down by its index
		 * @author Syntax 
		 * @param Select element, int index
		 */
	    public static void selectValueFromDD(WebElement element, int index) {
	        Select select = new Select(element);
	        List<WebElement> options = select.getOptions();
	        if (options.size() > index) {
	            select.selectByIndex(index);
	        }else {
	            System.out.println("Invalid index has been passed");
	        }
	    }
	    /**
		 * This method will select a checkBox 
		 * @param List<WebElement> list, String text
		 */
	    public static void selectCheckBox(List<WebElement> list, String text) {
			boolean isSelected = false;
			for(WebElement e:list) {
				// check box can be checked and unchecked
				if(e.isEnabled()) {
					if(e.getText().startsWith(text)) {
						System.out.println(text + " is selected");
						isSelected = true;
						e.click();
						break;
					}
						if(e.getAttribute("value").equals(text)) {
							if(e.isSelected()) {
								System.out.println("CheckBox is aleady selected");
							}else {
								isSelected = true;
								e.click();
								System.out.println(text + " is selected");
								break;
							}
						}
				}else {
					System.out.println("CheckBox is NOT enabled");
				}
			}}
	    
	    /**
	     * Method will accept alert
	     * @throws NoAlertPresentException if alert is not present
	     */
	    public static void acceptAlert() {
	    	try {
	    	 Alert alert = driver.switchTo().alert();
	    	 alert.accept();
	        } catch (NoAlertPresentException e) {
	    		System.out.println("Alert was not present");
	    	  }
	    	}
	    	
	    /**
	     * Method will dismiss alert
	    * @throws NoAlertPresentException if alert is not present
	    */
	    	public static void dismissAlert() {
	    		try {
	    		  Alert alert=driver.switchTo().alert();
	    		  alert.dismiss();
	    		}catch (NoAlertPresentException e) {
	    			System.out.println("Alert was not present");
	    	   }
	    	}
	    	
	    /**
	    * Method will get text of an alert
	    * @throws NoAlertPresentException if alert is not present
	    * @return String text
	    */
	    	 public static String getAlertText() {
	    		try {
	    		    Alert alert=driver.switchTo().alert();
	    			return alert.getText();
	    		}catch (NoAlertPresentException e) {
	    			System.out.println("Alert was not present");
	    			return null;
	    		}
	    	}
	    	
	    	/**
	        * Method that will switch control to the specified frame
	    	* @param frame id or frame name
	    	*/
	    		public static void switchToFrame(String idOrName) {
	    			try {
	    				driver.switchTo().frame(idOrName);
	    			}catch(NoSuchFrameException e) {
	    				System.out.println("Frame is not present");
	    			}
	    		}
	    		
	    	/**
	    	* Method that will switch control to the specified frame
	    	* @param frame element
	    	*/
	    		public static void switchToFrame(WebElement element) {
	    			try {
	    				driver.switchTo().frame(element);
	    			}catch(NoSuchFrameException e) {
	    				System.out.println("Frame is not present");
	    			}
	    		}
	    	
	    	/**
	    	* Method that will switch control to the specified frame
	    	* @param frame index
	    	*/
	    		public static void switchToFrame(int index) {
	    			try {
	    				driver.switchTo().frame(index);
	    			}catch(NoSuchFrameException e) {
	    				System.out.println("Frame is not present");
	    			}
	    		}
	    		
	    		/**
	    		 * Method that will wait for element to be visible
	    		 * 
	    		 * @param WebElement element, int time
	    		 */
	    		public static void waitForElementBeVisible(WebElement element, int time) {
	    			WebDriverWait wait = new WebDriverWait(driver, time);
	    			wait.until(ExpectedConditions.visibilityOf(element));
	    		}

	    		public static void waitForElementBeVisible(By locator, int time) {
	    			WebDriverWait wait = new WebDriverWait(driver, time);
	    			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    		}

	    		public static void waitForElementBeClickable(WebElement element, int time) {
	    			WebDriverWait wait = new WebDriverWait(driver, time);
	    			wait.until(ExpectedConditions.elementToBeClickable(element));
	    		}

	    		public static void waitForElementBeClickable(By locator, int time) {
	    			WebDriverWait wait = new WebDriverWait(driver, time);
	    			wait.until(ExpectedConditions.elementToBeClickable(locator));
	    		}
	    		/**
	    		 * This method will upload specified file
	    		 * @param WebElement element, String filePath
	    		 */
	    		public static void uploadFile(WebElement element, String filePath) {
	    			//String filePath = folderName+"/"+fileName;
	    			sendText(element, filePath);
	    		}
	    	
	    		/**
	    		 * Method  will take a screenshot
	    		 */
	    		public static byte[] takeScreenshot() {
	    			
	    			TakesScreenshot ts=(TakesScreenshot)driver;
	    	     byte[] screen=ts.getScreenshotAs(OutputType.BYTES);
	    	
	    	        return screen;
	    		}

	    		public static void scrollDown(int pixels) {
	    			JavascriptExecutor js=(JavascriptExecutor)driver;
	    			js.executeScript("window.scrollBy(0,"+pixels+")");
	    		}

	    		public static void scrollUp(int pixels) {
	    			JavascriptExecutor js=(JavascriptExecutor)driver;
	    			js.executeScript("window.scrollBy(0,-"+pixels+")");
	    		}
	    		
	    		public static void jsClick(WebElement element) {
	    			JavascriptExecutor js=(JavascriptExecutor)driver;
	    			js.executeScript("arguments[0].click();", element); 
	    		}

	    		/**
	    		 * Method  will handle ul dropDown
	    		 * 
	    		 * @param WebElement element, String text
	    		 */
	    		//1 identify the list
	    		//2 get all children with <li> tags
	    		// loop through each tag and get text
	    		// if text is matching then we click
	    		//break it
	    		public static void selectList(WebElement element, String text) {
	    			List <WebElement>listLocations=element.findElements(By.tagName("li"));
	    			for (WebElement li: listLocations) {
	    				String liText= li.getAttribute("innerHTML");
	    				if(liText.contains(text)) {
	    					li.click();
	    					break;
	    				}
	    			}
	    		}
	    		
	    		
	    		
	    		
}
