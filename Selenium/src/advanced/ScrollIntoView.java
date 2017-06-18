package advanced;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollIntoView {

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
		Thread.sleep(1500);
		
		//ScrollDown
		js.executeScript("window.scrollBy(0,600);");
		Thread.sleep(1500);
		//ScrollUp
		js.executeScript("window.scrollBy(0,-600);");
		Thread.sleep(1500);
		//ScrollToElement
		WebElement hover = driver.findElement(By.id("mousehover"));
		js.executeScript("arguments[0].scrollIntoView(true);", hover);
		
		WebElement navbar = driver.findElement(By.id("navbar"));
		Dimension size = navbar.getSize(); //zwraca 61
		System.out.println(size);
		js.executeScript("window.scrollBy(0,-61)");
		
		//drugi sposób przy u¿yciu biblioteki Action, ale nie scrolluje :(
		driver.navigate().refresh();
		System.out.println("refresh");
		Thread.sleep(1500);
		hover = driver.findElement(By.id("mousehover"));
		Actions action = new Actions(driver);
		System.out.println(hover.getText());
		action.moveToElement(hover);
		action.perform();
		
				
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
