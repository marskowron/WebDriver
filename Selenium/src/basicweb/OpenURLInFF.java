package basicweb;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenURLInFF {

	public static void main(String[] args) {
		
		System.out.println("Podaj adres strony, kt�r� chcesz otworzy�:");

		Scanner text = new Scanner(System.in);
		String URL = text.nextLine();		
		
		while(URL.isEmpty() || URL == null || URL.contains(".") == false)
		{
			System.out.println("Nie podano strony lub wskazany adres jest niepoprawny. Wprowadz adres strony");
			URL = text.nextLine();
		}
		
		System.out.println("Adres strony to: " + URL);
		System.out.println("Czy po��czenie szyfrowane (T/N)?");
		
		Scanner text2 = new Scanner(System.in);
		String isSafe = text2.nextLine();
		
		while(isSafe.equals("T")==false && isSafe.equals("N")==false)
		{
			System.out.println("Nie podano warto�ci lub wprowadzona warto�� jest nieprawid�owa. Wpisz 'T' lub 'N'");
			isSafe = text.nextLine();
		}
		text.close();
		text2.close();
		
		if(isSafe.equals("T") == true && URL.contains("https")==false)
		{
			URL="https://"+URL;
		}
		else if (isSafe.equals("N") == true && URL.contains("http")==false)
		{
			URL="http://"+URL;
		}
		System.out.println("Chcesz otworzy� stron�: "  + URL);
		
		WebDriver driver; 
		System.setProperty("webdriver.gecko.driver", "E:\\workspace\\selenium-java-3.4.0\\geckodriver.exe");  
		driver = new FirefoxDriver(); 
		
		driver.get(URL);
		
	}

}
