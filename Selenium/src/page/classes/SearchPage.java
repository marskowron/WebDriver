package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

	public static WebElement element = null;

	public static WebElement originTextBox (WebDriver driver){
		element = driver.findElement(By.id("flight-origin"));
		return element;
	}
	
	public static void fillOriginTextBox (WebDriver driver, String origin){
		element = originTextBox(driver);
		element.sendKeys(origin);
	}
	
	public static WebElement destinationTextBox (WebDriver driver){
		element = driver.findElement(By.id("flight-destination"));
		return element;
	}
	
	public static void filldestinationTextBox (WebDriver driver, String destination){
		element = destinationTextBox(driver);
		element.sendKeys(destination);
	}
	
	public static WebElement departureTextBox (WebDriver driver){
		element = driver.findElement(By.id("flight-departing"));
		return element;
	}
	
	public static WebElement returnTextBox (WebDriver driver){
		element = driver.findElement(By.id("flight-returning"));
		return element;
	}
	
	public static WebElement searchButton (WebDriver driver){
		element = driver.findElement(By.id("search-button"));
		return element;
	}
	
	public static void clickOnSearchButton (WebDriver driver){
		element = searchButton(driver);
		element.click();
	}
	
	public static void navigatesToFlightsTab (WebDriver driver){
		//driver.findElement(By.id("header-history")).click();
		element = driver.findElement(By.id("tab-flight-tab-hp"));
		element.click();
	}
}
