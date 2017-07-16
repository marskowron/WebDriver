package page.classes;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageObjectModel {
	
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		SearchPage.navigatesToFlightsTab(driver);
		SearchPage.fillOriginTextBox(driver, "new York");
		SearchPage.filldestinationTextBox(driver, "Chicago");
		SearchPage.departureTextBox(driver).sendKeys("25/07/2017");
		SearchPage.returnTextBox(driver).sendKeys("30/07/2017");
		SearchPage.clickOnSearchButton(driver);
	}

	@After
	public void tearDown() throws Exception {
	}



}
