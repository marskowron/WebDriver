import java.util.Scanner;

public class test32my {

	//private static Scanner text;

	public static void main(String[] args) {

		Scanner text = new Scanner(System.in);
		System.out.println("Napisz jakieœ zdanie :)");
		String original = text.nextLine();
	
		while(original.isEmpty() || original == null)
		{
			System.out.println("Podaj prawid³owy string. Ci¹gi puste nie s¹ akceptowalne");
			original=text.nextLine();
		}
		text.close();
		System.out.println(reverseText(original).trim());		
	}

	public static String reverseText (String t)
	{
		String finalString = "";
		int iloscSpacji = 0;
				
		for (char znak:t.toCharArray())
		{
			if (znak == ' ')
			{
					iloscSpacji++;
			}
		}

		int iloscWyrazow = iloscSpacji + 1;
		
		String [] reverseTable = new String [iloscWyrazow];
		
		for (int i=1; i<iloscWyrazow; i++)
		{
			int spacja = t.indexOf(' ');

			reverseTable[(iloscWyrazow-i)] = t.substring(0,spacja).concat(" ");
			t=t.substring(spacja);
			if (t.startsWith(" ") == true)
			{
			t=t.trim();
			}	
		}
		reverseTable[0] = t.concat(" ");
		
		for (int i=1; i<=iloscWyrazow; i++)
		{
			finalString = finalString.concat(reverseTable[i-1]); 
		}
		
		return finalString;
	}	
}
