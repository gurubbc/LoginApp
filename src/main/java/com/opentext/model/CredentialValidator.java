package com.opentext.model;
import java.sql.*;


public class CredentialValidator {
	public static boolean validateUser(String userName, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/opentext", "root", "Password123456@");
		if (con!=null) {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM USERS");
			while (rs.next()) {
				String unFromDB=rs.getString(2);
				String pwdFromDB=rs.getString(3);
				if (userName.equals(unFromDB) && password.equals(pwdFromDB))
				{
					return true; // the record matches, success
				}
			}
			return false; // all records have been scanned for matches, but no match found
		} else {
			System.out.println("Couldn't connect to database..please check");
		}
		return false;
	}
	
}
