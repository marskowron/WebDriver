package basicweb;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select; //pod dropdown

public class FormTest {

	WebDriver driver;
	String baseURL;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://www.expedia.ie/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void test() throws InterruptedException  {
		driver.findElement(By.id("tab-flight-tab")).click();
		
		Thread.sleep(2000);
		
		WebElement OneWayRadio = driver.findElement(By.id("flight-type-one-way-label"));
		OneWayRadio.click();
		System.out.println("Click One-way button");
		Thread.sleep(1000);
		WebElement multipleRadio = driver.findElement(By.id("flight-type-multi-dest-label"));
		multipleRadio.click();
		System.out.println("Click Multiple destinations button");
		Thread.sleep(1000);
		WebElement returnRadio = driver.findElement(By.id("flight-type-roundtrip-label"));
		returnRadio.click();
		Thread.sleep(1000);
		System.out.println("Click Return button");
		
		//System.out.println("Is Return selected? " + returnRadio.isSelected());
		//System.out.println("Is One Way selected? " + OneWayRadio.isSelected());
		
		WebElement addHotel = driver.findElement(By.id("flight-add-hotel-checkbox"));
		addHotel.click();
		Thread.sleep(1000);
		addHotel = driver.findElement(By.id("flight-add-hotel-checkbox"));
		System.out.println("Is addhotel selected? " + addHotel.isSelected());
		addHotel.click();
		Thread.sleep(2000);
		addHotel = driver.findElement(By.id("flight-add-hotel-checkbox"));
		System.out.println("Is addhotel selected? " + addHotel.isSelected());
		
		WebElement arrival = driver.findElement(By.id("flight-origin"));
		arrival.sendKeys("Krak�w");
		
		WebElement destination = driver.findElement(By.id("flight-destination"));
		destination.sendKeys("Barcelona");
		Thread.sleep(2000);
		WebElement fdeparting = driver.findElement(By.id("flight-departing"));
		fdeparting.sendKeys("24/05/2017");
		Thread.sleep(2000);
		WebElement freturning = driver.findElement(By.id("flight-returning"));
		freturning.sendKeys("28/05/2017");
		Thread.sleep(2000);
		
		WebElement direct = driver.findElement(By.id("advanced-flight-nonstop-label"));
		
		if(direct.isDisplayed() == false){
			driver.findElement(By.id("advanced-options")).click();
			Thread.sleep(2000);
		}
		
		//szukanie w dropdown po value
		WebElement preferAirline = driver.findElement(By.id("flight-advanced-preferred-airline"));
		Select selPrefAirl = new Select(preferAirline);
		selPrefAirl.selectByValue("LH");
		Thread.sleep(2000);
		//albo -> Select selPref = new Select(driver.findElement(By.id("flight-advanced-preferred-airline")));
		
		//szukanie w dropdown po nazwie 
		WebElement preferClass = driver.findElement(By.id("flight-advanced-preferred-class"));
		Select selPrefClass = new Select(preferClass);
		selPrefClass.selectByVisibleText("First Class"); // <- it works
		Thread.sleep(2000);
		//szukanie w dropdown po Id 
		WebElement NoAdults = driver.findElement(By.id("flight-adults"));
		Select selNoAdults = new Select(NoAdults);
		selNoAdults.selectByIndex(1);
		Thread.sleep(2000);
		
		//print all elements
		System.out.println("List of Option");
		List<WebElement> options = selPrefClass.getOptions();
		int size = options.size();
		
		for (int i=0; i<size; i++){
			String optionName = options.get(i).getText();
			System.out.println("Option " + i + " = " + optionName);
		}
		
		//search
		driver.findElement(By.id("search-button")).click();
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		//driver.quit();
	}

}