package Metody_Zaloha;

public class CheckDoB {

	public static boolean run(int day, int month, int year) {
		if (0 < month & month < 13) {
			switch(month) {
			case 2:
				if (0 < day & day < 30) {
					if (year % 4 == 0 & day < 30)
						return true;
					else if (day < 29) 
						return true;
					else
						return false;
					}
			default:
				if(month % 2 == 0 & day <= 31 & day > 0)
					return true;
				else if (day <= 30 & day > 0)
					return true;
				else
					return false;
			}
		}
		else
			return false;
	}
}
