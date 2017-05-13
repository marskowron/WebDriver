package TestFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalendarMethods {
	
WebDriver driver;
	
	public CalendarMethods(WebDriver driver){
		this.driver=driver;
		
	}
	
	//przej�cie w kalendarzu do wybranej p�niejszej daty w kalendarzu (dzia�ania)
	public void moveToFutherDate(String year, String month, String day) {
		System.out.println("Przej�cie do daty: " + day + "/" + month + "/" + year);
		openCalendar();
		WebElement element = driver.findElement(By.xpath("//div[@id='mainAdp']//div[contains(@class,'esmAdp-title') and contains(@class,'ng-binding')]"));
		WebElement moveForward = driver.findElement(By.xpath("//div[@id='mainAdp']//div[contains(@class,'esmAdp-next-month-icon')]"));
		String currentMonth = element.getText();
		String [] currentDate = new String [2];
		currentDate = currentMonth.split(" ");
		month=month.toLowerCase();
		
		while (month.equals(currentDate[0])==false || year.equals(currentDate[1])==false){
			System.out.println(currentDate[0]);
			System.out.println(month);
			System.out.println(month.equals(currentDate[0]));
			moveForward.click();	
			currentMonth = element.getText();
			currentDate = currentMonth.split(" ");
		}
		clickOnDay(day);
	}
	
	//klikni�cie wybranego dnia na kalendarzu
	public void clickOnDay(String day) {
		System.out.println("Wyb�r dnia: " + day);
		WebElement newDay = driver.findElement(By.xpath("//div[@id='mainAdp']//div[contains(text(),'"+day+"')]"));
		newDay.click();
	}
	
	//przej�cie do nast�pnego miesi�ca
	public void moveToNextMonth() {
		System.out.println("Przej�cie do nast�pengo miesi�ca w kalendarzu");
		WebElement moveForward = driver.findElement(By.xpath("//div[@id='mainAdp']//div[contains(@class,'esmAdp-next-month-icon')]"));
		moveForward.click();
	}

	//otwarcie kalendarza
	public void openCalendar() {
		System.out.println("Otwarcie kalendarza");
		driver.findElement(By.xpath("//div[@class='esmWeekCal-daysOfWeek-container']//col")).click();
	}
	
	//przej�cie w kalendarzu do wybranej poprzedniej daty w kalendarzu (dzia�an
	public void moveToPreviousDate(String year, String month, String day) {
		System.out.println("Przej�cie do daty: " + day + "/" + month + "/" + year);
		openCalendar();
		WebElement element = driver.findElement(By.xpath("//div[@id='mainAdp']//div[contains(@class,'esmAdp-title') and contains(@class,'ng-binding')]"));
		WebElement movePrevious = driver.findElement(By.xpath("//div[@id='mainAdp']//div[contains(@class,'esmAdp-prev-month-icon')]"));
		String currentMonth = element.getText();
		String [] currentDate = new String [2];
		currentDate = currentMonth.split(" ");
		month=month.toLowerCase();
		
		while (month.equals(currentDate[0])==false || year.equals(currentDate[1])==false){
			System.out.println(currentDate[0]);
			System.out.println(month);
			System.out.println(month.equals(currentDate[0]));
			movePrevious.click();	
			currentMonth = element.getText();
			currentDate = currentMonth.split(" ");
		}
		clickOnDay(day);
	}
	
	//przej�cie do porzedniego miesi�ca w kalendarzu
	public void moveToPreviousMonth() {
		System.out.println("Przej�cie do poprzedniego miesi�ca");
		WebElement movePrevious = driver.findElement(By.xpath("//div[@id='mainAdp']//div[contains(@class,'esmAdp-prev-month-icon')]"));
		movePrevious.click();
	}
	
	//przej�cie do dzisiejszego dnia
	public void moveToToday() {
		System.out.println("Przej�cie do dzisiejszego dnia");
		openCalendar();
		WebElement today = driver.findElement(By.xpath("//div[@id='mainAdpToday']/div[@data-i18n='_Today_']"));
		today.click();
	}
}
