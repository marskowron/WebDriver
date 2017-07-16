package FindingElements;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import page.classes.SearchPage;

public class FindAllLinks {

	WebDriver driver;
	String baseURL;	
	
	@Before
	public void setUp() throws Exception {
		
		driver = new FirefoxDriver();
		baseURL = "https://www.expedia.com/";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testFindLinks() {
		driver.get(baseURL);
		SearchPage.navigatesToFlightsTab(driver);
		
		List<WebElement> linkslist = clickableLinks(driver);
		for (WebElement link : linkslist) {
			String href = link.getAttribute("href");
			
			try{
				System.out.println("URL " + href + " return " + linkStatus(new URL(href)));
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static List<WebElement> clickableLinks(WebDriver driver){
	
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		//dodanie elementów do listy UNION
		elements.addAll(driver.findElements(By.tagName("img")));
		
		List<WebElement> linksToClick = new ArrayList<WebElement>();
		
		for (WebElement e: elements){
			if (e.getAttribute("href") != null){
				linksToClick.add(e);
				}
		}
		return linksToClick;
	}
	
	public static String linkStatus(URL url) {
		
		try{
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			String responseMessage = http.getResponseMessage();
			http.disconnect();
			return responseMessage;
		}
		catch (Exception e){
			return e.getMessage();
		}
	}
	
	@After
	public void tearDown() throws Exception {
	}



}
