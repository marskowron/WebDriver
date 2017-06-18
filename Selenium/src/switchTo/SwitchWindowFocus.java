package switchTo;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchWindowFocus {


	private WebDriver driver;
	private JavascriptExecutor js;
	String baseURL;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		baseURL = "http://letskodeit.teachable.com/p/practice";
		//driver.get(baseURL);

	}

	@Test
	public void test() throws InterruptedException {
		js.executeScript("window.location = 'http://letskodeit.teachable.com/p/practice'");
		
		//get the handle (id strony)
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent window handle: " + parentHandle);
		
		// Open New Window button
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement openWindow =	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("openwindow")));
		openWindow.click();
		
		// Get all handles
		Set<String> handles = driver.getWindowHandles();
		
		//switch window
		for (String handle : handles){
			System.out.println(handle);
			if(!handle.equals(parentHandle)){
				driver.switchTo().window(handle);
				break;
			};
		}
	
		//find search box
		driver.findElement(By.id("search-courses")).sendKeys("test");
		Thread.sleep(1500);
		
		//close New Window
		driver.close();
		
		//switch to parent window
		driver.switchTo().window(parentHandle);
		driver.findElement(By.id("bmwradio")).click();

	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
