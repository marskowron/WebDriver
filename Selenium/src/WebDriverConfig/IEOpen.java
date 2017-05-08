package WebDriverConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class IEOpen {

	public static void main(String[] args) {
		String baseURL = "http://www.onet.pl";
		WebDriver driver;
		System.setProperty("webdriver.ie.driver", "E:\\workspace\\selenium-java-3.4.0\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get(baseURL);
		//driver.close();

	}

}
