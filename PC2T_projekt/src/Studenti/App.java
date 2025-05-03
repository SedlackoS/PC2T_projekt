package Studenti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class App {
	
	public static Map<Integer, Student> studentiDat = new HashMap<Integer, Student>();
	
	public static void main(String[] args) throws IOException, SQLException {
		StudentServices.fillMap();

		DBRead.readStudents(studentiDat);
		StudentServices.loadCounter();
		
		LocalDate today = LocalDate.now();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Vitajte v univerzitnom informačnom systéme!");
		System.out.println("Dnes je " + today);
		System.out.println("Pre pokračovanie stlačte Enter");
		sc.nextLine();
		
		String localPath = System.getProperty("user.dir");
		
		while(true) {
			System.out.println("Informačný systém Univerzity\n -> Dnes je: " + today);
			System.out.println("\nVyberte z nasledujúcich možností!");
			System.out.println("1. Zápis študenta do databáze");
			System.out.println("2. Pridanie známky študentovi");
			System.out.println("3. Prepustenie študenta");
			System.out.println("4. Výpis študenta");
			System.out.println("5. Spustiť znalosť u študenta");
			System.out.println("6. Abecedne radený výpis skupín");
			System.out.println("7. Aritmetický priemer u skupín");
			System.out.println("8. Počet študentov u jednotlivých skupín");
			System.out.println("9. Zápis do súboru");
			System.out.println("10. Načítanie zo súboru");
			System.out.println("11. Uložiť do databáze a Ukončiť program!");
			switch(sc.nextInt()) {
				case(1):
					StudentServices.AddStudentToDat(studentiDat);
					break;
				case(2):
					StudentServices.AddMarkForStudent(studentiDat);
					break;
				case(3):
					StudentServices.DeleteStudent(studentiDat);
					break;
				case(4):
					StudentServices.getInformation(studentiDat);
					break;
				case(5):
					StudentServices.runConvert(studentiDat);
					break;
				case(6):
					StudentServices.surnameFilter(studentiDat);
					break;
				case(7):
					StudentServices.arithmeticalAverage(studentiDat);
					break;
				case(8):
					StudentServices.returnGroups(studentiDat);
					break;
				case(9):
					StudentServices.writeToFile(studentiDat);
					break;
				case(10):
					StudentServices.readFromFile(studentiDat);
					break;
				case(11):
					StudentServices.writeUsersToDB(studentiDat);
					StudentServices.saveCounter();
					System.exit(0);
					break;
				default:
					System.out.println("Zadajte prosím platnú voľbu!");
					break;
				}
			}
		}
	}
