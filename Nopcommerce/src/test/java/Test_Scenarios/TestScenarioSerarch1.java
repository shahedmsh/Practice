package Test_Scenarios;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.FlipkartLogin;
import Objects.FlipkartSearch;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScenarioSerarch1 {
	
	FlipkartSearch fl;
	FlipkartLogin flp;
	
	static ExtentReports report;
	static ExtentTest test;
	
	WebDriver driver;
	@BeforeTest
	public void SetupDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		report = new ExtentReports("/Users/shahedhussain/eclipse-workspace/Nopcommerce/report/report.html", true);
		test = report.startTest("extend report demo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
		
	
	@BeforeClass
	public void LaunchBrowser() throws InterruptedException, IOException {
		driver.get("https://www.flipkart.com/");
		
		String tit = driver.getTitle();
		test.log(LogStatus.INFO, "Url launch Successfully");
		System.out.println(tit);
		test.log(LogStatus.PASS, tit);
		
		Thread.sleep(5000);
	}
	@Test(groups = "senity")
	public void aearch() throws InterruptedException, IOException {
		fl = new FlipkartSearch(driver);
		fl.SerchIteam("mobile");
		test.log(LogStatus.INFO, test.addScreenCapture(fl.Capture(driver)) + "Send info to the serch enginee");
		Thread.sleep(5000);
	}
	@Test(groups = "regression")
	public void check() throws IOException {
		flp = new FlipkartLogin(driver);
		flp.ClickPhone();
		test.log(LogStatus.WARNING, "Shoule display least of the mobile info");
		System.out.println("pass all test case");
		
		test.log(LogStatus.FAIL,test.addScreenCapture(fl.Capture(driver)) +"Helo world");
	}

	
	
	@AfterTest
	public void teardown() {
		driver.close();
		report.endTest(test);
		report.flush();
	}

}
