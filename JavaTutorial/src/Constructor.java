
public class Constructor {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			Car c1 = new Car();
						
			c1.setMake("BMW");
			System.out.println(c1.getMake());
			
			
			System.out.println(c1.speed);
			System.out.println(c1.gear);
			
			System.out.println("*************");
			Car c2 = new Car(210, 5);
			System.out.println(c2.speed);
			System.out.println(c2.gear);
		}

	

	}


