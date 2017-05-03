package basicweb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilities {
	
	public static void main(String[] args) throws Exception {
		WebDriver driver;
		String baseURL = "https://letskodeit.teachable.com/pages/practice";
		System.setProperty("webdriver.gecko.driver", "E:\\workspace\\selenium-java-3.4.0\\geckodriver.exe");  
		org.openqa.selenium.remote.DesiredCapabilities caps = org.openqa.selenium.remote.DesiredCapabilities.firefox();
		caps.setBrowserName("firefox");
		caps.setPlatform(Platform.WINDOWS);
		
		driver = new FirefoxDriver(caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
	}
}