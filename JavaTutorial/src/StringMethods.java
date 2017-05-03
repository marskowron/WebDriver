
public class StringMethods {

	public static void main(java.lang.String[] args) {
		// TODO Auto-generated method stub

		String str = "To jest testowy string";
		String str1 = "To jest testowy string";
		String str2 = "  To jest testowy strong    ";
		
		System.out.println("dlugosc ci¹gu" + str.length());  //dlugosc stringa
		System.out.println("óœma litera ci¹gu to: " +str.charAt(8)); //zwraca znak o danym indeksie (numerze)
		System.out.println("suma ci¹gów:" + str.concat(" To jest inny string")); // ³¹czy stringi
		System.out.println("Czy zawiera:" + str.contains("jest")); //true, czy zawiera ci¹g
		System.out.println("Czy zawiera:" + str.contains("Jest")); //zwróci false
		System.out.println("Czy zaczyna siê od: <To>"+str.startsWith("To")); //sptawdza pocz¹tek
		System.out.println("Czy koñczy siê na: "+str.endsWith("strong")); //sprawdza koniec
		System.out.println("Czy równe: "+str.equals(str1)); // porównuje 2 obiekty
		System.out.println("Czy równe: "+str.equals(str2));
		
		System.out.println("Które miejsce ma znak 'e': "+str.indexOf("e")); //miejsce znaku, jeœli nie ma zwraca -1
		System.out.println("Czy ci¹g jest pusty: "+str.isEmpty()); // czy jest pusty
		
		System.out.println("Zamieñ t na x " +str.replace("t", "x")); //zamienia znaki t->x
		System.out.println("Przytnij string ze spacji "+ str2.trim()); //trymuje
		
		System.out.println("Przytnij string: " + str.substring(1, 13)); //wyci¹ga podci¹g
		System.out.println("Przytnij string tylko z poczatku: " + str.substring(6)); //tnie tylko z poczatku
	
		char[] charArray = str.toCharArray();
		for (int i = 0; i<charArray.length; i++  )
		{
		System.out.println("Indeks " + i + " to " +charArray[i]);
		}
		
		System.out.println(str.toLowerCase());  // knwersja na ma³e
		System.out.println(str.toUpperCase());  //konwersja na duze litery
		
		//String a = new String("valkue");
	}

}
