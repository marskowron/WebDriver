package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactory {
	
	WebDriver driver;
	
	@FindBy(id ="header-history")
	WebElement headerHistory;
	
	@FindBy(id ="tab-flight-tab")
	WebElement flightTab;
	
	@FindBy(id ="flight-origin")
	WebElement origin;
	
	@FindBy(id ="flight-destination")
	WebElement destination;
	
	@FindBy(id ="flight-departing")
	WebElement departureDate;
	
	@FindBy(id ="flight-returning")
	WebElement returnDate;
	
	@FindBy(xpath="")
	WebElement test;
	
	public SearchPageFactory(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFlightsTab() {
		headerHistory.click();
		flightTab.click();
	}
	
	public void setOriginCity (String originCity) {
		origin.sendKeys(originCity);
	}
	
	public void setDestinationCity (String destCity) {
		destination.sendKeys(destCity);
	}
	
	public void setDepDate (String DepDate) {
		departureDate.sendKeys(DepDate);
	}
	
	public void setRetDate (String RetDate) {
		returnDate.sendKeys(RetDate);
	}

}
