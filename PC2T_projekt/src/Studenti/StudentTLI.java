package Studenti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Metody_Zaloha.MorseCodeMap;

import java.io.File;
import java.text.Normalizer;

public class StudentTLI extends Student{
	
	public StudentTLI(int ID, String name, String surname, int day, int month, int year, Float priemer) {
			this.ID = ID;
			this.name = name;
			this.surname = surname;
			this.day = day;
			this.month = month;
			this.year = year;
			this.priemer = priemer;
			StudentServices.idCounter++;
			}

	public int getID() {
		return this.ID;
	}
	public String getName() {
		return this.name;
	}
	public String getSurname() {
		return this.surname;
	}
	public int getDay() {
		return this.day;
	}
	public int getMonth() {
		return this.month;
	}
	public int getYear() {
		return this.year;
	}
	
	public String convertTo() {
		
		char nameArr[] = Normalizer.normalize(this.name.toLowerCase(), Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "").toCharArray();
		char surnameArr[] = Normalizer.normalize(this.surname.toLowerCase(), Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "").toCharArray();
		
		String nameToMorse = "";
		String surnameToMorse = "";
		
		
		for(char i : nameArr) {
			String localChar = Character.toString(i);
			nameToMorse += StudentServices.morseCodeBook.get(localChar) + " ";
		}
		for(char j : surnameArr) {
			String localChar = Character.toString(j);
			surnameToMorse += StudentServices.morseCodeBook.get(localChar) + " ";
		}
		
		return nameToMorse + " " + surnameToMorse;
		
		
	}
	
	@Override	
	public void insertMark(int addedMark) {
			this.index.add(addedMark);
		}
}
