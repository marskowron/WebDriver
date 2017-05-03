package basicweb;

//import org.openqa.selenium.WebDriver;

public class FirtsTestClass {

	public static void main(String[] args) {
	
		String test = "T";
		boolean test1 = test.equals("T");
		System.out.println(test1);
		
		if(test.equals("T")==true && test.equals("N") == true)
		{
			System.out.println("prawda");
		}
		else
		{
			System.out.println("fa³sz");
		}

	}

}
