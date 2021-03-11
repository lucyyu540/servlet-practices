package com.lucy.mysite02.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lucy.mysite02.database.DatabaseConnection;
import com.lucy.mysite02.model.UserVo;

public class UserDao {
	public boolean create(UserVo u) {
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			String s = "insert into user (name, email, password, gender) values(?, ?, ?, ?)";
	        PreparedStatement st = con.prepareStatement(s); 

	        st.setString(1, u.getName()); 
	        st.setString(2, u.getEmail()); 
	        st.setString(3, u.getPassword());
	        st.setString(4, u.getGender());
	        
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
		        PreparedStatement st = con.prepareStatement("delete from user where no=? and password=?"); 
		        st.setInt(1, id); 
		        st.setString(2, pw);
		        int r = st.executeUpdate(); 
		        st.close(); 
		        con.close();
		        if(r==1) return true;
		        return false;

			} catch (Exception ex) {
				System.out.print("dao delete: ");
				ex.printStackTrace();
				return false;
			} 
		
	}
	public boolean update(UserVo u) {
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			String s = "update user set name = ?, email = ?, password = ?, gender = ? where no = ? and password = ?";
	        PreparedStatement st = con.prepareStatement(s); 

	        st.setString(1, u.getName()); 
	        st.setString(2, u.getEmail()); 
	        st.setString(3, u.getPassword());
	        st.setString(4, u.getGender());
	        st.setInt(5, u.getNo());
	        st.setString(6, u.getPassword());
	        
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
	public UserVo select() {
		return null;
		
	}
	public List<UserVo> selectAll() {
		Connection con=null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String s = "select no, name, email, gender, join_date from guestbook order by idguestbook";
	        PreparedStatement st = con.prepareStatement(s); 
	        ResultSet rs = st.executeQuery(); 
	        List<UserVo> res = new ArrayList<UserVo>();
	        while(rs.next()) {
	        	int id = rs.getInt(1);
	        	String name = rs.getString(2);
	        	String email = rs.getString(3);
	        	String gender = rs.getString(4);
	        	String join_date = rs.getString(5);
	        	res.add(new UserVo(id, name, email, gender, join_date));
	        }
	        st.close(); 
	        con.close();
	        return res;

		} catch (Exception ex) {
			System.out.print("dao selectAll error : ");
			ex.printStackTrace();
			return null;
		}
	}

}
