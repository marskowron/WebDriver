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
	 * @param locator Fraza, po której zostaje wyszukany element
	 * @param type Typ frazy: dostêpne wartoœci xpath, id, css, link, partial link, tag, name, class
	 * @return Zwraca element strony
	 */
	public WebElement getElement(String locator, String type)
	{
		type = type.toLowerCase();
		
		if(type.equals("id")) {
			System.out.println("Element found znaleziony za pomoc¹ id: " + locator);
			return this.driver.findElement(By.id(locator));
		}
		else if (type.equals("xpath")){
			System.out.println("Element znaleziony za pomoc¹ xpath: " + locator);
			return this.driver.findElement(By.xpath(locator));	
		}
		else if (type.equals("css")){
			System.out.println("Element znaleziony za pomoc¹ CSS selector: " + locator);
			return this.driver.findElement(By.cssSelector(locator));
		}
		else if (type.equals("link")){
			System.out.println("Element znaleziony za pomoc¹ LinkText: " + locator);
			return this.driver.findElement(By.linkText(locator));
		}
		else if (type.equals("partial link")){
			System.out.println("Element znaleziony za pomoc¹ Partial LinkText: " + locator);
			return this.driver.findElement(By.partialLinkText(locator));
		}
		else if (type.equals("name")){
			System.out.println("Element znaleziony za pomoc¹ name: " + locator);
			return this.driver.findElement(By.name(locator));
		}
		else if (type.equals("tag")){
			System.out.println("Element znaleziony za pomoc¹ tag: " + locator);
			return this.driver.findElement(By.tagName(locator));
		}
		else if (type.equals("class")){
			System.out.println("Element znaleziony za pomoc¹ Class Name: " + locator);
			return this.driver.findElement(By.className(locator));
		}
		else {
			System.out.println("Locator type not supported");
			return null;
		}
	}
	
	
	/** Wyszukuje WebElement za pomoc¹ xpatha po tekscie (opisie) wyœwietlonym na ekranie
	 * @param text Fragment tekstu widoczny na formatce
	 * @return WebElement
	 */
	public WebElement getElementContainText(String text){
		System.out.println("Wyszukanie obiektu za pomoc¹ xpatha: " + text);
		return this.driver.findElement(By.xpath("//*[contains(text(),'"+text+"')]"));
			}
	 
	/** Wyszukuje WebElement za pomoc¹ xpatha po tekscie (opisie) wyœwietlonym na ekranie
	 * @param text Fragment tekstu widoczny na formatce
	 * @param tagType Typ taga, np. div, span, td
	 * @return WebElement
	 */
	public WebElement getElementContainText(String text, String tagType){
		System.out.println("Wyszukanie obiektu za pomoc¹ xpatha: " + text);
		return this.driver.findElement(By.xpath("//"+tagType+"[contains(text(),'"+text+"')]"));
			}

	/**
	 * @param locator Fraza, po której zostaje wyszukana lista elementów
	 * @param type Typ frazy: dostêpne wartoœci xpath, id, css, link, partial link, tag, name, class
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
	 * @return Zwraca warunek prawda/fa³sz
	 */
	public boolean isElementPresent(String locator, String type){
		List<WebElement> elementList = getElementList(locator, type);
		
		if (elementList.size()>0){
			System.out.println("Element <"+ locator+ ">o typie <"+type+"> zosta³ znaleziony na stronie" );
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Klikniêcie przycisku Zapisz na pasku nawigacji
	 */
	public void saveClickOnNavigationPanel(){
		driver.findElement(By.xpath("//div[@title='Zapisz']")).click();
			}
	
	/**
	 * Klikniêcie przycisku 'Dodaj nowy element' na pasku nawigacji
	 */
	public void addNewElementClickOnNavigationPanel(){
		driver.findElement(By.xpath("//div[contains(@title,'Dodaj nowy element')]")).click();
			}
	
	/** Przejœcie do wybranego menu aplikacji (Kontrahenci, Dzia³nia, etc)
	 * @param menuName Nazwa menu
	 * @throws InterruptedException Zawiera sleepa
	 */
	public void openMenu(String menuName) throws InterruptedException {
		System.out.println("Przejœcie do menu: " + menuName);
		driver.findElement(By.xpath("//a[@title='"+menuName+"']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@title='"+menuName+"']")).click();
	}
	
	
	/** Klikniêcie w wybrany kafel w menu Konfiguracja
	 * @param tileName Nazwa szukanego kafelka
	 */
	public void clickConfigurationTile(String tileName){
		System.out.println("Klikniêcie w menu: " + tileName);
		driver.findElement(By.xpath("//p[text()='"+tileName+"']")).click();
	}
	
	/** Klikniêcie w wybrany kafelek na liœcie (np. s³owników, rejonów, etc.)
	 * @param tileName Nazwa szukanego kafelka
	 */
	public void clickTileByi18(String tileName){
		System.out.println("Klikniêcie w kafel: " + tileName);
		driver.findElement(By.xpath("//div[@i18n='"+tileName+"']")).click();
	}
	
	/** Wybór opcji na messageboxie (OK, anuluj)
	 * @param option Opis na przycisku, np. "OK"
	 */
	public void clickMessageBoxButton(String option){
		System.out.println("Messagebox - wybór opcji: " + option);
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
	 * Dodanie elementu do tabeli np. s³ownika - klikniêcie plusa
	 */
	public void addElementToTable(){
		System.out.println("Dodanie nowego obiektu do tabeli");
		WebElement addButton = driver.findElement(By.xpath("//div[contains(@class,'esmTableView-add-icon')]"));
		addButton.click();
	}
	
	/** Zalogowanie siê do aplikacji: 
	 * wybranie jêzyka polskiego, 
	 * uzupe³nienie pól Login i Has³o, 
	 * klikniêcie Zaloguj
	 * @param login Login u¿ytkownika
	 * @param password Has³o u¿ytkownika
	 * @throws InterruptedException 
	 */
	public void loginApp(String login, String password) throws InterruptedException{
		System.out.println("Wybór jêzyka");
		driver.findElement(By.xpath("//*[@id='lang-links-panel']/div[1]/a/div")).click(); //wybór jêzyka:polski
		
		System.out.println("Próba zalogowania na u¿ytkownika: " + login + " / " + password );
		WebElement logname = getElement("UserName", "id");
		logname.clear();
		logname.sendKeys(login);
				
		WebElement passwd = getElement("Password", "id");
		passwd.clear();
		passwd.sendKeys(password);
		
		Thread.sleep(500);
		System.out.println("Klikniêcie zaloguj");
		driver.findElement(By.xpath("//*[@id='form']//input[@type='submit']")).click(); 
	}
	
	/** Pobranie bie¿¹cej daty 
	 * @return Zwraca datê w formacie "yyyy/MM/dd HH:mm:ss"
	 */
	public String getDate (){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String result = dateFormat.format(date);
		System.out.println(result);
		return result;
	}
	
	/** Wyszukanie elementu na liœcie s³ownikowej + klikniêcie w dany element
	 * @param DictionariesValue Szukana wartoœæ w tabeli
	 * @throws InterruptedException Zawiera sleepa
	 */
	public void findElementOnList(String DictionariesValue) throws InterruptedException {
		WebElement dicElement;
		System.out.println("Klikniêcie: " + DictionariesValue);
		dicElement = getElement("//span[text()='"+DictionariesValue+"']", "xpath");
		dicElement.click();
		Thread.sleep(1500);
	}
	
	/** Wyczyszczenie nazwy okreœlonego elementu na liœcie (tabeli) s³ownikowej. Stosowaæ razem z {@link #findElementOnList(String)}
	 * @param DictionariesValue Wartoœæ na liœcie, która ma byæ wyczyszczona
	 * @return
	 */
	public WebElement clearElementOnList(String DictionariesValue) {
		WebElement dicElement;
		System.out.println("Wyczyszczenie starej wartoœci");
		dicElement = getElement("//span[text()='"+DictionariesValue+"']//following-sibling::textarea", "xpath");
		dicElement.clear();
		return dicElement;
	}
	
	/** Zmiana nazwy elementu s³ownikowego na liœcie
	 * @param oldDictionariesValue Stara nazwa elementu
	 * @param newDictionariesValue Fraza, na jak¹ ma byæ zmieniona wartoœæ
	 * @throws InterruptedException Zawiera sleepa
	 */
	public void findAndChangeElementOnList(String oldDictionariesValue, String newDictionariesValue)
			throws InterruptedException {
		WebElement dicElement;
		findElementOnList(oldDictionariesValue);
		dicElement = clearElementOnList(oldDictionariesValue);
		System.out.println("Wprowadzenie nowej wartoœci: " + newDictionariesValue);
		dicElement.sendKeys(newDictionariesValue);
		Thread.sleep(1500);
		dicElement.sendKeys(Keys.ENTER);
		Thread.sleep(1500);
	}
	
	/** Przechodzi do wskazanego kroku (zak³adki) kreatora
	 * @param stepNumber Numer kroku
	 */
	public void goToStep(int stepNumber) {
		System.out.println("Przejœcie do kroku kreatora nr: " + stepNumber);
		WebElement step = getElement("//div[@ng-click='goToStep("+stepNumber+")']", "xpath");
		step.click();
	}
	
}
