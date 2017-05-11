package webCRM;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import TestFramework.GenericMethods;

public class DictonariesAddElement {

	private WebDriver driver;
	private String baseURL;
	private GenericMethods gm;
	
	@Before
	public void setUp() throws Exception {
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		baseURL = "http://localhost/MobileManagement/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		gm = new GenericMethods(driver);
	}

	@Test
	public void _01Login() throws InterruptedException {
	
		gm.loginApp("ms", "ms");
		
		System.out.println("Klikni�cie zaloguj");
		driver.findElement(By.xpath("//*[@id='form']//input[@type='submit']")).click();
		
		System.out.println("Klikni�cie konfiguracja");
		driver.findElement(By.xpath("//a[@title='Konfiguracja']")).click();
		
		Thread.sleep(1000);
		System.out.println("Klikni�cie menu s�owniki");
		driver.findElement(By.xpath("//p[text()='S�owniki']")).click();
		
		Thread.sleep(2000);
		System.out.println("Klikni�cie menu Typy wizyt");
		driver.findElement(By.xpath("//div[@i18n='Typy wizyt']")).click();
		//div[@id='transistsTypesList']//span[text()='Ankieta okresowa']
		
		Thread.sleep(2000);
		System.out.println("Klikni�cie Ankieta okresowa");
		WebElement dicElement = gm.getElement("//div[@id='transistsTypesList']//span[text()='Ankieta okresowa']", "xpath");
		dicElement.click();
		dicElement = gm.getElement("//div[@id='transistsTypesList']//span[text()='Ankieta okresowa']//following-sibling::textarea", "xpath");
		dicElement.clear();
		
		gm.saveClickAB();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='esmMessageBox-main-container']//div[text()='OK']")).click();
		Thread.sleep(2000);
		dicElement = gm.getElement("//div[@id='transistsTypesList']//span[text()='Brak warto�ci']", "xpath");
		dicElement.click();
		dicElement = gm.getElement("//div[@id='transistsTypesList']//span[contains(@class,'edit-in-place-invalid')]//following-sibling::textarea", "xpath");
		dicElement.clear();
		
		dicElement.sendKeys("nowa warto��");
		dicElement.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//div[@title='Zapisz']")).click();
	}
	
	@After
	public void tearDown() throws Exception {
	}



}
