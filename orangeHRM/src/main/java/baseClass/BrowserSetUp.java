package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSetUp   {	
	
    public static WebDriver driver;


      public void initializeBrowser(String url) {
		
		String expath = "./drivers/chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", expath);
		
		driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
			
	}

}
