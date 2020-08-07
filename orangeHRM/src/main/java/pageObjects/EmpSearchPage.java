package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.UtilityClass;

import org.junit.Assert;

public class EmpSearchPage extends UtilityClass {
	
	public WebDriver driver;
	
	public EmpSearchPage(WebDriver driver) {
		
        this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id=\"empsearch_employee_name_empName\"]")
	WebElement enterName;
	
	@FindBy(xpath = "//input[@id=\"resetBtn\"]")
	WebElement search;
	
	
	public void enterEmployeeName(String name) {
		
		enterText(enterName, name);
		
	}
	
	public void searchEmployee() {
		
		clickWebElement(search);
	
	}
	
	public void verifyTheName(String name) {
		
		List<WebElement> totalEmployees = driver.findElements(By.xpath("//*[@id=\"tableWrapper\"]//tbody/tr"));
		WebElement noRecordFound = driver.findElement(By.xpath("//*[@id='tableWrapper']//tbody/tr/td"));
		System.out.println("Toatl Employees count are : "+totalEmployees.size());
		String actualname = null;
		if(noRecordFound.getText()=="No Records Found") {
			Assert.assertTrue("Name is not present", false);	
		}else {
		for(WebElement ele : totalEmployees) {
			
			WebElement employeeName = ele.findElement(By.xpath("./td[3]/a"));
			
		
			if(name.equalsIgnoreCase(employeeName.getText())) {
				
				actualname = employeeName.getText();
				System.out.println(actualname);
				
				break;
			}
		}
		
		Assert.assertEquals("Name is not present", name, actualname);
		}
	}
}
		

