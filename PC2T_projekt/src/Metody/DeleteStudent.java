package Metody;

import java.util.Map;
import java.util.Scanner;

import Studenti.Student;

public class DeleteStudent {

	public static void run(Map<Integer, Student> localMap) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Zadajte ID studenta: ");
		
		int tempID = sc.nextInt();
		
		System.out.println("Chystate sa vymazat studenta: " + tempID);
		System.out.println("Prajete si pokracovat?\n1 - ano\n2 - nie");
		
		switch(sc.nextInt()) {
			case(1):
				localMap.remove(tempID);
				break;
			case(2):
				System.out.println("Operacia zrusena!");
				break;
			default:
				System.out.println("Neplatny vstup! Rusim operaciu!");
				break;
		}
		
		
	}
	
}
