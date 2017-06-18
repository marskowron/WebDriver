package actionClass;

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

public class Hover {
	private WebDriver driver;
	private JavascriptExecutor js;
	String baseURL;
	
	
	@Before
	public void setUp() throws Exception {
	driver = new FirefoxDriver();
	js = (JavascriptExecutor) driver;
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
	baseURL = "https://letskodeit.teachable.com/p/practice";
}


	@Test
	public void test() throws InterruptedException {
	
	driver.get(baseURL);
	
	//scrollujemy do hovera
	WebElement hover = driver.findElement(By.id("mousehover"));
	js.executeScript("arguments[0].scrollIntoView(true);", hover);
	
	//scrollujemy, ¿eby wyciagnac spod navbara
	WebElement navbar = driver.findElement(By.id("navbar"));
	Dimension size = navbar.getSize(); //zwraca 61
	System.out.println(size);
	js.executeScript("window.scrollBy(0,-61)");
	Thread.sleep(2000);
	
	//naje¿dzamy na hoverka
	Actions action = new Actions(driver);
	action.moveToElement(hover).perform();
	Thread.sleep(2000);
	
	//klikamy w opcje
	WebElement subList = driver.findElement(By.xpath(".//div[@id='block-1069048']//div[@class='mouse-hover-content']//a[text()='Top']"));
	//subList.click();
	action.moveToElement(subList).click().perform();
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
