package Studenti;

import java.util.ArrayList;

abstract public class Student {
	protected int ID;
	protected String name;
	protected String surname;
	protected int day, month, year;
	protected Float priemer;
	
	protected ArrayList<Integer> index = new ArrayList<Integer>();

	abstract public String convertTo();
	
	abstract public void insertMark(int addedMark);
	}
	
	
	
	
	

