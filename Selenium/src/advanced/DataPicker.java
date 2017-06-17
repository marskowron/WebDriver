package advanced;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DataPicker {

	WebDriver driver;
	String baseURL;
	

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "http://expedia.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		driver.get(baseURL);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-flight-tab-hp"))).click();
		driver.findElement(By.id("flight-departing-hp-flight")).click();
		WebElement calMonth = driver.findElement(By.xpath("//*[@id='flight-departing-wrapper-hp-flight']//div[2]/table[@class='datepicker-cal-weeks']"));
		List<WebElement> availableDays = calMonth.findElements(By.tagName("button"));
		System.out.println(availableDays.size());
		for (WebElement date : availableDays){
			if (date.getText().equals("30")){
			date.click();
			break;
			}
		}
	}

}
