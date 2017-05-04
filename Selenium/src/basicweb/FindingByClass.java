package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindingByClass {

	public static void main(String[] args)  throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseURL = "http://www.gim2.mielec.pl/";
		driver.manage().window().maximize();
		driver.get(baseURL);
		Thread.sleep(2000);
		

	}

}
