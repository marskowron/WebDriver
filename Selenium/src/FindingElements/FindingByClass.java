package FindingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindingByClass {

	public static void main(String[] args)  throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseURL = "https://demostore.x-cart.com/";
		driver.manage().window().maximize();
		driver.get(baseURL);
		Thread.sleep(2000);
		driver.findElement(By.className("title")).click();
		

	}

}
