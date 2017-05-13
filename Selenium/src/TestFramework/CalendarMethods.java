package TestFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalendarMethods {
	
WebDriver driver;
	
	public CalendarMethods(WebDriver driver){
		this.driver=driver;
		
	}
	
	//przejœcie w kalendarzu do wybranej pó¿niejszej daty w kalendarzu (dzia³ania)
	public void moveToFutherDate(String year, String month, String day) {
		System.out.println("Przejœcie do daty: " + day + "/" + month + "/" + year);
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
	
	//klikniêcie wybranego dnia na kalendarzu
	public void clickOnDay(String day) {
		System.out.println("Wybór dnia: " + day);
		WebElement newDay = driver.findElement(By.xpath("//div[@id='mainAdp']//div[contains(text(),'"+day+"')]"));
		newDay.click();
	}
	
	//przejœcie do nastêpnego miesi¹ca
	public void moveToNextMonth() {
		System.out.println("Przejœcie do nastêpengo miesi¹ca w kalendarzu");
		WebElement moveForward = driver.findElement(By.xpath("//div[@id='mainAdp']//div[contains(@class,'esmAdp-next-month-icon')]"));
		moveForward.click();
	}

	//otwarcie kalendarza
	public void openCalendar() {
		System.out.println("Otwarcie kalendarza");
		driver.findElement(By.xpath("//div[@class='esmWeekCal-daysOfWeek-container']//col")).click();
	}
	
	//przejœcie w kalendarzu do wybranej poprzedniej daty w kalendarzu (dzia³an
	public void moveToPreviousDate(String year, String month, String day) {
		System.out.println("Przejœcie do daty: " + day + "/" + month + "/" + year);
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
	
	//przejœcie do porzedniego miesi¹ca w kalendarzu
	public void moveToPreviousMonth() {
		System.out.println("Przejœcie do poprzedniego miesi¹ca");
		WebElement movePrevious = driver.findElement(By.xpath("//div[@id='mainAdp']//div[contains(@class,'esmAdp-prev-month-icon')]"));
		movePrevious.click();
	}
	
	//przejœcie do dzisiejszego dnia
	public void moveToToday() {
		System.out.println("Przejœcie do dzisiejszego dnia");
		openCalendar();
		WebElement today = driver.findElement(By.xpath("//div[@id='mainAdpToday']/div[@data-i18n='_Today_']"));
		today.click();
	}
}
