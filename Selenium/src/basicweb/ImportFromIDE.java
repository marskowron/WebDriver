package basicweb;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImportFromIDE {
	private WebDriver driver;
	private String baseUrl;


	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://www.google.pl/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testSelenium() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.id("lst-ib")).clear();
		driver.findElement(By.id("lst-ib")).sendKeys("letskodeit");
		driver.findElement(By.id("_fZl")).click();
		driver.findElement(By.linkText("Lets Kode it")).click();
		driver.findElement(By.id("i90scv3glabel")).click();
		driver.findElement(By.linkText("Practice")).click();
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
		
		}
	}

