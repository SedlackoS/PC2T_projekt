package Studenti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

	public class DBWrite {

	  public DBWrite() {}

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

		  	} catch (SQLException e) {
		  		System.out.println("Nastal problém s SQL databázou!");
		  	}
	  	}


	}

	
