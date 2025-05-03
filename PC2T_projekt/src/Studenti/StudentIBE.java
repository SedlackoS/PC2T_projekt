package Studenti;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StudentIBE extends Student{
	

	public StudentIBE(int ID, String name, String surname, int day, int month, int year, Float priemer) {
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
	
	
	@Override
	public String convertTo() {
		try {
		String nameandsurname = this.name+this.surname;
		
		MessageDigest messdig = MessageDigest.getInstance("SHA-1");
		
		byte[] arrayMessDig = messdig.digest(nameandsurname.getBytes());
		
		BigInteger toBigInt = new BigInteger(1, arrayMessDig);
		
		String finalHash = toBigInt.toString(16);
		
		return finalHash;
		}
		
		catch(NoSuchAlgorithmException e) {
			return "Nastala chyba - neexistujuci algoritmus!";
		}}
	
	@Override	
	public void insertMark(int addedMark) {
			this.index.add(addedMark);
	}
	
	
	
}
