
public class Car {
	private String make;
	int speed;
	int gear;
	public Car () {
		//non argument constructor
	this.speed=0;
	this.gear=0;
	System.out.println("Executing cunstructor without arguments");
	
	}
	
	public Car (int speed, int gear){
		this.speed = speed;
		this.gear = gear;
		System.out.println("Executing contructor with arguments");		
	}
	
	//"this" odnosi siê do obiektu klasy
	public void setMake (String make) {
		this.make = make;
	}
	
	public String getMake() {
		return make;
	}
}
