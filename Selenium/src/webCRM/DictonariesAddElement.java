package webCRM;

import java.util.List;
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

	WebDriver driver = new FirefoxDriver();
	
	private String baseURL;
	private GenericMethods gm;
	
	@Before
	public void setUp() throws Exception {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		gm = new GenericMethods(driver);
	}

	@Test
	public void _01Login() throws InterruptedException {
		
		//baseURL = "http://localhost/MobileManagement/";
		baseURL = "http://195.69.208.91:808/MobileManagement_pxl2/";
		driver.get(baseURL);
		String newDictionariesValue = "zmieniona warto��1";
		String oldDictionariesValue = "Ankieta okresowa";
		String addDictionariesValue = "nowa warto�� " + gm.getDate();
		String addDictionariesValue1 = "duplikacja";
		String addDictionariesValue2 = "nowa warto��2 " + gm.getDate();
		WebElement dicElement;
		
		//logowanie do aplikacji
		gm.loginApp("ca", "ca");
		Thread.sleep(1500);
		
		//Przej�cie do wybranego s�ownika
		gm.openMenu("Konfiguracja");
		Thread.sleep(1500);
		gm.clickConfigurationTile("S�owniki");
		Thread.sleep(1500);
		gm.clickTileByi18("Typy wizyt");
		Thread.sleep(1500);
		
		//odszukanie elementu na li�cie, pr�ba zapisu pustej warto�ci
		gm.findElementOnList(oldDictionariesValue);
		gm.clearElementOnList(oldDictionariesValue);
		gm.saveClickOnNavigationPanel();
		Thread.sleep(1500);
		
		//komunikat waliduj�cy
		gm.clickMessageBoxButton("OK");
		Thread.sleep(1500);
		
		//wpisanie poprawnej warto�ci
		dicElement = gm.getElement("//div[@id='transistsTypesList']//span[text()='Brak warto�ci']", "xpath");
		dicElement.click();
		dicElement = gm.getElement("//div[@id='transistsTypesList']//span[contains(@class,'edit-in-place-invalid')]//following-sibling::textarea", "xpath");
		dicElement.clear();
		dicElement.sendKeys(newDictionariesValue);
		Thread.sleep(1500);
		dicElement.sendKeys(Keys.ENTER);
		Thread.sleep(1500);
		
		//zapis listy
		gm.saveClickOnNavigationPanel();
		Thread.sleep(1500);
		
		//wej�cie na liste, przywr�cenie pierwotnej warto�ci
		gm.clickTileByi18("Typy wizyt");
		Thread.sleep(1500);
		gm.searchOnList(newDictionariesValue);
		Thread.sleep(1500);
		gm.clearSearchbox();
		Thread.sleep(1500);
		gm.findAndChangeElementOnList(newDictionariesValue, oldDictionariesValue);
		Thread.sleep(1500);
		
		//zapis listy
		gm.saveClickOnNavigationPanel();
		Thread.sleep(1500);
		
		//wej�cie na list� dodanie nowego elementu
		gm.clickTileByi18("Typy wizyt");
		gm.addElementToTable();
		Thread.sleep(500);
		driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div[3]/div[1]/input")).click();
		Thread.sleep(1500);
		dicElement = gm.getElement("//div[@id='transistsTypesList']//span[text()='Brak warto�ci']", "xpath");
		dicElement.click();
		dicElement = gm.getElement("//div[@id='transistsTypesList']//span[contains(@class,'edit-in-place-invalid')]//following-sibling::textarea", "xpath");
		dicElement.clear();
		dicElement.sendKeys(addDictionariesValue1);
		Thread.sleep(1500);
		dicElement.sendKeys(Keys.ENTER);
		Thread.sleep(1500);
		
		//dodanie kolejnego elementu o tej samej nazwie
		gm.addElementToTable();
		Thread.sleep(500);
		driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div[3]/div[1]/input")).click();
		Thread.sleep(1500);
		dicElement = gm.getElement("//div[@id='transistsTypesList']//span[text()='Brak warto�ci']", "xpath");
		dicElement.click();
		dicElement = gm.getElement("//div[@id='transistsTypesList']//span[contains(@class,'edit-in-place-invalid')]//following-sibling::textarea", "xpath");
		dicElement.clear();
		dicElement.sendKeys(addDictionariesValue1);
		Thread.sleep(1500);
		dicElement.sendKeys(Keys.ENTER);
		
		//pr�ba zapisu
		gm.saveClickOnNavigationPanel();
		Thread.sleep(1500);
		
		//komunikat z b�edem
		gm.clickMessageBoxButton("OK");
		
		//powr�t na list� i poprawienie warto�ci
		List<WebElement> dicElementList = gm.getElementList("//span[text()='"+addDictionariesValue1+"']", "xpath");
		int size=dicElementList.size();
		System.out.println(size);
		Thread.sleep(1500);
		System.out.println("Klikni�cie: " + oldDictionariesValue);
		dicElementList.get(size-1).click();
		Thread.sleep(1500);
		dicElementList = gm.getElementList("//span[text()='"+addDictionariesValue1+"']//following-sibling::textarea", "xpath");
		Thread.sleep(1500);
		dicElementList.get(size-1).clear();
		Thread.sleep(1500);
		dicElementList.get(size-1).sendKeys(addDictionariesValue);
		Thread.sleep(1500);
		gm.findAndChangeElementOnList(addDictionariesValue1, addDictionariesValue2);
		
		//zapis s�ownika
		gm.saveClickOnNavigationPanel();
		
	}

	
	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}



}
