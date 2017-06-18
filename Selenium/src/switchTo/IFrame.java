package switchTo;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrame {

	private WebDriver driver;
	String baseURL;
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		baseURL = "https://letskodeit.teachable.com/p/practice";
	}
	
		@Test
		public void test() throws InterruptedException {
		
		driver.get(baseURL);
		Thread.sleep(1000);
		
		//switch to iframe
		driver.switchTo().frame("courses-iframe"); //by id
	//	driver.switchTo().frame("iframe-name"); //by name
	//	driver.switchTo().frame(0); //po numerze iframe
		
		WebElement searchBox = driver.findElement(By.id("search-courses"));
		searchBox.sendKeys("python");
		
		//switch to parent content
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.findElement(By.id("bmwradio")).click();

	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
