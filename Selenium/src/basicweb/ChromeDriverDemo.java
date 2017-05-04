package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeDriverDemo {

	public static void main(String[] args) {
	
		String baseURL = "http://www.onet.pl";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:\\workspace\\selenium-java-3.4.0\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseURL);
		driver.close();
	}

}
