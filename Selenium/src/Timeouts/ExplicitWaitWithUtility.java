package Timeouts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import TestFramework.GenericMethods;

public class ExplicitWaitWithUtility {


	WebDriver driver;
	String baseURL;
	private GenericMethods gm;
	private WaitTypes wt;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		driver.manage().window().maximize();
		wt = new WaitTypes(driver);
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);  tu nie stosujemy generalnego timeoutu
		
	}

	@Test
	public void test() throws InterruptedException  {
		driver.get(baseURL);
		gm = new GenericMethods (driver);
		gm.getElement("Login", "link").click();
		 // definiujemy ile sekund maksymalnie czekamy
		WebElement emailField = wt.waitForElement(By.id("user_email"), 3);
				
		emailField.sendKeys("test");
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}