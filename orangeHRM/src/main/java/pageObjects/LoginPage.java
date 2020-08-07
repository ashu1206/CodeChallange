package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseConfig;
import utility.UtilityClass;

import org.junit.Assert; 

public class LoginPage extends UtilityClass {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement user;
	
	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement pass;
	
	@FindBy(xpath = "//input[@id='btnLogin']")
	WebElement login;
	
	@FindBy(xpath = "//*[@id=\"branding\"]/a[1]")
	WebElement pageTitle;
	
	
	
	public void loginOnPage(String name, String password) {
		
		enterText(user, BaseConfig.getproperty(name));
		enterText(pass, BaseConfig.getproperty(password));
		
		clickWebElement(login);
		

		try {
		waitMethod(10, pageTitle, this.driver);
		}catch (TimeoutException | NoSuchElementException ex) {
			loginOnPage(name, password);
		}
		
	}
	
	public void verifyPageTitle() {
		
		String expectedTitle  = "OrangeHRM";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		
	
	}

}
