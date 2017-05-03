
public class StringMethods {

	public static void main(java.lang.String[] args) {
		// TODO Auto-generated method stub

		String str = "To jest testowy string";
		String str1 = "To jest testowy string";
		String str2 = "  To jest testowy strong    ";
		
		System.out.println("dlugosc ci�gu" + str.length());  //dlugosc stringa
		System.out.println("�ma litera ci�gu to: " +str.charAt(8)); //zwraca znak o danym indeksie (numerze)
		System.out.println("suma ci�g�w:" + str.concat(" To jest inny string")); // ��czy stringi
		System.out.println("Czy zawiera:" + str.contains("jest")); //true, czy zawiera ci�g
		System.out.println("Czy zawiera:" + str.contains("Jest")); //zwr�ci false
		System.out.println("Czy zaczyna si� od: <To>"+str.startsWith("To")); //sptawdza pocz�tek
		System.out.println("Czy ko�czy si� na: "+str.endsWith("strong")); //sprawdza koniec
		System.out.println("Czy r�wne: "+str.equals(str1)); // por�wnuje 2 obiekty
		System.out.println("Czy r�wne: "+str.equals(str2));
		
		System.out.println("Kt�re miejsce ma znak 'e': "+str.indexOf("e")); //miejsce znaku, je�li nie ma zwraca -1
		System.out.println("Czy ci�g jest pusty: "+str.isEmpty()); // czy jest pusty
		
		System.out.println("Zamie� t na x " +str.replace("t", "x")); //zamienia znaki t->x
		System.out.println("Przytnij string ze spacji "+ str2.trim()); //trymuje
		
		System.out.println("Przytnij string: " + str.substring(1, 13)); //wyci�ga podci�g
		System.out.println("Przytnij string tylko z poczatku: " + str.substring(6)); //tnie tylko z poczatku
	
		char[] charArray = str.toCharArray();
		for (int i = 0; i<charArray.length; i++  )
		{
		System.out.println("Indeks " + i + " to " +charArray[i]);
		}
		
		System.out.println(str.toLowerCase());  // knwersja na ma�e
		System.out.println(str.toUpperCase());  //konwersja na duze litery
		
		//String a = new String("valkue");
	}

}
