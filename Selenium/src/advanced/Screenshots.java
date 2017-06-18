package advanced;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestFramework.GenericMethods;

public class Screenshots {

	public static WebDriver driver;
	private GenericMethods gm;
	String baseURL;
	

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		gm = new GenericMethods(driver);
		baseURL = "http://expedia.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		driver.get(baseURL);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-flight-tab-hp"))).click();
				
		System.out.println(gm.getFileName());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flight-origin-hp-flight"))).sendKeys("Kraków");
		driver.findElement(By.id("flight-destination-hp-flight")).sendKeys("Barcelona");
		driver.findElement(By.id("flight-departing-hp-flight")).click();
		driver.findElement(By.xpath("//*[@id='flight-departing-wrapper-hp-flight']/div/div/div[2]/table/tbody/tr[4]/td[1]/button")).click();
		driver.findElement(By.id("flight-returning-hp-flight")).click();
		driver.findElement(By.xpath("//*[@id='flight-returning-wrapper-hp-flight']/div/div/div[2]/table/tbody/tr[5]/td[6]/button")).click();
		
		
		driver.findElement(By.xpath("//*[@id='gcw-flights-form-hp-flight']/div[8]/label/button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("stopFilter_stops-1"))).click();


		}
	@After	
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		String fileName = gm.getFileName() + ".png";
		System.out.println(fileName);
		String directory = "D:\\LOGS\\";
		
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
		driver.quit();
	}

}
