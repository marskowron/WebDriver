package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindingLinkText {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new FirefoxDriver();
		String baseURL = "http://www.gim2.mielec.pl/";
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		driver.findElement(By.linkText("AKTUALNOŒCI")).click(); //wyszukuje po nazwie linku TYLKO w przypadku <a>; przy <span>nie dzia³a
		
		//driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[4]/div/div/ul/li[1]/div/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("ELEKTRONICZNY")).click();
	}

}
