package basicweb;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicActions {
	
WebDriver driver;
String baseURL;
private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		driver.get(baseURL);
		driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/sign_in']")).click();
		System.out.println("click on login button");
		driver.findElement(By.id("user_email")).clear();
		driver.findElement(By.id("user_email")).sendKeys("test@mail.com");
		System.out.println("put login");
		driver.findElement(By.id("user_password")).clear();
		driver.findElement(By.id("user_password")).sendKeys("abc");
		System.out.println("put password");
		driver.findElement(By.xpath("//form[@id='new_user']//input[@name='commit']")).click();
		System.out.println("click Login");
		try {
		      assertTrue(isElementPresent(By.cssSelector("div.alert.alert-danger")));
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }
	}
	
	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	  private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }
}
