package basicweb;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HideElements {


	WebDriver driver;
	String baseURL;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void test() throws InterruptedException  {
	WebElement textBox = driver.findElement(By.id("displayed-text"));
	WebElement hideButton = driver.findElement(By.id("hide-textbox"));
	
	System.out.println("Text Box Displayed: " + textBox.isDisplayed());
	Thread.sleep(2000);
	
	hideButton.click();
	System.out.println("Hide button clicked");
	System.out.println("Text Box Displayed: " + textBox.isDisplayed());
	Thread.sleep(2000);
	
	WebElement showButton = driver.findElement(By.id("show-textbox"));
	showButton.click();
	System.out.println("Show button clicked");
	System.out.println("Text Box Displayed: " + textBox.isDisplayed());
	Thread.sleep(2000);
	
	}
	
	@Test
	public void test2() throws InterruptedException  {
	baseURL = "https://www.expedia.ie/";
	driver.get(baseURL);
	WebElement childDropdown = driver.findElement(By.id("package-1-age-select-1"));
	System.out.println("Text Box Displayed: " + childDropdown.isDisplayed());
	Thread.sleep(2000);
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}