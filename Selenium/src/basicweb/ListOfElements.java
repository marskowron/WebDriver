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

public class ListOfElements {


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

		List<WebElement> radio=driver.findElements(By.xpath("//input[contains(@type,'radio') and contains(@name,'cars')]"));
		System.out.println("Size of list = " + radio.size());
		boolean isChecked =false;
		
		for(int i=0; i<radio.size(); i++){
		isChecked = radio.get(i).isSelected();
		
		if(!isChecked){
			radio.get(i).click();
			Thread.sleep(1000);
		}
		}
		System.out.println("End of first loop");
		
		radio=driver.findElements(By.xpath("//input[contains(@name,'cars')]"));
		System.out.println("Size of list = " + radio.size());
		
		for(int j=0; j<radio.size(); j++){
			isChecked = radio.get(j).isSelected();
			
			if(!isChecked){
				radio.get(j).click();
				Thread.sleep(1000);
			}
		}
		System.out.println("End of second loop");
			
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}