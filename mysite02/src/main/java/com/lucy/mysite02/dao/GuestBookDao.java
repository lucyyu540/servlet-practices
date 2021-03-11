package com.lucy.mysite02.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lucy.mysite02.database.DatabaseConnection;
import com.lucy.mysite02.model.GuestVo;

public class GuestBookDao {
	public boolean create(GuestVo g) {
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			String s = "insert into guestbook (name, password, contents) values(?, ?, ?)";
	        PreparedStatement st = con.prepareStatement(s); 

	        st.setString(1, g.getName()); 
	        st.setString(2, g.getPassword()); 
	        st.setString(3, g.getContents());
	        
	        int r = st.executeUpdate(); 
	        st.close(); 
	        con.close();
	        if(r==1) return true;
	        return false;

		} catch (Exception ex) {
			System.out.println("dao create error : ");
			ex.printStackTrace();
			return false;
		} 
		
	}
	public boolean delete(int id, String pw) {
			try {
				Connection con = DatabaseConnection.initializeDatabase();
		        PreparedStatement st = con.prepareStatement("delete from guestbook where no=? and password=?"); 
		        st.setInt(1, id); 
		        st.setString(2, pw);
		        int r = st.executeUpdate(); 
		        st.close(); 
		        con.close();
		        if(r==1) return true;
		        return false;

			} catch (Exception ex) {
				System.out.print("dao delete error: ");
				ex.printStackTrace();
				return false;
			} 
		
	}
	public void update(GuestVo e) {
		
	}
	public List<GuestVo> selectAll() {
		Connection con=null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String s = "select no, name, contents, reg_date from guestbook order by reg_date";
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
			System.out.println("dao selectAll error : ");
			ex.printStackTrace();
			return null;
		}
	}

}
