package switchWindow;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PopUp {

	private WebDriver driver;
	String baseURL;
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		baseURL = "https://letskodeit.teachable.com/p/practice";
	}
	
	
		@Test
		public void test() throws InterruptedException {
		
		driver.get(baseURL);
		WebElement name = driver.findElement(By.id("name"));
		WebElement alertbtn = driver.findElement(By.id("alertbtn"));
		name.sendKeys("marcin");
		alertbtn.click();
		Thread.sleep(2000);
		
		//switch to popoup
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}
		@Test
		public void test2() throws InterruptedException {
			driver.get(baseURL);
			WebElement name = driver.findElement(By.id("name"));
			WebElement confirm = driver.findElement(By.id("confirmbtn"));
			name.sendKeys("marcin2");
			confirm.click();
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			//alert.accept();
			alert.dismiss();

		}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
