package Timeouts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestFramework.GenericMethods;
import  Timeouts.WaitTypes;
public class ExplicitWait {


	WebDriver driver;
	String baseURL;
	private GenericMethods gm;
	private WaitTypes wt;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);  tu nie stosujemy generalnego timeoutu
		wt = new WaitTypes(driver);
		gm = new GenericMethods (driver);
	}

	@Test
	public void test() throws InterruptedException  {
		driver.get(baseURL);
		gm.getElement("Login", "link").click();
		WebDriverWait wait = new WebDriverWait(driver, 3); // definiujemy ile sekund maksymalnie czekamy
		WebElement emailField = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("user_email"))); //definiujemy warunek
		emailField.sendKeys("test");
		emailField.clear();
		driver.navigate().refresh(); //F5
		//drugi sposób z wykorzystanie metody generycznej
		wt.waitForElement(By.id("user_email"), 6).sendKeys("test2");

	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}