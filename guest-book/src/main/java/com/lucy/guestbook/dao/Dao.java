package com.lucy.guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lucy.guestbook.database.DatabaseConnection;
import com.lucy.guestbook.model.GuestVo;

public class Dao {
	public void create(GuestVo g) {
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			String s = "insert into guestbook (name, password, text) values(?, ?, ?)";
	        PreparedStatement st = con.prepareStatement(s); 

	        st.setString(1, g.getName()); 
	        st.setString(2, g.getPassword()); 
	        st.setString(3, g.getText());
	        
	        st.executeUpdate(); 
	        st.close(); 
	        con.close();

		} catch (Exception ex) {System.out.println("dao create "+ ex.getMessage());} 
		
	}
	public void delete(int id) {
			try {
				Connection con = DatabaseConnection.initializeDatabase();
		        PreparedStatement st = con.prepareStatement("delete from guestbook where idguestbook=?"); 
		        st.setInt(1, id); 
		        st.executeUpdate(); 
		        st.close(); 

			} catch (Exception ex) {System.out.println("dao delete " + ex.getMessage());} 
		
	}
	public void update(GuestVo e) {
		
	}
	public boolean authenticate(int id, String pw) {
		Connection con=null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String s = "select password from guestbook where idguestbook = ?";
	        PreparedStatement st = con.prepareStatement(s); 
	        st.setInt(1, id);
	        ResultSet rs = st.executeQuery(); 
	        rs.next();
	        String password = rs.getString(1);
	        st.close(); 
	        con.close();
	        if(password.equals(pw)) return true;
	        return false;

		} catch (Exception ex) {
			System.out.println("dao authenticate " + ex.getMessage());
			return false;
		}
		
		
	}
	public List<GuestVo> selectAll() {
		Connection con=null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String s = "select idguestbook, name, text, date from guestbook order by idguestbook";
	        PreparedStatement st = con.prepareStatement(s); 
	        ResultSet rs = st.executeQuery(); 
	        List<GuestVo> res = new ArrayList<GuestVo>();
	        while(rs.next()) {
	        	int id = rs.getInt(1);
	        	String name = rs.getString(2);
	        	String text = rs.getString(3);
	        	String date = rs.getString(4);
	        	res.add(new GuestVo(id, name, text, date));
	        }
	        st.close(); 
	        con.close();
	        return res;

		} catch (Exception ex) {
			System.out.println("dao selectAll " + ex.getMessage());
			return null;
		}
	}

}
