package basicweb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericMethods {
	
	WebDriver driver;
	
	public GenericMethods(WebDriver driver){
		this.driver = driver;
	}

	public WebElement getElement(String locator, String type)
	{
		type = type.toLowerCase();
		
		if(type.equals("id")) {
			System.out.println("Element found by id: " + locator);
			return this.driver.findElement(By.id(locator));
		}
		else if (type.equals("xpath")){
			System.out.println("Element found by xpath: " + locator);
			return this.driver.findElement(By.xpath(locator));	
		}
		else if (type.equals("css")){
			System.out.println("Element found by CSS selector: " + locator);
			return this.driver.findElement(By.cssSelector(locator));
		}
		else if (type.equals("link")){
			System.out.println("Element found by LinkText: " + locator);
			return this.driver.findElement(By.linkText(locator));
		}
		else if (type.equals("partial link")){
			System.out.println("Element found by Partial LinkText: " + locator);
			return this.driver.findElement(By.partialLinkText(locator));
		}
		else if (type.equals("name")){
			System.out.println("Element found by name: " + locator);
			return this.driver.findElement(By.name(locator));
		}
		else if (type.equals("class")){
			System.out.println("Element found by Class Name: " + locator);
			return this.driver.findElement(By.className(locator));
		}
		else {
			System.out.println("Locator type not supported");
			return null;
		}
	}
	
	public List<WebElement> getElementList(String locator, String type)
	{
		type = type.toLowerCase();
		
		if(type.equals("id")) {
			System.out.println("List of elements found by id: " + locator);
			return this.driver.findElements(By.id(locator));
		}
		else if (type.equals("xpath")){
			System.out.println("List of elements found by xpath: " + locator);
			return this.driver.findElements(By.xpath(locator));	
		}
		else if (type.equals("css")){
			System.out.println("List of elements found by CSS selector: " + locator);
			return this.driver.findElements(By.cssSelector(locator));
		}
		else if (type.equals("link")){
			System.out.println("List of elements found by LinkText: " + locator);
			return this.driver.findElements(By.linkText(locator));
		}
		else if (type.equals("partial link")){
			System.out.println("List of elements found by Partial LinkText: " + locator);
			return this.driver.findElements(By.partialLinkText(locator));
		}
		else if (type.equals("name")){
			System.out.println("List of elements found by name: " + locator);
			return this.driver.findElements(By.name(locator));
		}
		else if (type.equals("class")){
			System.out.println("List of elements found by Class Name: " + locator);
			return this.driver.findElements(By.className(locator));
		}
		else {
			System.out.println("Locator type <" + type + "> not supported");
			return null;
		}
	}
}
