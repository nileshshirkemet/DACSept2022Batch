package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.met.model.Account;

public class JDBCTest {

	public static void saveUsingJDBC(Account acc) {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}

		try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@iitdac.met.edu/xe", "milind", "pawar");
			PreparedStatement pstmt = con.prepareStatement("insert into account values(?, ?, ?)")){
			
			System.out.println(con.getClass());
			System.out.println(pstmt.getClass());
			
			pstmt.setInt(1, acc.getId());
			pstmt.setString(2, acc.getName());
			pstmt.setDouble(3, acc.getBalance());
			
			/*
			 * pstmt.setInt(4, acc.getId()); 
			 * pstmt.setString(5, acc.getName());
			 * pstmt.setDouble(150, acc.getBalance());
			 */
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		Account account = new Account();
		account.setId(4);
		account.setName("Jane");
		account.setBalance(500000);

		saveUsingJDBC(account);
		
		
		
	}
	
}
