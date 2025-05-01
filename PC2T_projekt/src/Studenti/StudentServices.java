package Studenti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class StudentServices {

	public static Map<String, String> morseCodeBook = new HashMap<String, String>();
	
	protected static int idCounter = 1;
	
	public static boolean CheckDoB(int day, int month, int year) {
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
	
	
	public static void AddMarkForStudent(Map<Integer, Student> localMap) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Zadajte prosím ID Studenta: ");
		int tempID = sc.nextInt();
		
		int tempMark = 0;
		
		while(tempMark <= 0 || tempMark > 5){
			System.out.println("Zadajte prosím znamku: ");
			tempMark = sc.nextInt();
		
			if (tempMark <= 0 || tempMark > 5) {
				System.out.println("Zlý vstup! Skúste to znova!");
			}
		}
		
		try {
			localMap.get(tempID).insertMark(tempMark);
			
			float tempSum = 0;
			for(int i = 0; i<localMap.get(tempID).index.size(); i++) {
				tempSum += localMap.get(tempID).index.get(i);
			}
			
			localMap.get(tempID).priemer = tempSum/(float)localMap.get(tempID).index.size();
			
			System.out.println("Známka úspešne zapísaná! \nStudent: " + tempID + " známka: " + tempMark);
			System.out.println("Pre pokracovanie stlacte enter!");
			sc.nextLine();
			sc.nextLine();
		}
		catch(NullPointerException e) {
			System.out.println("Študent s ID: " + tempID + " neexistuje!");
			System.out.println("Pre pokračovanie stlačte Enter!");
			sc.nextLine();
			sc.nextLine();
		}
		
	}
	
	public static void AddStudentToDat(Map<Integer, Student> localMap) {
		
		String tempObor = "";
		String tempName = "";
		String tempSurname = "";
		int[] DoB = new int[3];
		int tempID = 0;
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Upozornenie!");
		System.out.println("Po vytvorení študenta nie je možné zmeniť jeho obor!");
		System.out.println("Pre pokračovanie stlačte Enter");
		sc.nextLine();
		
		while(tempObor == "") {
			System.out.println("Vyberte obor:");
			System.out.println("a - Telekomunikace (TLI)");
			System.out.println("b - Informační bezpečnost (IBE)");
			switch(sc.nextLine()) {
				case "a": {
					System.out.println("Vybrali ste -> Telekomunikace (TLI)");
					tempObor = "TLI";
					break;
					
				}
				case "b": {
					System.out.println("Vybrali ste -> Informační bezpečnost (IBE)");
					tempObor = "IBE";
					break;
				}
				default:
					System.out.println("Neznámy vstup! Zadajte požadovaný parameter!");
					break;
			}
		}
		System.out.println("Zadajte meno:");
		tempName = sc.nextLine();
		System.out.println("Zadajte priezvisko:");
		tempSurname = sc.nextLine();
		
		boolean checkDate = false;
		
		while(checkDate == false) {
			System.out.println("Zadajte deň narodenia:");
			DoB[0] = sc.nextInt();
			System.out.println("Zadajte mesiac narodenia:");
			DoB[1] = sc.nextInt();
			System.out.println("Zadajte rok narodenia:");
			DoB[2] = sc.nextInt();
			if (CheckDoB(DoB[0], DoB[1], DoB[2]) == false) {
				System.out.print("Váš vstup je neplatný! Zadajte ho znova!\n");
			}
			else
				break;
		}

		tempID = idCounter;
		
		System.out.println("Študentovi bude priradene ID: " + tempID);
		
		if (tempObor == "TLI") {
			Studenti.StudentTLI tempStudent = new Studenti.StudentTLI(tempID, tempName, tempSurname, DoB[0], DoB[1], DoB[2], 0f);
			localMap.put(tempID, tempStudent);
		}
		else {
			Studenti.StudentIBE tempStudent = new Studenti.StudentIBE(tempID, tempName, tempSurname, DoB[0], DoB[1], DoB[2], 0f);
			localMap.put(tempID, tempStudent);
		}
		
		System.out.println("Študent bol úspešne vytvorený! \n");
		System.out.println("ID: " + tempID);
		System.out.println("Meno: " + tempName);
		System.out.println("Priezvisko: " + tempSurname);
		System.out.println("Datum narodenia: " + DoB[0] + "." + DoB[1] + "." + DoB[2]);
		System.out.println("Obor: " + tempObor);
	
		
		System.out.println("Pre pokračovanie stlačte enter!");
		sc.nextLine();
		sc.nextLine();
	}

	public static void DeleteStudent(Map<Integer, Student> localMap) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Zadajte ID studenta: ");
		
		int tempID = sc.nextInt();
		
		System.out.println("Chystáte sa vymazať študenta: " + tempID);
		System.out.println("Prajete si pokračovat?\n1 - áno\n2 - nie");
		
		switch(sc.nextInt()) {
			case(1):
				Student ret = localMap.remove(tempID);
				if (ret != null) {
					System.out.println("Student bol uspesne prepusteny!");
					System.out.println("Pre pokracovanie stlacte enter!");
					sc.nextLine();
					sc.nextLine();
				}
				else {
					System.out.println("Študent sa nenachádza v databázi!");
					System.out.println("Pre pokračovanie stlačte enter!");
					sc.nextLine();
					sc.nextLine();
				}
				break;
			case(2):
				System.out.println("Operácia zrušena!");
				System.out.println("Pre pokračovanie stlačte enter!");
				sc.nextLine();
				sc.nextLine();
				break;
			default:
				System.out.println("Neplatný vstup! Ruším operáciu!");
				System.out.println("Pre pokračovanie stlačte enter!");
				sc.nextLine();
				sc.nextLine();
				break;
		}
	}
	
	public static void fillMap() {
		morseCodeBook.put("a", ".-");
		morseCodeBook.put("b", "-...");
		morseCodeBook.put("c", "-.-.");
		morseCodeBook.put("d", "-..");
		morseCodeBook.put("e", ".");
		morseCodeBook.put("f", "..-.");
		morseCodeBook.put("g", "--.");
		morseCodeBook.put("h", "....");
		morseCodeBook.put("i", "..");
		morseCodeBook.put("j", ".---");
		morseCodeBook.put("k", "-.-");
		morseCodeBook.put("l", ".-..");
		morseCodeBook.put("m", "--");
		morseCodeBook.put("n", "-.");
		morseCodeBook.put("o", "---");
		morseCodeBook.put("p", ".--.");
		morseCodeBook.put("q", "--.-");
		morseCodeBook.put("r", ".-.");
		morseCodeBook.put("s", "...");
		morseCodeBook.put("t", "-");
		morseCodeBook.put("u", "..-");
		morseCodeBook.put("v", "...-");
		morseCodeBook.put("w", ".--");
		morseCodeBook.put("x", "-..-");
		morseCodeBook.put("y", "-.--");
		morseCodeBook.put("z", "--..");
	}
	
	public static void getInformation(Map<Integer, Student> localMap) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Zadajte ID študenta: ");
		int tempID = sc.nextInt();
		
		if (localMap.get(tempID) != null) {
			
			/*float tempSum = 0;
			for(int i = 0; i<localMap.get(tempID).index.size(); i++) {
				tempSum += localMap.get(tempID).index.get(i);
			}
			
			float prumer = tempSum/(float)localMap.get(tempID).index.size();*/
			
			System.out.println("ID: " + localMap.get(tempID).ID);
			System.out.println("Meno: " + localMap.get(tempID).name);
			System.out.println("Priezvisko: " + localMap.get(tempID).surname);
			System.out.println("Datum narodenia: " + localMap.get(tempID).day + "." + localMap.get(tempID).month + "." + localMap.get(tempID).year);
			System.out.println("Priemer: " + localMap.get(tempID).priemer);
			System.out.println("Pre pokračovanie stlačte enter!");
			sc.nextLine();
			sc.nextLine();
		}
		else {
			System.out.println("Tento študent neexistuje!");
			System.out.println("Pre pokračovanie stlačte enter!");
			sc.nextLine();
			sc.nextLine();
		}
		
	}
	
	public static void runConvert(Map<Integer, Student> localMap) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Zadajte ID študenta: ");
		int tempID = sc.nextInt();
		
		if (localMap.get(tempID) != null) {
			System.out.println("Výpis dovednosti: " + localMap.get(tempID).convertTo());
			System.out.println("Pre pokračovanie stlačte Enter!");
			sc.nextLine();
			sc.nextLine();
		}
		else {
			System.out.println("Tento študent neexistuje!");
			System.out.println("Pre pokračovanie stlačte Enter!");
			sc.nextLine();
			sc.nextLine();
		}
	}
	public static void surnameFilter(Map<Integer, Student> localMap){
		
		List<StudentTLI> tliList = new ArrayList<>();
		List<StudentIBE> ibeList = new ArrayList<>();
		
		for(int tempID : localMap.keySet()) {
			if(localMap.get(tempID) instanceof StudentTLI) {
				tliList.add((StudentTLI) localMap.get(tempID));
			}
			else if(localMap.get(tempID) instanceof StudentIBE) {
				ibeList.add((StudentIBE) localMap.get(tempID));
			}
		}
		
		tliList.sort(Comparator.comparing(stli -> stli.surname));
		ibeList.sort(Comparator.comparing(sibe -> sibe.surname));
		
		
		System.out.println("Výpis pre skupinu TLI:");
		if (!tliList.isEmpty()){
			for (Student s : tliList) {
				System.out.println("");
				System.out.println("Vypis pre priezvisko: " + s.surname);
				System.out.println("--------------------");
				System.out.println("ID: " + s.ID);
				System.out.println("Meno: " + s.name);
				System.out.println("Priezvisko: " + s.surname);
				System.out.println("Dátum narodenia: " + s.day + "." + s.month + "." + s.year);
				System.out.println("Priemer: " + s.priemer);
				System.out.println("--------------------");
				System.out.println("");
			}
		}
		else {
			System.out.println("Skupina TLI je prázdna!");
		}
			System.out.println("Výpis pre skupinu IBE:");
		if (!ibeList.isEmpty()) {
			for (Student s : ibeList) {
				/*float tempSum = 0;
					for(int i = 0; i<s.index.size(); i++) {
						tempSum += s.index.get(i);
				}
				
				float priemer = tempSum/(float)s.index.size();*/
				System.out.println("");
				System.out.println("Výpis pre priezvisko: " + s.surname);
				System.out.println("--------------------");
				System.out.println("ID: " + s.ID);
				System.out.println("Meno: " + s.name);
				System.out.println("Priezvisko: " + s.surname);
				System.out.println("Dátum narodenia: " + s.day + "." + s.month + "." + s.year);
				System.out.println("Priemer: " + s.priemer);
				System.out.println("--------------------");
				System.out.println("");
			}
		}
		else {
			System.out.println("Skupina IBE je prázdna!");
		}
		
	}
	

	public static void arithmeticalAverage (Map<Integer, Student> localMap){
		Scanner sc = new Scanner(System.in);
		int tempIBESUM = 0;
		int tempTLISUM = 0;
		int tempIBECOUNT = 0;
		int tempTLICOUNT = 0;
		Float averageTLI;
		Float averageIBE;
		
		
		for (int tempID : localMap.keySet()) {
			if(localMap.get(tempID) instanceof StudentIBE) {
				for(int i = 0; i<localMap.get(tempID).index.size(); i++) {
					tempIBESUM += localMap.get(tempID).index.get(i);
					tempIBECOUNT += 1;
					
				}
			}
			else if (localMap.get(tempID) instanceof StudentTLI){
				for(int i = 0; i<localMap.get(tempID).index.size(); i++) {
					tempTLISUM += localMap.get(tempID).index.get(i);
					tempTLICOUNT += 1;
				}
			}
		}
		averageTLI = (float)tempTLISUM/(float)tempTLICOUNT;
		averageIBE = (float)tempIBESUM/(float)tempIBECOUNT;
		
		if(!averageTLI.isNaN()) {
			System.out.println("Pre skupinu Telekomunikace je priemer: " + averageTLI);
		}
		else {
			System.out.println("Študenti TLI nemajú zapísané žiadne známky");
			}
		if(!averageIBE.isNaN()) {
			System.out.println("Pro skupinu Informacni bezpecnost je prumer: " + averageIBE);
		}
		else {
			System.out.println("Študenti IBE nemajú zapísané žiadne známky");
		}
		System.out.println("Pre pokračovanie stlačte Enter!");
		sc.nextLine();
		sc.nextLine();
	}
		
	
	public static void returnGroups(Map<Integer, Student> localMap) {
		Scanner sc = new Scanner(System.in);
		int tempIBECOUNT = 0;
		int tempTLICOUNT = 0;
		
		for (int tempID : localMap.keySet()) {
			if(localMap.get(tempID) instanceof StudentIBE) {
				tempIBECOUNT += 1;
			}
			else if(localMap.get(tempID) instanceof StudentTLI) {
				tempTLICOUNT += 1;
			}
			else {
				System.out.println("Chyba!");
			}
		}
		System.out.println("Pre skupinu Telekomunikace počet študentov je: " + tempTLICOUNT);
		System.out.println("Pre skupinu Informační bezpečnost počet študentov je: " + tempIBECOUNT);
		System.out.println("Pre pokračovanie stlačte enter!");
		sc.nextLine();
		sc.nextLine();
		
	} 
	
	public static void writeToFile(Map<Integer, Student> localMap) throws IOException {
		String localPath = System.getProperty("user.dir");
		Scanner sc = new Scanner(System.in);
		File localFile;
		FileWriter fw; 
		BufferedWriter bw;
		
		System.out.println("Zadejte ID študenta:");
		
		int tempID = sc.nextInt();
		
		if (localMap.get(tempID) != null) {
			LocalDateTime now = LocalDateTime.now();
			try {
			String editedNow = now.toString();
			editedNow = editedNow.substring(0, editedNow.indexOf(".")).replace("-", "_").replace(":", "_");
			localFile = new File(localPath +"\\"+ tempID + "_" + editedNow + ".txt");
			if(localFile.createNewFile()) {
				fw = new FileWriter(localFile);
				bw = new BufferedWriter(fw);
		        bw.write("ID: " + localMap.get(tempID).ID + "\n");
		        bw.write("Meno: " + localMap.get(tempID).name + "\n"); 
				bw.write("Priezvisko: " + localMap.get(tempID).surname + "\n");
				bw.write("DN: " + localMap.get(tempID).day + "." + localMap.get(tempID).month + "." + localMap.get(tempID).year + "\n");
				if(localMap.get(tempID) instanceof StudentTLI) {
					bw.write("Obor: TLI\n");
				}
				else if(localMap.get(tempID) instanceof StudentIBE) {
					bw.write("Obor: IBE\n");
				}

				bw.write("Priemer: " + localMap.get(tempID).priemer + "\n");
				bw.write("Známky: " + localMap.get(tempID).index);
				bw.close();
				fw.close();
		        System.out.println("Súbor bol vytvorený!");
				System.out.println("Pre pokračovanie stlačte enter!");
				sc.nextLine();
				sc.nextLine();
				}
			else{
				System.out.println("Súbor už existuje!");
				System.out.println("Pre pokračovanie stlačte enter!");
				sc.nextLine();
				sc.nextLine();
				}
			}
			catch(IOException e) {
				System.out.println("Nemožno zapísať! Skontrolujte práva na zápis!");
				e.printStackTrace();
				System.out.println("Pre pokračovanie stlačte enter!");
				sc.nextLine();
				sc.nextLine();
			}
}
		else {
			System.out.println("Študent neexistuje!");
			System.out.println("Pre pokračovanie stlačte enter!");
			sc.nextLine();
			sc.nextLine();
		}
		
	}
	public static void readFromFile(Map<Integer, Student> localMap) throws IOException{
		String localPath = System.getProperty("user.dir");
		Scanner sc = new Scanner(System.in);
		File localFile;
		FileReader fr; 
		BufferedReader br;
		
		System.out.println("Zadajte nazev souboru:");
	
		String tempFileName = sc.nextLine();
		try {
			localFile = new File(localPath + "\\" + tempFileName + ".txt");
			fr = new FileReader(localFile);
			br = new BufferedReader(fr);
			if(localFile.exists()) {
				String ID = br.readLine().substring(4).trim();
		        String Name = br.readLine().substring(6).trim();
		        String Surname = br.readLine().substring(11).trim();
		        String DoB = br.readLine();
		        String Obor = br.readLine().substring(5).trim();
		        String Priemer = br.readLine().substring(8).trim();
		        Float floatPriemer = Float.parseFloat(Priemer);
		        String[] Znamky = br.readLine().substring(7).trim().replace("[", "").replace("]", "").split(", ");
		        System.out.println(ID);
		        System.out.println(Znamky[0] + " " + Znamky[1]);
		        System.out.println(floatPriemer);
		        br.close();
		        fr.close();
		        }
			else{
				System.out.println("Soubor neexistuje!");
				}
			}
			catch(IOException e) {
				System.out.println("Nelze cist!");
				e.printStackTrace();
			}
		
	}
	
	
}
