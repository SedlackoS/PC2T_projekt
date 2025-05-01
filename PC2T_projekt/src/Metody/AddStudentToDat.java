package Metody;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import Studenti.Student;

public class AddStudentToDat {

	public static void run(Map<Integer, Student> localMap) {
		
		String tempObor = "";
		String tempName = "";
		String tempSurname = "";
		int[] DoB = new int[3];
		int tempID = 0;
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Upozornenie!");
		System.out.println("Po vytvoreni Studenta nie je mozne zmenit jeho obor!");
		System.out.println("Pre pokracovanie stlacte Enter");
		sc.nextLine();
		
		while(tempObor == "") {
			System.out.println("Vyberte obor:");
			System.out.println("a - Telekomunikace (TLI)");
			System.out.println("b - Informacni bezpecnost (IBE)");
			switch(sc.nextLine()) {
				case "a": {
					System.out.println("Vybrali ste -> Telekomunikace (TLI)");
					tempObor = "TLI";
					break;
					
				}
				case "b": {
					System.out.println("Vybrali ste -> Informacni bezpecnost (IBE)");
					tempObor = "IBE";
					break;
				}
				default:
					System.out.println("Neznamy vstup! Zadajte pozadovany parameter!");
					break;
			}
		}
		System.out.println("Zadajte meno:");
		tempName = sc.nextLine();
		System.out.println("Zadajte priezvisko:");
		tempSurname = sc.nextLine();
		
		boolean checkDate = false;
		
		while(checkDate == false) {
			System.out.println("Zadajte den narodenia:");
			DoB[0] = sc.nextInt();
			System.out.println("Zadajte mesiac narodenia:");
			DoB[1] = sc.nextInt();
			System.out.println("Zadajte rok narodenia:");
			DoB[2] = sc.nextInt();
			if (Metody.CheckDoB.run(DoB[0], DoB[1], DoB[2]) == false) {
				System.out.print("Vas vstup je neplatny! Zadajte ho znova!\n");
			}
			else
				break;
		}
		
		tempID = Studenti.App.studentiDat.size() + 1;
		
		System.out.println("Studentovi bude priradene ID: " + tempID);
		
		if (tempObor == "a") {
			Studenti.StudentTLI tempStudent = new Studenti.StudentTLI(tempID, tempName, tempSurname, DoB[0], DoB[1], DoB[2], 0f);
			localMap.put(tempID, tempStudent);
		}
		else {
			Studenti.StudentTLI tempStudent = new Studenti.StudentTLI(tempID, tempName, tempSurname, DoB[0], DoB[1], DoB[2], 0f);
			localMap.put(tempID, tempStudent);
		}
		
		System.out.println("Student bol uspesne vytvoreny! \n");
		System.out.println("ID: " + tempID);
		System.out.println("Meno: " + tempName);
		System.out.println("Priezvisko: " + tempSurname);
		System.out.println("Datum narodenia: " + DoB[0] + "." + DoB[1] + "." + DoB[2]);
		System.out.println("Obor: " + tempObor);
	
		
		System.out.println("Pre pokracovanie stlacte enter!");
		sc.nextLine();
		sc.nextLine();
		
	
		
	}
	
}
