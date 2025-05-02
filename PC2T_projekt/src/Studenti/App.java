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
		/*StudentIBE std1 = new StudentIBE(222222,"John", "Doe", 29, 2, 2004, 1.2f);
		StudentTLI std2 = new StudentTLI(555555, "Sam", "Samsky", 25, 8, 2001, 3.4f);

		try {
			studentiDat.put(2222, std1);
			studentiDat.put(5555, std2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(std1.convertTo());
		System.out.println(std2.convertTo());
		System.out.println(studentiDat.size());
		System.out.println(studentiDat.get(2222).ID);
		
		
		for (int i = 0; i<std1.index.size(); i++) {
			System.out.println(std1.index.get(i));
		}*/
		
		
		LocalDate today = LocalDate.now();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Vitajte v univerzitnom informacnom systeme!");
		System.out.println("Dnes je " + today);
		System.out.println("Pre pokračovanie stlacte Enter");
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
					break;
				case(12):
					DBRead.readStudents(studentiDat);
					break;
				default:
					System.out.println("Zadajte prosím platnú voľbu!");
					break;
				}
			}
		}
	}
