package Timeouts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import TestFramework.GenericMethods;

public class ImplicitWait {


	WebDriver driver;
	String baseURL;
	private GenericMethods gm;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	}

	@Test
	public void test() throws InterruptedException  {
		driver.get(baseURL);
		gm = new GenericMethods (driver);
		gm.getElement("Login", "link").click();
		gm.getElement("user_email", "id").sendKeys("test");
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}