package Studenti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

	public class DBWrite {

	  public DBWrite() {}

	  /*public void performInsertQuery(String insertQuery) {
	    if (insertQuery == null) {
	      throw new NullPointerException("query must not be null!");
	    } else if (insertQuery.isEmpty()) {
	      throw new IllegalArgumentException("query must not be empty!");
	    }
	    Connection conn = DBConnect.getDBConnection();
	    try (PreparedStatement prStmt = conn.prepareStatement(insertQuery);) {
	      int rowsInserted = prStmt.executeUpdate();
	      System.out.println("Byl vlo�en u�ivatel s emailem: " + "myname123@stud.feec.vutbr.cz");
	    } catch (SQLException e) {
	      System.out.println("U�ivatel s emailem: " + "myname123@stud.feec.vutbr.cz "
	          + "ji� byl vlo�en nemus�te jej vkl�dat znovu");
	      // e.printStackTrace();
	    }
	  }*/

	  public static void deleteStudents() throws SQLException {
		    Connection conn = DBConnect.getDBConnection();
		    
		    String deleteValues = "DELETE from students";
		    PreparedStatement prStmt2 = conn.prepareStatement(deleteValues);
		    prStmt2.executeUpdate();
	  }
	  
	  public static void insertNewUser(int ID, String name, String surname, int day, int month, int year, String obor, float priemer, String znamky) throws SQLException {
		  	Connection conn = DBConnect.getDBConnection();
		  	String insertUser = "INSERT INTO students " + "(ID,name,surname,day,month,year,obor,priemer,znamky)" + "VALUES(?,?,?,?,?,?,?,?,?)";

		  	try (PreparedStatement prStmt = conn.prepareStatement(insertUser)) {
		  		prStmt.setInt(1, ID);
		  		prStmt.setString(2, name);
		  		prStmt.setString(3, surname);
		  		prStmt.setInt(4, day);
		  		prStmt.setInt(5, month);
		  		prStmt.setInt(6, year);
		  		prStmt.setString(7, obor);
		  		prStmt.setFloat(8, priemer);
		  		prStmt.setString(9, znamky);
	      
		  		prStmt.executeUpdate();

		  		System.out.println("Novy uzivatel byl vlozen do databaze!");
		  	} catch (SQLException e) {
		  		System.out.println("Uzivatel uz byl vlozen nebo jste zadali spatne SQL prikaz INSERT");
		  	}
	  	}


	}

	
