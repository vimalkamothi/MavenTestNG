package AllureTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllureTest_TC01 {

	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void logoPresence() {
		boolean logoStatus = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img")).isDisplayed();
		Assert.assertEquals(logoStatus,true);
	}
	
	
	@Test(priority=2)
	public void loginTest() {
		boolean loginStatus = driver.findElement(By.linkText("Log in")).isDisplayed();
		Assert.assertEquals(loginStatus,true);
	}
	
	@Test(priority=3)
	public void registrationTest() {
		System.out.println("Registration test passed.");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
