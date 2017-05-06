package basicweb;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButtons {


	WebDriver driver;
	String baseURL;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void test() throws InterruptedException  {
		WebElement radioBmw = driver.findElement(By.id("bmwradio"));
		radioBmw.click();
		
		Thread.sleep(2000);
		
		WebElement radioBenz = driver.findElement(By.id("benzradio"));
		radioBenz.click();
		
		Thread.sleep(1000);
		
		WebElement checkboxBenz = driver.findElement(By.id("benzcheck"));
		checkboxBenz.click();
		
		Thread.sleep(1000);
		
		WebElement checkboxBmw = driver.findElement(By.id("bmwcheck"));
		checkboxBmw.click();
		
		Thread.sleep(1000);
		
		checkboxBenz.click();
		System.out.println("BWM radio is selectes? " + radioBmw.isSelected());
		System.out.println("Benz radio is selectes? " + radioBenz.isSelected());
		System.out.println("BWM checkbutton is selectes? " + checkboxBmw.isSelected());
		System.out.println("Benz checkbutoon is selectes? " + checkboxBenz.isSelected());
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}