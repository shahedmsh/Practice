package Objects;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FlipkartSearch {
	
	WebDriver driver;
	public FlipkartSearch(WebDriver driver) {
		this.driver=driver;
	}
	
	By FlipKartSerchBox = By.className("_3704LK");
	
	public void SerchIteam(String Searchinput) {
		WebElement iteam = driver.findElement(FlipKartSerchBox);
		iteam.sendKeys(Searchinput);
		
	}
	public static String Capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
  		File des = new File(".//screenshot//"+".png");
  		String absulot = des.getAbsolutePath();
  				
		  FileUtils.copyFile(scrFile, des);
		  return absulot;
		
	}
}
