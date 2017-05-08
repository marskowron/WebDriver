package FindingElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import TestFramework.GenericMethods;

public class FindElementsUsingGenericMethods {


	private WebDriver driver;
	private String baseURL;
	private GenericMethods gm;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		gm = new GenericMethods(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void test() throws InterruptedException  {
		String locator = "name";
		String type = "id";
		WebElement element = gm.getElement(locator, type);
		element.sendKeys("test");
		
		List<WebElement> list = gm.getElementList("//input[@type='text']", "xpath");
		int size = list.size();
		System.out.println("Size of the list: " + size);
		
		boolean result;
		result = gm.isElementPresent(locator, type);
		System.out.println("Is element "+ locator + " present?: " + result);
		
		result = gm.isElementPresent("sth-not-present", type);
		System.out.println("Is element 'sth-not-present' present?: " + result);
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}