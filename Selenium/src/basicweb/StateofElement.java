package basicweb;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StateofElement {

	WebDriver driver;
	String baseURL;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://www.google.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void test()  {
		WebElement element = driver.findElement(By.id("lst-ib"));
		System.out.println(" element is enabled?" + element.isEnabled()); // sprawdzenie czy element jest dostepny
		
		WebElement element1 = driver.findElement(By.id("gs_taif0"));
		System.out.println(" element1 is enabled?" + element1.isEnabled());
		
		WebElement element2 = driver.findElement(By.id("gs_htif0"));
		System.out.println(" element2 is enabled?" + element2.isEnabled());
		
		element.sendKeys("letskodeit");
		element.sendKeys(Keys.RETURN); // naciœniêcie entera
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
