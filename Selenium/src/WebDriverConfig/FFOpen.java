package WebDriverConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FFOpen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver; // typ i nazwa
		System.setProperty("webdriver.gecko.driver", "E:\\workspace\\selenium-java-3.4.0\\geckodriver.exe");  //namiary na gecko driver ; wielkoœc liter ma znaczenie! 
		//inne dla ka¿dej lokalizacji
		driver = new FirefoxDriver(); //nowa instacja
		String baseURL = "http://wp.pl";  //bazowy url odpalanej strony
		
		driver.get(baseURL);  //metoda do otwarcia dowolnej strony
	}

}
