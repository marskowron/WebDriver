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
import org.openqa.selenium.interactions.Actions;

import TestFramework.*;

public class DictonariesAddElement {

	WebDriver driver = new FirefoxDriver();
	
	private String baseURL;
	private GenericMethods gm;
	private CalendarMethods cm;
	
	@Before
	public void setUp() throws Exception {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		gm = new GenericMethods(driver);
		cm = new CalendarMethods(driver);
		//baseURL = "http://localhost/MobileManagement/";
		baseURL = "http://195.69.208.91:808/MobileManagement_pxl2/";
	}

	@Test
	public void _01Login() throws InterruptedException {
		
		String login = "ca";
		String password = "ca";
		driver.get(baseURL);
		String newDictionariesValue = "zmieniona warto��1";
		String oldDictionariesValue = "Ankieta okresowa";
		String addDictionariesValue = "nowa warto�� " + gm.getDate();
		String addDictionariesValue1 = "duplikacja";
		WebElement dicElement;
		
		//logowanie do aplikacji
		gm.loginApp(login,password);
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
		addDictionariesValue = "nowa warto�� " + gm.getDate();
		gm.findAndChangeElementOnList(addDictionariesValue1, addDictionariesValue);
		
		//zapis s�ownika
		gm.saveClickOnNavigationPanel();
		
	}
 
	@Test
	public void _02Calendar() throws InterruptedException {
		
		//definiowanie zmiennych
		String employee = "Skowron Marcin";
		String login = "ca";
		String password = "ca";
		String year = "2018";
		String month = "listopad";
		String day = "27";
		int dayOfWeek = 3;
				
		//logowanie do aplikacji
		driver.get(baseURL);
		gm.loginApp(login,password);
		Thread.sleep(1500);
		
		//Przej�cie do kalendarza
		gm.openMenu("Dzia�ania");
		Thread.sleep(1500);
		
		//przej�cie do wybranej daty
		cm.moveToFutherDate(year, month, day);
		Thread.sleep(3000);
		
		//miesi�c w prz�d/w ty�
		cm.openCalendar();
		cm.moveToNextMonth();
		Thread.sleep(1500);
		cm.moveToPreviousMonth();
		Thread.sleep(1500);
		cm.clickOnDay(day);
		Thread.sleep(1500);
		
		//wyb�r dnia dzisiejszego
		cm.moveToToday();
		Thread.sleep(1500);
		
		//klikanie po kalendarzu
		cm.getCalendarCell(employee, dayOfWeek);
		
		Thread.sleep(1500);
		employee="Pracowity Cezary";
		dayOfWeek=4;
		cm.getCalendarCell(employee, dayOfWeek);
		
		Thread.sleep(1500);
		employee="Gaboni Nicolas";
		dayOfWeek=1;
		cm.getCalendarCell(employee, dayOfWeek);
	}
	
	@Test
	public void _03Questionnaires() throws InterruptedException {
		
		//definiowanie zmiennych
		String login = "ca";
		String password = "ca";
		
		//logowanie do aplikacji
		driver.get(baseURL);
		gm.loginApp(login,password);
		Thread.sleep(2000);
		
		//Przej�cie do konfiguracji
		gm.openMenu("Konfiguracja");
		gm.openMenu("Konfiguracja");
		Thread.sleep(1500);
		
		//Przej�cie do elementy wzorc�w wizyt
		gm.clickConfigurationTile("Elementy wzorc�w wizyt");
		Thread.sleep(1500);
		
		//dodanie nowego elementu
		gm.addNewElementClickOnNavigationPanel();
		Thread.sleep(1500);
		WebElement name =driver.findElement(By.xpath("//div[contains(@ng-show,'Other')]//div[contains(text(),'Wprowad� nazw� elementu')]"));
		name.click();
		name = driver.findElement(By.xpath("//div[contains(@ng-show,'Other')]//div[@class='text-box-cell']//textarea[@rows='1']"));
		name.sendKeys("test");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[contains(@ng-show,'Other')]//span[contains(text(),'Rodzaj elementu')]")).click();
		Thread.sleep(1500);
		gm.getElementContainText("Ankieta", "div").click();
		Thread.sleep(1500);
	
		//przejscie do drugiej zakladki
		gm.goToStep(2);
		Thread.sleep(1500);
		WebElement fromElement = driver.findElement(By.xpath("//div[@id='questionnairesSelectList']//div[contains(text(),'Customer Satifaction Evaluation')]"));
		WebElement toElement = driver.findElement(By.xpath("//*[@id='relatedQuestionnairesList']/div"));
				
		Actions dnd = new Actions(driver);
		dnd.dragAndDrop(fromElement, toElement).build().perform();
	}
	
	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}



}
