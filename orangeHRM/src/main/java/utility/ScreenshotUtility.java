package utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	
public static void takeScreenshot(WebDriver driver,String screenshot) {
		
		
		TakesScreenshot scrnShot = (TakesScreenshot)driver;
		File data = scrnShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(data, new File("./Screenshots/"+screenshot+ScreenshotUtility.dateTime()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
}
	
	public static String dateTime() {
		Date date = new Date();
		String newDate = date.toString().replace(":", "-");
		return newDate;
		
	}

}
