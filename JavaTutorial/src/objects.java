
public class objects {

	static String str2 = "Hi!!! Hello";
	
	public static void main(String[] args) {
		
		String str1 = "Hello World";
		System.out.println(str1);
		System.out.println(str2);
		
		for (int i=0; i < args.length; i++)
		{
			System.out.println(args [i]);
		}
			
		System.out.println("*********************************");
		
		CarClass c1 = new CarClass();
		CarClass c2 = new CarClass();
		
		c1.year = 2010;
		c1.model = "Ford mondeo";
		
		System.out.println(c1.year + c1.model + c2.year + c2.model);
		System.out.println(c1.getYear());
	}

}

class CarClass {
	
	int year = 2000;
	String model;
	
	public int getYear (){
		return this.year;
	}
	
}
