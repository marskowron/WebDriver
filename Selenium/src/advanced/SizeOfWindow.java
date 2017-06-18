package advanced;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

public class SizeOfWindow {

	private WebDriver driver;
	private JavascriptExecutor js;
	String baseURL;
	

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		//baseURL = "http://southwest.com";
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException {
		js.executeScript("window.location = 'http://letskodeit.teachable.com/p/practice'");
		Thread.sleep(3000);
		//size of window by selenium - zwraca rozmiar z toolbarami
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		//size of window by js - zwraca wewnêtrzny rozmiar
		long height = (Long) js.executeScript("return window.innerHeight;");
		long width = (Long) js.executeScript("return window.innerWidth;");
		System.out.println("Size od the window is: "+height+ " x " + width);
		
		driver.manage().window().maximize();
		height = (Long) js.executeScript("return window.innerHeight;");
		width = (Long) js.executeScript("return window.innerWidth;");
		System.out.println("Size od the window is: "+height+ " x " + width);
		
		size = driver.manage().window().getSize();
		System.out.println(size);
		
		//ustawianie rozmiaru okna 480x800
		Dimension newSizeOfWindow = new Dimension(480, 800);
		driver.manage().window().setSize(newSizeOfWindow);
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
