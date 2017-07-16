package page.classes;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageFactoryTestCase {

	WebDriver driver;
	String baseURL;	
	SearchPageFactory searchPage;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://www.expedia.com/";
		
		searchPage = new SearchPageFactory(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() {
		searchPage.clickFlightsTab();
		searchPage.setOriginCity("New York");
		searchPage.setDestinationCity("Chicago");
		searchPage.setDepDate("23/07/2017");
		searchPage.setRetDate("24/07/2017");
	}

	@After
	public void tearDown() throws Exception {
	}



}
