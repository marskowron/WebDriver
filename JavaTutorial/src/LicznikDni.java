public class LicznikDni {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int dzien = 2;
		int miesiac = 5;
		int rok = 2017;
		System.out.println("Data obliczeñ: " + dzien +"-"+miesiac+"-"+rok );
		System.out.println("Liczba dni w szukanym miesi¹cu: " + getNOD(miesiac, rok));
		int NumberOfDays = getDays(dzien, miesiac, rok);
		System.out.println("Liczba dni:" + NumberOfDays);
		System.out.println("szukany dzieñ tygodnia: " + GetDayOfWeek(NumberOfDays));
	}	
	
	static int getDays(int dzien, int miesiac, int rok) {
		int days=0;
		
	
			for (int r = 2000; r<rok; r++){
				int n;
				if (r %4 == 0)
				{
					n=366;
				}
				else
				{
					n=365;
				}
				days = days+n;				
			}
			
			for (int m = 1; m<miesiac; m++){
				days = days + getNOD(m, rok);
			}
			
			days = days + (dzien-1);
		
		return days;
	}
		
	static int getNOD(int miesiac, int rok)	{
		int NOD=0;	
		
			
		switch (miesiac){
		case 1: 
			NOD = 31;
		break;
		case 2: 
			if (rok % 400 == 0){
			NOD = 29;	
			}
			else {
				NOD = 28;
			}
		break;
		case 3: 
			NOD = 31;
		break;
		case 4: 
			NOD = 30;
		break;
		case 5: 
			NOD = 31;
		break;
		case 6: 
			NOD = 30;
		break;
		case 7: 
			NOD = 31;
		break;
		case 8: 
			NOD = 31;
		break;
		case 9: 
			NOD = 30;
		break;
		case 10: 
			NOD = 31;
		break;
		case 11: 
			NOD = 30;
		break;
		case 12: 
			NOD = 31;
		break;
		default:
			System.out.println("Niepoprawnie wskazany miesi¹c");
		break;
		}
		return NOD;
		}
	
 public static String GetDayOfWeek (int NumberOfDays) {
	 String DayOfWeek = "Wskazano dzieñ poza odzwolonym zakresem (01-01-2000)";
	 
	 int i = NumberOfDays % 7;
	 switch (i) {
	 case 0:
		 DayOfWeek = "Sobota";
		 break;
	 case 1:
		 DayOfWeek = "Niedziela";
		 break;
	 case 2:
		 DayOfWeek = "Poniedzia³ek";
		 break;
	 case 3:
		 DayOfWeek = "Wtorek";
		 break;
	 case 4:
		 DayOfWeek = "Œroda";
		 break;
	 case 5:
		 DayOfWeek = "Czwartek";
		 break;
	 case 6:
		 DayOfWeek = "Pi¹tek";
		 break;
		 
	 }
	 return DayOfWeek;
 }
	
}
