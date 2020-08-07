package pageObjects;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.UtilityClass;

public class AddNewEmpPage extends UtilityClass {
	
    public WebDriver driver;
    
    public static final Logger logger = Logger.getLogger(AddNewEmpPage.class);
	
	public AddNewEmpPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@id=\"menu_pim_viewPimModule\"]")
	WebElement pim;
	
	@FindBy(xpath = "//input[@id=\"btnAdd\"]")
	WebElement add;
	
	@FindBy(xpath = "//input[@id=\"firstName\"]")
	WebElement firstN;
	
	@FindBy(xpath = "//input[@id=\"lastName\"]")
	WebElement lastN;
	
	@FindBy(xpath = "//*[@id=\"photofile\"]")
	WebElement picture;
	
	@FindBy(xpath = "//input[@id=\"btnSave\"]")
	WebElement save;
	
	
	public void clickOnPIM() {
		
		clickWebElement(pim);

	}
	
	public void clickOnAdd() {
		
		clickWebElement(add);
		
	}
	
	public void enterFirstName(String firstName) {
		
		enterText(firstN, firstName);
		
	}
	

	public void enterlastName(String lastName) {
		
		
		enterText(lastN, lastName);

	}
	
	public void addAPic() {
		
			
	    picture.sendKeys("C:\\Users\\manish\\Desktop\\PFA Code Challenge\\orangeHRM\\pic\\sunflower.jpg");
	}
	
	public void clickOnSave() {
		
		clickWebElement(save);
	
	}
	
	public void verifyTitlePage() {
		
		String expectedTitle  = "OrangeHRM";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		
		logger.info("Redirected to DashBoard");
	}

}
