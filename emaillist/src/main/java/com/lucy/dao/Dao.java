package com.lucy.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lucy.database.DatabaseConnection;
import com.lucy.model.EmailListVo;
public class Dao {
	public void create(EmailListVo e) {
        Connection con;
		try {
			con = DatabaseConnection.initializeDatabase();
			String s = "insert into emaillist (firstname, lastname, email) values(?, ?, ?)";
	        PreparedStatement st = con.prepareStatement(s); 

	        st.setString(1, e.getFirstname()); 
	        st.setString(2, e.getLastname()); 
	        st.setString(3, e.getEmail());
	        
	        st.executeUpdate(); 
	        st.close(); 
	        con.close(); 

		} catch (Exception ex) {System.out.println(ex.getMessage());} 
		
	}
	public void delete(int idemaillist) {
		 Connection con;
			try {
				con = DatabaseConnection.initializeDatabase();
		        PreparedStatement st = con.prepareStatement("delete from emaillist where idemaillist=?"); 
		        st.setInt(1, idemaillist); 
		        st.executeUpdate(); 
		        st.close(); 
		        con.close(); 

			} catch (Exception ex) {System.out.println(ex.getMessage());} 
		
	}
	public void update(EmailListVo e) {
		
	}
	public void select(int idemaillist) {
		
	}
	public List<EmailListVo> selectAll() {
		Connection con;
		try {
			con = DatabaseConnection.initializeDatabase();
	        PreparedStatement st = con.prepareStatement("select idemaillist, firstname, lastname, email from emaillist"); 
	        ResultSet rs = st.executeQuery(); 
	        List<EmailListVo> res = new ArrayList<EmailListVo>();
	        while(rs.next()) {
	        	int idemaillist = rs.getInt("idemaillist");
	        	String firstname = rs.getString("firstname");
	        	String lastname = rs.getString("lastname");
	        	String email = rs.getString("email");
	        	res.add(new EmailListVo(idemaillist, firstname, lastname, email));
	        }
	        st.close(); 
	        con.close(); 
	        return res;

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} 
	}

}
