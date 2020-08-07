package utility;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BrowserSetUp;

public class UtilityClass {
	
	
	public static final Logger logger = Logger.getLogger(BrowserSetUp.class);
	
	
	public void enterText(WebElement element, String text) {
		
		element.clear();
		
		element.sendKeys(text);
		
	}
	
	public void clickWebElement(WebElement webElement) {
		
		if(webElement.isDisplayed()) {
			
			webElement.click();
		}else {
			logger.info("Element is not Displayed");
		}
		
		
	}
	
	public void waitMethod(long timeInSeconds, WebElement webElement, WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		
		wait.until(ExpectedConditions.visibilityOf(webElement));
		
		
	}
	
	public  void implicitWait(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}
}
	
