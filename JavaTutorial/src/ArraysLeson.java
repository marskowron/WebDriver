import java.util.Arrays;

public class ArraysLeson {
	public static void main(String[] args) {
		
		int [] arrayint;
		
		arrayint = new int [10];
		
		arrayint[0] = 100;
		arrayint[1] = 90;
		
		System.out.println(arrayint[0]); //100
		System.out.println(arrayint[1]); //90
		System.out.println(arrayint[2]);
		
		
		String[] mystring = {
				"bmw", "audi" , "handa"
		};
		
		System.out.println(mystring[1]); //audi
		
		int len1 = arrayint.length;
		int len2 = mystring.length;
				
		System.out.println("wielkosc tablicy 1: " + len1);
		System.out.println("Wielkosc tablicy 2 " + len2);
		
		
		for (int i=0; i<len1; i++) {
			System.out.println(arrayint[i]);
		}
		Arrays.sort(arrayint); //sortuje tabele
		
		for (int i=0; i<len1; i++) {
			System.out.println(arrayint[i]);
		}
		
		//System.arraycopy(src, srcPos, dest, destPos, length); kopiowanie
		
	}
}
