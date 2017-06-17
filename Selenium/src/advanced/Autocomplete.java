package advanced;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Autocomplete {

	WebDriver driver;
	String baseURL;
	

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "http://southwest.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		String partialText = "New york";
		String searchingText = "New York/Newark, NJ - EWR";
		WebElement departure = driver.findElement(By.id("air-city-departure"));
		departure.sendKeys(partialText);
		Thread.sleep(3000);
		WebElement autoCompliteList = driver.findElement(By.xpath("//div[contains(@class,'js-overlay-container')]"));
		List<WebElement> listOfOption = autoCompliteList.findElements(By.tagName("li"));
		int size = listOfOption.size();
		System.out.println(size);
		
		for (int i=0; i<size; i++){
			System.out.println("Dostêpna opcja nr "+i+ " to: " + listOfOption.get(i).getText());
		}
		Thread.sleep(3000);
		
		for (WebElement text : listOfOption){
			if(text.getText().equals(searchingText)){
				text.click();
				break;
			}
		}
		
		//div[contains(@class,'js-overlay-container')]
		//div[@id='js-menu-wrapper']
	}

}
