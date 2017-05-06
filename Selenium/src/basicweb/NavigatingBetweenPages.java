package basicweb;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigatingBetweenPages{

	WebDriver driver;
	String baseURL;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		String title = driver.getTitle();  //pobranie tytu³u strony
		System.out.println("Tile of the page is: " + title);
		
		String currentURL = driver.getCurrentUrl(); //pobranie URL
		System.out.println("Current URL is: " + currentURL);
		
		String URLtonavigate = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";
		driver.navigate().to(URLtonavigate); //przejœcie do okreœlonej strony
		
		currentURL = driver.getCurrentUrl();
		System.out.println("current URL is: " + currentURL);
		
		Thread.sleep(2000); //sleep
		driver.navigate().back(); //powrót do poprzedniej strony
		System.out.println("Navigate back");
		currentURL = driver.getCurrentUrl();
		System.out.println("current URL is: " + currentURL);
		
		Thread.sleep(2000);
		driver.navigate().forward(); //forward do strony
		System.out.println("Navigate forward");
		currentURL = driver.getCurrentUrl();
		System.out.println("current URL is: " + currentURL);
		
		Thread.sleep(2000);
		driver.navigate().back();
		System.out.println("back to main page");
		currentURL = driver.getCurrentUrl();
		System.out.println("current URL is: " + currentURL);
		
		driver.navigate().refresh();  //refresh
		System.out.println("navigate refresh");
		//second way to refresh
		currentURL = driver.getCurrentUrl(); //2nd refresh
		driver.get(currentURL);
		
		String source = driver.getPageSource(); //pobranie kodu strony
		System.out.println(source);
		
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
