package TestFramework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author MMS
 *
 */
public class GenericMethods {
	
	WebDriver driver;
	
	public GenericMethods(WebDriver driver){
		this.driver = driver;
	}

	//wyszukanie elementu na stronie wybranym sposobem (id, xpath, nazwa, tag, linktext, css selector
	/**
	 * @param locator Fraza, po kt�rej zostaje wyszukany element
	 * @param type Typ frazy: dost�pne warto�ci xpath, id, css, link, partial link, tag, name, class
	 * @return Zwraca element strony
	 */
	public WebElement getElement(String locator, String type)
	{
		type = type.toLowerCase();
		
		if(type.equals("id")) {
			System.out.println("Element found znaleziony za pomoc� id: " + locator);
			return this.driver.findElement(By.id(locator));
		}
		else if (type.equals("xpath")){
			System.out.println("Element znaleziony za pomoc� xpath: " + locator);
			return this.driver.findElement(By.xpath(locator));	
		}
		else if (type.equals("css")){
			System.out.println("Element znaleziony za pomoc� CSS selector: " + locator);
			return this.driver.findElement(By.cssSelector(locator));
		}
		else if (type.equals("link")){
			System.out.println("Element znaleziony za pomoc� LinkText: " + locator);
			return this.driver.findElement(By.linkText(locator));
		}
		else if (type.equals("partial link")){
			System.out.println("Element znaleziony za pomoc� Partial LinkText: " + locator);
			return this.driver.findElement(By.partialLinkText(locator));
		}
		else if (type.equals("name")){
			System.out.println("Element znaleziony za pomoc� name: " + locator);
			return this.driver.findElement(By.name(locator));
		}
		else if (type.equals("tag")){
			System.out.println("Element znaleziony za pomoc� tag: " + locator);
			return this.driver.findElement(By.tagName(locator));
		}
		else if (type.equals("class")){
			System.out.println("Element znaleziony za pomoc� Class Name: " + locator);
			return this.driver.findElement(By.className(locator));
		}
		else {
			System.out.println("Locator type not supported");
			return null;
		}
	}
	
	
	/** Wyszukuje WebElement za pomoc� xpatha po tekscie (opisie) wy�wietlonym na ekranie
	 * @param text Fragment tekstu widoczny na formatce
	 * @return WebElement
	 */
	public WebElement getElementContainText(String text){
		System.out.println("Wyszukanie obiektu za pomoc� xpatha: " + text);
		return this.driver.findElement(By.xpath("//*[contains(text(),'"+text+"')]"));
			}
	 
	/** Wyszukuje WebElement za pomoc� xpatha po tekscie (opisie) wy�wietlonym na ekranie
	 * @param text Fragment tekstu widoczny na formatce
	 * @param tagType Typ taga, np. div, span, td
	 * @return WebElement
	 */
	public WebElement getElementContainText(String text, String tagType){
		System.out.println("Wyszukanie obiektu za pomoc� xpatha: " + text);
		return this.driver.findElement(By.xpath("//"+tagType+"[contains(text(),'"+text+"')]"));
			}

	/**
	 * @param locator Fraza, po kt�rej zostaje wyszukana lista element�w
	 * @param type Typ frazy: dost�pne warto�ci xpath, id, css, link, partial link, tag, name, class
	 * @return Zwraca element strony
	 */
	public List<WebElement> getElementList(String locator, String type) {
		type = type.toLowerCase();
		List<WebElement> elementList = new ArrayList<WebElement>();
		if (type.equals("id")) {
			elementList = this.driver.findElements(By.id(locator));
		}
		else if (type.equals("name")) {
			elementList = this.driver.findElements(By.name(locator));
		}
		else if (type.equals("xpath")) {
			elementList = this.driver.findElements(By.xpath(locator));
		}
		else if (type.equals("css")) {
			elementList = this.driver.findElements(By.cssSelector(locator));
		}
		else if (type.equals("class")) {
			elementList = this.driver.findElements(By.className(locator));
		}
		else if (type.equals("tag")) {
			elementList = this.driver.findElements(By.tagName(locator));
		}
		else if (type.equals("link")) {
			elementList = this.driver.findElements(By.linkText(locator));
		}
		else if (type.equals("partial link")) {
			elementList = this.driver.findElements(By.partialLinkText(locator));
		}
		else {
			System.out.println("Locator type not supported");
		}
		if (elementList.isEmpty()) {
			System.out.println("Element not found with " + type +": " + locator);
			
		} else {
			System.out.println("Element found with " + type +": " + locator);
		}
		return elementList;
	}

	/** Sprawdznie, czy element jest obecny na stronie 
	 * @param locator {@link #getElementList(String, String)}
	 * @param type {@link #getElementList(String, String)}
	 * @return Zwraca warunek prawda/fa�sz
	 */
	public boolean isElementPresent(String locator, String type){
		List<WebElement> elementList = getElementList(locator, type);
		
		if (elementList.size()>0){
			System.out.println("Element <"+ locator+ ">o typie <"+type+"> zosta� znaleziony na stronie" );
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Klikni�cie przycisku Zapisz na pasku nawigacji
	 */
	public void saveClickOnNavigationPanel(){
		driver.findElement(By.xpath("//div[@title='Zapisz']")).click();
			}
	
	/**
	 * Klikni�cie przycisku 'Dodaj nowy element' na pasku nawigacji
	 */
	public void addNewElementClickOnNavigationPanel(){
		driver.findElement(By.xpath("//div[contains(@title,'Dodaj nowy element')]")).click();
			}
	
	/** Przej�cie do wybranego menu aplikacji (Kontrahenci, Dzia�nia, etc)
	 * @param menuName Nazwa menu
	 * @throws InterruptedException Zawiera sleepa
	 */
	public void openMenu(String menuName) throws InterruptedException {
		System.out.println("Przej�cie do menu: " + menuName);
		driver.findElement(By.xpath("//a[@title='"+menuName+"']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@title='"+menuName+"']")).click();
	}
	
	
	/** Klikni�cie w wybrany kafel w menu Konfiguracja
	 * @param tileName Nazwa szukanego kafelka
	 */
	public void clickConfigurationTile(String tileName){
		System.out.println("Klikni�cie w menu: " + tileName);
		driver.findElement(By.xpath("//p[text()='"+tileName+"']")).click();
	}
	
	/** Klikni�cie w wybrany kafelek na li�cie (np. s�ownik�w, rejon�w, etc.)
	 * @param tileName Nazwa szukanego kafelka
	 */
	public void clickTileByi18(String tileName){
		System.out.println("Klikni�cie w kafel: " + tileName);
		driver.findElement(By.xpath("//div[@i18n='"+tileName+"']")).click();
	}
	
	/** Wyb�r opcji na messageboxie (OK, anuluj)
	 * @param option Opis na przycisku, np. "OK"
	 */
	public void clickMessageBoxButton(String option){
		System.out.println("Messagebox - wyb�r opcji: " + option);
		driver.findElement(By.xpath("//div[@id='esmMessageBox-main-container']//div[text()='"+option+"']")).click();
	}
	
	/** Wyszukanie frazy w wyszukiwarce na pasku nawigacyjnym
	 * @param searchText Szukana fraza
	 */
	public void searchOnList(String searchText){
		System.out.println("Wyszukanie obiektu: Filtr");
		WebElement searcher = driver.findElement(By.xpath("//div[@class='esmAppBar-search-input']//input[@placeholder='Szukaj']"));
		System.out.println("Czyszczenie obiektu: Filtr");
		searcher.click();
		searcher.clear();
		System.out.println("Wyszukanie frazy: " + searchText);
		searcher.sendKeys(searchText);
	}
	
	/**
	 * Wyczyszczenie wyszukiwarki na pasku nawigacyjnym
	 */
	public void clearSearchbox(){
		System.out.println("Czyszczenie obiektu: Filtr");
		WebElement searcher = driver.findElement(By.xpath("//div[@class='esmAppBar-search-input']//input[@placeholder='Szukaj']"));
		searcher.clear();
	}
	
	/**
	 * Dodanie elementu do tabeli np. s�ownika - klikni�cie plusa
	 */
	public void addElementToTable(){
		System.out.println("Dodanie nowego obiektu do tabeli");
		WebElement addButton = driver.findElement(By.xpath("//div[contains(@class,'esmTableView-add-icon')]"));
		addButton.click();
	}
	
	/** Zalogowanie si� do aplikacji: 
	 * wybranie j�zyka polskiego, 
	 * uzupe�nienie p�l Login i Has�o, 
	 * klikni�cie Zaloguj
	 * @param login Login u�ytkownika
	 * @param password Has�o u�ytkownika
	 * @throws InterruptedException 
	 */
	public void loginApp(String login, String password) throws InterruptedException{
		System.out.println("Wyb�r j�zyka");
		driver.findElement(By.xpath("//*[@id='lang-links-panel']/div[1]/a/div")).click(); //wyb�r j�zyka:polski
		
		System.out.println("Pr�ba zalogowania na u�ytkownika: " + login + " / " + password );
		WebElement logname = getElement("UserName", "id");
		logname.clear();
		logname.sendKeys(login);
				
		WebElement passwd = getElement("Password", "id");
		passwd.clear();
		passwd.sendKeys(password);
		
		Thread.sleep(500);
		System.out.println("Klikni�cie zaloguj");
		driver.findElement(By.xpath("//*[@id='form']//input[@type='submit']")).click(); 
	}
	
	/** Pobranie bie��cej daty 
	 * @return Zwraca dat� w formacie "yyyy/MM/dd HH:mm:ss"
	 */
	public String getDate (){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String result = dateFormat.format(date);
		System.out.println(result);
		return result;
	}
	
	/** Wyszukanie elementu na li�cie s�ownikowej + klikni�cie w dany element
	 * @param DictionariesValue Szukana warto�� w tabeli
	 * @throws InterruptedException Zawiera sleepa
	 */
	public void findElementOnList(String DictionariesValue) throws InterruptedException {
		WebElement dicElement;
		System.out.println("Klikni�cie: " + DictionariesValue);
		dicElement = getElement("//span[text()='"+DictionariesValue+"']", "xpath");
		dicElement.click();
		Thread.sleep(1500);
	}
	
	/** Wyczyszczenie nazwy okre�lonego elementu na li�cie (tabeli) s�ownikowej. Stosowa� razem z {@link #findElementOnList(String)}
	 * @param DictionariesValue Warto�� na li�cie, kt�ra ma by� wyczyszczona
	 * @return
	 */
	public WebElement clearElementOnList(String DictionariesValue) {
		WebElement dicElement;
		System.out.println("Wyczyszczenie starej warto�ci");
		dicElement = getElement("//span[text()='"+DictionariesValue+"']//following-sibling::textarea", "xpath");
		dicElement.clear();
		return dicElement;
	}
	
	/** Zmiana nazwy elementu s�ownikowego na li�cie
	 * @param oldDictionariesValue Stara nazwa elementu
	 * @param newDictionariesValue Fraza, na jak� ma by� zmieniona warto��
	 * @throws InterruptedException Zawiera sleepa
	 */
	public void findAndChangeElementOnList(String oldDictionariesValue, String newDictionariesValue)
			throws InterruptedException {
		WebElement dicElement;
		findElementOnList(oldDictionariesValue);
		dicElement = clearElementOnList(oldDictionariesValue);
		System.out.println("Wprowadzenie nowej warto�ci: " + newDictionariesValue);
		dicElement.sendKeys(newDictionariesValue);
		Thread.sleep(1500);
		dicElement.sendKeys(Keys.ENTER);
		Thread.sleep(1500);
	}
	
	/** Przechodzi do wskazanego kroku (zak�adki) kreatora
	 * @param stepNumber Numer kroku
	 */
	public void goToStep(int stepNumber) {
		System.out.println("Przej�cie do kroku kreatora nr: " + stepNumber);
		WebElement step = getElement("//div[@ng-click='goToStep("+stepNumber+")']", "xpath");
		step.click();
	}
	
}
