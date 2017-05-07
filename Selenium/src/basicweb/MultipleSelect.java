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
import org.openqa.selenium.support.ui.Select;

public class MultipleSelect {


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
		WebElement multiplelist = driver.findElement(By.id("multiple-select-example"));
		Select options = new Select(multiplelist);
		options.selectByIndex(1);  // wyszukanie po indeksie
		Thread.sleep(1500);
		options.selectByVisibleText("Apple"); // wyszukanie po widocznym tekscie
		Thread.sleep(1500);
		options.selectByValue("peach"); //wyszukanie po nazwie obiektu
		Thread.sleep(1500);
		
		List<WebElement> selectedOptions = options.getAllSelectedOptions();
		int NoOfSelectedOptions = selectedOptions.size();
		
		for (int j=0; j<NoOfSelectedOptions; j++ ){
			String SelectedOptionName = selectedOptions.get(j).getText();
			System.out.println("Selected value: " + SelectedOptionName);
		}
		
		options.deselectByIndex(1); //odznaczenie po id
		Thread.sleep(1500);
		options.deselectByValue("peach"); //odznaczenie po value
		Thread.sleep(1500);
		options.deselectByVisibleText("Apple"); //odznaczenie po widocznym tekœcie
		Thread.sleep(1500);
		
		List<WebElement> ListOfOptions = options.getOptions(); 
		int listSize = ListOfOptions.size();
		for (int i=0; i<listSize; i++){
			options.selectByIndex(i);
			Thread.sleep(1000);
		}
		
		options.deselectAll(); //odznaczenie wszystkiego
		
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(1500);
		//driver.quit();
	}

}