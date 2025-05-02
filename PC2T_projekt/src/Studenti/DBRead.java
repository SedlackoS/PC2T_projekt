package Studenti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;


public class DBRead {

	  public DBRead() {}

	  public static void readStudents(Map<Integer, Student> localMap) {
		    Connection conn = DBConnect.getDBConnection();

		    String query = "SELECT ID, name, surname, day, month, year, obor, priemer, znamky FROM students";

		    try (PreparedStatement prStmt = conn.prepareStatement(query);
		         ResultSet rs = prStmt.executeQuery()) {

		        while (rs.next()) {
		            int id = rs.getInt("ID");
		            String name = rs.getString("name");
		            String surname = rs.getString("surname");
		            int day = rs.getInt("day");
		            int month = rs.getInt("month");
		            int year = rs.getInt("year");
		            String obor = rs.getString("obor");
		            Float priemer = rs.getFloat("priemer");
		            String[] znamky = rs.getString("znamky").replace("[", "").replace("]", "").split(", ");
		            System.out.println(id);
		            System.out.println(obor);
		            System.out.println(name);
		            System.out.println(surname);
		            System.out.println(day);
		            System.out.println(month);
		            System.out.println(year);
		            System.out.println(priemer);
		            System.out.println(znamky);
		            
		            if (obor.equals("IBE")) {
			            Studenti.StudentIBE student = new Studenti.StudentIBE(id, name, surname, day, month, year, priemer);
			            localMap.put(id, student);
			            if(znamky[0] != "") {
			            	for(int i = 0; i < znamky.length; i++) {
			            		int tempZnamka = Integer.parseInt(znamky[i]);
			            		localMap.get(id).index.add(tempZnamka);
			            	}
			            }
		            }
		            else if (obor.equals("TLI")) {
			            Studenti.StudentTLI student = new Studenti.StudentTLI(id, name, surname, day, month, year, priemer);
			            localMap.put(id, student);
			            if(znamky[0] != "") {
			            	for(int i = 0; i < znamky.length; i++) {
			            		int tempZnamka = Integer.parseInt(znamky[i]);
			            		localMap.get(id).index.add(tempZnamka);
			            	}
			            }
		            }

		        }

		        //System.out.println("Načteno studentů: " + localMap.size());

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}


	}
