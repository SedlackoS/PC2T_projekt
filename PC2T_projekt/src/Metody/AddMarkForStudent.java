package Metody;

import java.util.Map;
import java.util.Scanner;
import java.io.*;

import Studenti.Student;

public class AddMarkForStudent {

	public static void run(Map<Integer, Student> localMap) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Zadajte prosim ID Studenta: ");
		int tempID = sc.nextInt();
		
		int tempMark = 0;
		
		while(tempMark <= 0 || tempMark > 5){
			System.out.println("Zadajte prosim znamku: ");
			tempMark = sc.nextInt();
		
			if (tempMark <= 0 || tempMark > 5) {
				System.out.println("Zly vstup! Skuste to znova!");
			}
		}
		
		try {
			localMap.get(tempID).insertMark(tempMark);
			System.out.println("Znamka uspesne zapsana! \nStudent: " + tempID + " znamka: " + tempMark);
			System.out.println("Pre pokracovanie stlacte enter!");
			sc.nextLine();
			sc.nextLine();
		}
		catch(NullPointerException e) {
			System.out.println("Student s ID: " + tempID + " neexistuje!");
			System.out.println("Pre pokracovanie stlacte enter!");
			sc.nextLine();
			sc.nextLine();
		}
		
	}
}

