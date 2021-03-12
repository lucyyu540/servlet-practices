package com.lucy.mysite02.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lucy.mysite02.database.DatabaseConnection;
import com.lucy.mysite02.model.BoardVo;
import com.lucy.mysite02.model.GuestVo;

public class BoardDao {
	public boolean create(BoardVo b) {
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			String s = "insert into board (author, title, content) values(?, ?, ?)";
	        PreparedStatement st = con.prepareStatement(s); 

	        st.setInt(1, b.getAuthorNo() ); 
	        st.setString(2, b.getTitle()); 
	        st.setString(3, b.getContent());
	        
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

	public BoardVo select(int no) {
		Connection con=null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String s = "select b.author, u.name, b.title, b.content, b.reg_date from board b inner join on b.author = u.no where b.no=?";
	        PreparedStatement st = con.prepareStatement(s); 
	        st.setInt(1, no);
	        ResultSet rs = st.executeQuery(); 
	        if(rs.next()) {
	        	int authorNo = rs.getInt(1);
	        	String author = rs.getString(2);
	        	String title = rs.getString(3);
	        	String content = rs.getString(4);
	        	String date = rs.getString(5);
	        	return new BoardVo(no, authorNo, author, title, content, date);
	        }
	        st.close(); 
	        con.close();
	        return null;

		} catch (Exception ex) {
			System.out.println("board dao selectAll error : ");
			ex.printStackTrace();
			return null;
		}
	}
	public List<BoardVo> selectAll() {
		Connection con=null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String s = "select b.no, b.author, u.name, b.title, b.content, b.reg_date from board b inner join on b.author = u.no order by reg_date";
	        PreparedStatement st = con.prepareStatement(s); 
	        ResultSet rs = st.executeQuery(); 
	        List<BoardVo> res = new ArrayList<BoardVo>();
	        while(rs.next()) {
	        	int no = rs.getInt(1);
	        	int authorNo = rs.getInt(2);
	        	String author = rs.getString(3);
	        	String title = rs.getString(4);
	        	String content = rs.getString(5);
	        	String date = rs.getString(6);
	        	res.add(new BoardVo(no,authorNo, author, title, content, date));
	        }
	        st.close(); 
	        con.close();
	        return res;

		} catch (Exception ex) {
			System.out.println("board dao selectAll error : ");
			ex.printStackTrace();
			return null;
		}
	}
	public boolean update(BoardVo b) {
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			String s = "update board set title = ?, content = ?";
	        PreparedStatement st = con.prepareStatement(s); 
	        st.setString(1, b.getTitle()); 
	        st.setString(2, b.getContent());
	        
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
	public boolean updateCount(int no) {
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			String s = "update board set count = count+1 where no = ?";
	        PreparedStatement st = con.prepareStatement(s); 
	        st.setInt(1, no); 
	        
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
	

}
