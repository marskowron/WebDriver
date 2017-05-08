package Timeouts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {

	WebDriver driver;
	
	public WaitTypes(WebDriver driver){
		this.driver=driver;
		
	}
	
	public WebElement waitForElement(By locator, int timeout){
		WebElement element = null;
		try{
			System.out.println("Waiting for max: " + timeout + " second to be available");
			WebDriverWait wait = new WebDriverWait(driver, 3); // definiujemy ile sekund maksymalnie czekamy
			element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(locator)); //definiujemy warunek
			System.out.println("Element <" + locator + "> appeared on the Web page");
			
		}catch(Exception e){
			System.out.println("Element not appeared on the Web page in designed time");
		}
		
		return element;
	}
	
}
