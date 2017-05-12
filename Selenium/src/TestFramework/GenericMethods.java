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

public class GenericMethods {
	
	WebDriver driver;
	
	public GenericMethods(WebDriver driver){
		this.driver = driver;
	}

	//wyszukanie elementu na stronie wybranym sposobem (id, xpath, nazwa, tag, linktext, css selector
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

	//wyszukanie listy element�w na stronie
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

	//sprawdznie czy element jest obecny
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
	
	//klikni�cie Zapisz na pasku nawigacji
	public void saveClickOnNavigationPanel(){
		driver.findElement(By.xpath("//div[@title='Zapisz']")).click();
			}
	
	//przej�cie do wybranego menu aplikacji
	public void openMenu(String menuName) throws InterruptedException{
		System.out.println("Przej�cie do menu: " + menuName);
		driver.findElement(By.xpath("//a[@title='"+menuName+"']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@title='"+menuName+"']")).click();
	}
	
	//klikni�cie w kafel w menu Konfiguracja
	public void clickConfigurationTile(String tileName){
		System.out.println("Klikni�cie w menu: " + tileName);
		driver.findElement(By.xpath("//p[text()='"+tileName+"']")).click();
	}
	
	//klikni�cie w kafelek
	public void clickTileByi18(String tileName){
		System.out.println("Klikni�cie w kafel: " + tileName);
		driver.findElement(By.xpath("//div[@i18n='"+tileName+"']")).click();
	}
	
	//wyb�r opcji na messageboxie
	public void clickMessageBoxButton(String option){
		System.out.println("Messagebox - wyb�r opcji: " + option);
		driver.findElement(By.xpath("//div[@id='esmMessageBox-main-container']//div[text()='"+option+"']")).click();
	}

	
	//wyszukanie frazy w wyszukiwarce na pasku nawigacyjnym
	public void searchOnList(String searchText){
		System.out.println("Wyszukanie obiektu: Filtr");
		WebElement searcher = driver.findElement(By.xpath("//div[@class='esmAppBar-search-input']//input[@placeholder='Szukaj']"));
		System.out.println("Czyszczenie obiektu: Filtr");
		searcher.click();
		searcher.clear();
		System.out.println("Wyszukanie frazy: " + searchText);
		searcher.sendKeys(searchText);
	}
	
	//wyczyszczenie wyszukiwarki
	public void clearSearchbox(){
		System.out.println("Czyszczenie obiektu: Filtr");
		WebElement searcher = driver.findElement(By.xpath("//div[@class='esmAppBar-search-input']//input[@placeholder='Szukaj']"));
		searcher.clear();
	}
	
	//dodanie elementu do tabeli
	public void addElementToTable(){
		System.out.println("Dodanie nowego obiektu do tabeli");
		WebElement addButton = driver.findElement(By.xpath("//div[contains(@class,'esmTableView-add-icon')]"));
		addButton.click();
	}
	
	//zalogowanie si� do aplikacji
	public void loginApp(String login, String password){
		System.out.println("Wyb�r j�zyka");
		driver.findElement(By.xpath("//*[@id='lang-links-panel']/div[1]/a/div")).click(); //wyb�r j�zyka:polski
		
		System.out.println("Pr�ba zalogowania na u�ytkownika: " + login + " / " + password );
		WebElement logname = getElement("UserName", "id");
		logname.clear();
		logname.sendKeys(login);
				
		WebElement passwd = getElement("Password", "id");
		passwd.clear();
		passwd.sendKeys(password);
		
		System.out.println("Klikni�cie zaloguj");
		driver.findElement(By.xpath("//*[@id='form']//input[@type='submit']")).click(); 
	}
	
	//pobranie bie��cej daty
	public String getDate (){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String result = dateFormat.format(date);
		System.out.println(result);
		return result;
	}
	
	//wyszukanie elementu na li�cie s�ownikowej
	public void findElementOnList(String DictionariesValue) throws InterruptedException {
		WebElement dicElement;
		System.out.println("Klikni�cie: " + DictionariesValue);
		dicElement = getElement("//span[text()='"+DictionariesValue+"']", "xpath");
		dicElement.click();
		Thread.sleep(1500);
	}
	
	//usuni�cie elementu z listy s�ownikowej
	public WebElement clearElementOnList(String DictionariesValue) {
		WebElement dicElement;
		System.out.println("Wyczyszczenie starej warto�ci");
		dicElement = getElement("//span[text()='"+DictionariesValue+"']//following-sibling::textarea", "xpath");
		dicElement.clear();
		return dicElement;
	}
	
	//zmiana warto�ci elementu s�ownikowego na li�cie
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




}
