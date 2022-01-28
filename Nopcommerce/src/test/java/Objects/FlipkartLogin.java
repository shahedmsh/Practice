package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartLogin {
	
	WebDriver driver;
	
	public FlipkartLogin(WebDriver driver) {
		this.driver=driver;
	}
	
		
	By Options = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button");
	
	public void ClickPhone() {
		WebElement l = driver.findElement(Options);
		l.click();
	}

}
