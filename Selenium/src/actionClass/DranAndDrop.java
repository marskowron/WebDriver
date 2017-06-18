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

public class DranAndDrop {

	private WebDriver driver;
	String baseURL;
	
	
	@Before
	public void setUp() throws Exception {
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
	baseURL = "http://jqueryui.com/droppable/";
}


	@Test
	public void test() throws InterruptedException {
	
	driver.get(baseURL);
	Thread.sleep(2000);
	
	//switch do iframe
	driver.switchTo().frame(0);
	
	//pobieranie elementów
	WebElement from = driver.findElement(By.id("draggable"));
	WebElement to = driver.findElement(By.id("droppable"));
	
	//D&D
	Actions action = new Actions(driver);
	//action.dragAndDrop(from, to).build().perform();
	
	//druga opcja click and hold/  move/release
	action.clickAndHold(from).moveToElement(to).release().build().perform();
	
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}


