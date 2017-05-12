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

	private WebDriver driver = new FirefoxDriver();
	private String baseURL;
	private GenericMethods gm;
	
	@Before
	public void setUp() throws Exception {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		gm = new GenericMethods(driver);
	}

	@Test
	public void _01Login() throws InterruptedException {
		
		baseURL = "http://localhost/MobileManagement/";
		driver.get(baseURL);
		String newDictionariesValue = "nowa wartoœæ";
		String oldDictionariesValue = "Ankieta okresowa";
		
		gm.loginApp("ms", "ms");

		gm.openMenu("Konfiguracja");
		
		Thread.sleep(1000);
		gm.clickConfigurationTile("S³owniki");
		
		Thread.sleep(1000);
		gm.clickTileByi18("Typy wizyt");
		//div[@id='transistsTypesList']//span[text()='Ankieta okresowa']
		
		Thread.sleep(1000);
		System.out.println("Klikniêcie: " + oldDictionariesValue);
		WebElement dicElement = gm.getElement("//div[@id='transistsTypesList']//span[text()='"+oldDictionariesValue+"']", "xpath");
		dicElement.click();
		dicElement = gm.getElement("//div[@id='transistsTypesList']//span[text()='"+oldDictionariesValue+"']//following-sibling::textarea", "xpath");
		dicElement.clear();
		
		gm.saveClickAB();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='esmMessageBox-main-container']//div[text()='OK']")).click();
		Thread.sleep(2000);
		dicElement = gm.getElement("//div[@id='transistsTypesList']//span[text()='Brak wartoœci']", "xpath");
		dicElement.click();
		dicElement = gm.getElement("//div[@id='transistsTypesList']//span[contains(@class,'edit-in-place-invalid')]//following-sibling::textarea", "xpath");
		dicElement.clear();
		dicElement.sendKeys(newDictionariesValue);
		Thread.sleep(1000);
		dicElement.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		gm.saveClickAB();
		
		gm.clickTileByi18("Typy wizyt");
		gm.searchOnList(newDictionariesValue);
		Thread.sleep(1000);
		
		System.out.println("Klikniêcie: " + newDictionariesValue);
		dicElement = gm.getElement("//div[@id='transistsTypesList']//span[text()='"+newDictionariesValue+"']", "xpath");
		dicElement.click();
		dicElement = gm.getElement("//div[@id='transistsTypesList']//span[text()='"+newDictionariesValue+"']//following-sibling::textarea", "xpath");
		dicElement.clear();
		
		dicElement.sendKeys(oldDictionariesValue);
		Thread.sleep(1000);
		dicElement.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		gm.saveClickAB();
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}



}
