package stepDefinition;

import baseClass.BrowserSetUp;
import io.cucumber.java.After;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.AddNewEmpPage;
import pageObjects.EmpSearchPage;

import pageObjects.LoginPage;
import utility.BaseConfig;
import utility.ScreenshotUtility;

public class Steps extends BrowserSetUp {
	
	LoginPage loginPage;
	AddNewEmpPage empManage;
	EmpSearchPage empSearch;
	Scenario scn;
		
	
	@Given("that user launch the {string} and is on login page")
	public void that_user_launch_the_and_is_on_login_page(String url) {
		
		initializeBrowser(BaseConfig.getproperty(url));
	}
	
	@Then("user login with valid {string} & {string}")
	public void user_login_with_valid(String username, String password) {
		
		loginPage = new LoginPage(driver);
		loginPage.loginOnPage(username, password);
		
	}

	@Then("the page redirected to the dashboard")
	public void the_page_redirected_to_the_dashboard() {
		
		loginPage = new LoginPage(driver);
		loginPage.verifyPageTitle();
		
		
	}
	
	@Then("user clicks on PIM tab")
	public void user_clicks_on_PIM_tab() {
		
		empManage = new AddNewEmpPage(driver);
		empManage.clickOnPIM();
	}

	@Then("click on button labelled as Add")
	public void click_on_button_labelled_as_Add() {
		
		empManage = new AddNewEmpPage(driver);
		empManage.clickOnAdd();
		
	}

	@Then("user enters his {string}")
	public void user_enters_his(String firstName) {
		
		empManage = new AddNewEmpPage(driver);
		empManage.enterFirstName(firstName);
		
	}

	@Then("enters his {string}")
	public void enters_his(String lastName) {
		
		empManage = new AddNewEmpPage(driver);
		empManage.enterlastName(lastName);
		
	}

	@Then("upload a picture")
	public void upload_a_picture() {
		
		empManage = new AddNewEmpPage(driver);
		empManage.addAPic();
		
	}

	@Then("click on button labelled as Save")
	public void click_on_button_labelled_as_Save() {
		
		empManage = new AddNewEmpPage(driver);
		empManage.clickOnSave();
		
	}

	@Then("verify that user is redirected to the dashboard")
	public void verify_that_user_is_redirected_to_the_dashboard() {
		
		empManage = new AddNewEmpPage(driver);
		empManage.verifyTitlePage();
		
	}
	
	
	
	@Then("enter the {string} added in the above test step")
	public void enter_the_added_in_the_above_test_step(String name) {
		
		empSearch = new EmpSearchPage(driver);
		empSearch.enterEmployeeName(name);
		
	}

	@Then("click on the Search button")
	public void click_on_the_Search_button() {
		
		empSearch = new EmpSearchPage(driver);
		empSearch.searchEmployee();
		
	}

	@Then("verify that the {string} addded is present")
	public void verify_that_the_addded_is_present(String name) {
		
		empSearch = new EmpSearchPage(driver);
		empSearch.verifyTheName(name);
	}
	
	@After	
	public void afterrun(Scenario s) {
	String Failed = "FailedScreenShots";
	if(s.isFailed() == true) {
		
		ScreenshotUtility.takeScreenshot(driver, Failed+".png");
	}
	driver.quit();
	}
	

}
