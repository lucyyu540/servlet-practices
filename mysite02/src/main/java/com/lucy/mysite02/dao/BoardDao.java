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
			String s;
			PreparedStatement st;
			//update order numbers 
			if(b.getG_no()!=0) {//is a reply
				s="update board set o_no=o_no+1 where g_no = ? and o_no >= ?";
				st = con.prepareStatement(s);
				st.setInt(1, b.getG_no());
				st.setInt(2, b.getO_no());
				st.executeUpdate();
			} 
			else {//is a new post
				s = "select ifnull(max(g_no),0) from board";
				st = con.prepareStatement(s);
				ResultSet rs = st.executeQuery();
				if(rs.next()) b.setG_no(rs.getInt(1)+1);
			}
			s = "insert into board (author, title, content, g_no, o_no, depth) values(?, ?, ?, ?, ?, ?)";
	        st = con.prepareStatement(s); 

	        st.setInt(1, b.getAuthorNo() ); 
	        st.setString(2, b.getTitle()); 
	        st.setString(3, b.getContent());
	        st.setInt(4, b.getG_no());
	        st.setInt(5, b.getO_no());
	        st.setInt(6, b.getDepth());
	        
	        int r = st.executeUpdate(); 
	        st.close(); 
	        con.close();
	        if(r==1) return true;
	        return false;

		} catch (Exception ex) {
			System.out.println("board dao create error : ");
			ex.printStackTrace();
			return false;
		} 
		
	}

	public BoardVo select(int no) {
		Connection con=null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String s = "select author, title, content, reg_date, count, g_no, o_no, depth "
					+"from board where no = ?";
	        PreparedStatement st = con.prepareStatement(s); 
	        st.setInt(1, no);
	        ResultSet rs = st.executeQuery(); 
	        if(rs.next()) {
	        	int authorNo = rs.getInt(1);
	        	String title = rs.getString(2);
	        	String content = rs.getString(3);
	        	String date = rs.getString(4);
	        	int count = rs.getInt(5);
	        	int g_no = rs.getInt(6);
	        	int o_no = rs.getInt(7);
	        	int depth = rs.getInt(8);
	        	BoardVo b = new BoardVo();
	        	b.setNo(no);
	        	b.setAuthorNo(authorNo);
	        	b.setTitle(title);
	        	b.setContent(content);
	        	b.setReg_date(date);
	        	b.setCount(count);
	        	b.setG_no(g_no);
	        	b.setO_no(o_no);
	        	b.setDepth(depth);
	        	System.out.println(b.toString());
	        	return b;
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
			String s = "select b.no, b.author, u.name, b.title, b.content, b.reg_date, "
			+"b.count, b.g_no, b.o_no, b.depth "+
			"from board b inner join user u on b.author = u.no order by g_no desc, o_no desc";
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
	        	int count = rs.getInt(7);
	        	int g_no = rs.getInt(8);
	        	int o_no = rs.getInt(9);
	        	int depth = rs.getInt(10);
	        	BoardVo b = new BoardVo();
	        	b.setNo(no);
	        	b.setAuthorNo(authorNo);
	        	b.setAuthor(author);
	        	b.setTitle(title);
	        	b.setContent(content);
	        	b.setReg_date(date);
	        	b.setCount(count);
	        	b.setG_no(g_no);
	        	b.setO_no(o_no);
	        	b.setDepth(depth);
	        	res.add(b);
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
			String s = "update board set title = ?, content = ? where no = ?";
	        PreparedStatement st = con.prepareStatement(s); 
	        st.setString(1, b.getTitle()); 
	        st.setString(2, b.getContent());
	        st.setInt(3, b.getNo());
	        
	        int r = st.executeUpdate(); 
	        st.close(); 
	        con.close();
	        if(r==1) return true;
	        return false;

		} catch (Exception ex) {
			System.out.println("board dao update error : ");
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
			System.out.println("board dao update count error : ");
			ex.printStackTrace();
			return false;
		} 
		
	}
	public boolean delete(int no) {
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			String s = "delete from board where no=?";
	        PreparedStatement st = con.prepareStatement(s); 
	        st.setInt(1, no); 
	        
	        int r = st.executeUpdate(); 
	        st.close(); 
	        con.close();
	        if(r==1) return true;
	        return false;

		} catch (Exception ex) {
			System.out.println("board dao delete error : ");
			ex.printStackTrace();
			return false;
		} 
	}
	

}
