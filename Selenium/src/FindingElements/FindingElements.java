package FindingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindingElements {

	public static void main(String[] args) {
	
		WebDriver driver = new FirefoxDriver();
		String baseURL = "http://google.com";
		driver.get(baseURL);
		driver.manage().window().maximize(); // maksymalizuje okno
		
		driver.findElement(By.id("lst-ib")).sendKeys("letskodeit"); //wyszukuje element po Id - wpisuje tekst
		driver.findElement(By.xpath("//*[@id='_fZl']")).click(); //wyszukuje element po xpathie i klika
		driver.findElement(By.name("btnG")).click(); //wyszukuje element po nazwie i klika
		
		//driver.close();

	}

}
