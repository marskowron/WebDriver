package actionClass;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	private WebDriver driver;
	String baseURL;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		baseURL = "http://jqueryui.com/slider/";
	}

	@Test
	public void test() {
		driver.get(baseURL);
		// prze³¹czenie na iframe
		driver.switchTo().frame(0);
		
		
		WebElement slider = driver.findElement(By.xpath(".//div[@id='slider']/span"));
		Actions action = new Actions (driver);
		action.dragAndDropBy(slider, 200, 0).perform();
		
	}


	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
