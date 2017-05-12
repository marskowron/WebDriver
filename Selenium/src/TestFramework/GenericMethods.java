package TestFramework;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericMethods {
	
	WebDriver driver;
	
	public GenericMethods(WebDriver driver){
		this.driver = driver;
	}

	public WebElement getElement(String locator, String type)
	{
		type = type.toLowerCase();
		
		if(type.equals("id")) {
			System.out.println("Element found by id: " + locator);
			return this.driver.findElement(By.id(locator));
		}
		else if (type.equals("xpath")){
			System.out.println("Element found by xpath: " + locator);
			return this.driver.findElement(By.xpath(locator));	
		}
		else if (type.equals("css")){
			System.out.println("Element found by CSS selector: " + locator);
			return this.driver.findElement(By.cssSelector(locator));
		}
		else if (type.equals("link")){
			System.out.println("Element found by LinkText: " + locator);
			return this.driver.findElement(By.linkText(locator));
		}
		else if (type.equals("partial link")){
			System.out.println("Element found by Partial LinkText: " + locator);
			return this.driver.findElement(By.partialLinkText(locator));
		}
		else if (type.equals("name")){
			System.out.println("Element found by name: " + locator);
			return this.driver.findElement(By.name(locator));
		}
		else if (type.equals("tag")){
			System.out.println("Element found by tag: " + locator);
			return this.driver.findElement(By.tagName(locator));
		}
		else if (type.equals("class")){
			System.out.println("Element found by Class Name: " + locator);
			return this.driver.findElement(By.className(locator));
		}
		else {
			System.out.println("Locator type not supported");
			return null;
		}
	}
	
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

	public boolean isElementPresent(String locator, String type){
		List<WebElement> elementList = getElementList(locator, type);
		
		if (elementList.size()>0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void saveClickAB(){
		driver.findElement(By.xpath("//div[@title='Zapisz']")).click();
			}
	
	public void openMenu(String menuName){
		String searchMenu = menuName;
		System.out.println("Przejœcie do menu: " + searchMenu);
		driver.findElement(By.xpath("//a[@title='"+searchMenu+"']")).click();
	}
	
	public void clickConfigurationTile(String tileName){
		String searchTile = tileName;
		System.out.println("Klikniêcie w menu: " + searchTile);
		driver.findElement(By.xpath("//p[text()='"+searchTile+"']")).click();
	}
	
	public void clickTileByi18(String tileName){
		String searchTile = tileName;
		System.out.println("Klikniêcie w kafel: " + searchTile);
		driver.findElement(By.xpath("//div[@i18n='"+searchTile+"']")).click();
	}
	
	public void searchOnList(String searchText){
		System.out.println("Wyszukanie obiektu: Filtr");
		String search = searchText;
		System.out.println("Wyszukanie frazy: " + search);
		WebElement searcher = driver.findElement(By.xpath("//div[@class='esmAppBar-search-input']//input[@placeholder='Szukaj']"));
		searcher.click();
		searcher.sendKeys(search);
	}
	
	public void loginApp(String login, String password){
		System.out.println("Wybór jêzyka");
		driver.findElement(By.xpath("//*[@id='lang-links-panel']/div[1]/a/div")).click();
		
		System.out.println("Próba zalogowania na u¿ytkownika: " + login + " / " + password );
		WebElement logname = getElement("UserName", "id");
		logname.clear();
		logname.sendKeys(login);
				
		WebElement passwd = getElement("Password", "id");
		passwd.clear();
		passwd.sendKeys(password);
		
		System.out.println("Klikniêcie zaloguj");
		driver.findElement(By.xpath("//*[@id='form']//input[@type='submit']")).click();
	}
}
