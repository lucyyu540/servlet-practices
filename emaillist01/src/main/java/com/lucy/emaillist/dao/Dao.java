package com.lucy.emaillist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lucy.emaillist.database.DatabaseConnection;
import com.lucy.emaillist.model.EmailListVo;

public class Dao {
	public boolean create(EmailListVo e) {
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			String s = "insert into emaillist (firstname, lastname, email) values(?, ?, ?)";
	        PreparedStatement st = con.prepareStatement(s); 

	        st.setString(1, e.getFirstname()); 
	        st.setString(2, e.getLastname()); 
	        st.setString(3, e.getEmail());
	        
	        int r = st.executeUpdate(); 
	        st.close(); 
	        con.close();
	        if(r ==1) return true;
	        return false;

		} catch (Exception ex) {
			System.out.print("dao create :");
			ex.printStackTrace();
			return false;
		} 
		
	}
	public void delete(int idemaillist) {
			try {
				Connection con = DatabaseConnection.initializeDatabase();
		        PreparedStatement st = con.prepareStatement("delete from emaillist where idemaillist=?"); 
		        st.setInt(1, idemaillist); 
		        st.executeUpdate(); 
		        st.close(); 

			} catch (Exception ex) {System.out.println("dao delete " + ex.getMessage());} 
		
	}
	public void update(EmailListVo e) {
		
	}
	public void select(int idemaillist) {
		
	}
	public List<EmailListVo> selectAll() {
		Connection con=null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String s = "select idemaillist, firstname, lastname, email from emaillist order by idemaillist";
	        PreparedStatement st = con.prepareStatement(s); 
	        ResultSet rs = st.executeQuery(); 
	        List<EmailListVo> res = new ArrayList<EmailListVo>();
	        while(rs.next()) {
	        	int idemaillist = rs.getInt(1);
	        	String firstname = rs.getString(2);
	        	String lastname = rs.getString(3);
	        	String email = rs.getString(4);
	        	res.add(new EmailListVo(idemaillist, firstname, lastname, email));
	        }
	        st.close(); 
	        return res;

		} catch (Exception ex) {
			System.out.println("dao selectAll " + ex.getMessage());
			return null;
		} finally {
			try {
				con.close();
			} catch (SQLException e) { e.printStackTrace();}
		}
	}
}
