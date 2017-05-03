
public class Conditional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int vol1 = 10;
		int vol2 = 20;
						
		
		boolean condition = vol1 == vol2;
		System.out.println(condition);
		
		if (vol1== vol2) {
			System.out.println("Yes, true");
		}
			else
			{
				System.out.println("Nope");
			}
		
		int score = 91;
		String grade;
	
			if (score > 90){
				grade = "A";
			}
			else if (score > 80) {
				grade = "B";
			}
			else {
				grade = "C";
			}
	
	System.out.println("Score is: " + score);
	System.out.println("Grade is: " + grade);
	}
}



