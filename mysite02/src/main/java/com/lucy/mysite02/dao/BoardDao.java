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
	public int linesPerPage = 5;

	/**CREATE-------------------------------------------------------------------------*/
	public boolean create(BoardVo b) {
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			String s;
			PreparedStatement st;
			/*REPLY*/
			if(b.getG_no()!=0) {
				b.setO_no(selectOrder(b.getG_no(), b.getO_no(), b.getDepth()));//find o_no
				s="update board set o_no=o_no+1 where g_no = ? and o_no >= ?";//shift 
				st = con.prepareStatement(s);
				st.setInt(1, b.getG_no());
				st.setInt(2, b.getO_no());
				st.executeUpdate();
			} 
			/*POST*/
			else {
				s = "select ifnull(max(g_no),0) from board";//find g_no
				st = con.prepareStatement(s);
				ResultSet rs = st.executeQuery();
				if(rs.next()) b.setG_no(rs.getInt(1)+1);
			}
			s = "insert into board (author, title, content, g_no, o_no, depth) values(?, ?, ?, ?, ?, ?)";//insert
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
	/**READ-------------------------------------------------------------------------*/
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
	//LIMIT 1, 2;
	public List<BoardVo> selectAll(int page) {//page
		Connection con=null;
		try {
			int offSet = (page-1)*linesPerPage;
			con = DatabaseConnection.initializeDatabase();
			String s = "select b.no, b.author, u.name, b.title, b.content, b.reg_date, "
			+"b.count, b.g_no, b.o_no, b.depth "+
			"from board b inner join user u on b.author = u.no order by g_no desc, o_no asc limit ?, ?";
	        PreparedStatement st = con.prepareStatement(s); 
	        st.setInt(1, offSet);
	        st.setInt(2, linesPerPage);
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
	public List<BoardVo> selectAll(String msg, int page) {//page
		Connection con=null;
		try {
			int offSet = (page-1)*linesPerPage;
			con = DatabaseConnection.initializeDatabase();
			String s = "select b.no, b.author, u.name, b.title, b.content, b.reg_date, "
			+"b.count, b.g_no, b.o_no, b.depth "+
			"from board b inner join user u on b.author = u.no "+
			"where title like ? or content like ? "
			+"order by g_no desc, o_no asc limit ?, ?";
	        PreparedStatement st = con.prepareStatement(s); 
	        st.setString(1, "%"+msg+"%");
	        st.setString(2, "%"+msg+"%");
	        st.setInt(3, offSet);
	        st.setInt(4, linesPerPage);
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
	/**
	 * --- <-- start o_no
	 * 	  ---
	 * 		---
	 * 	  ---
	 * --- <-- return new o_no
	 */
	public int selectOrder(int g_no, int o_no, int d) {
		Connection con=null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String s = "select o_no, depth from board where g_no=? and o_no > ? order by o_no";
	        PreparedStatement st = con.prepareStatement(s); 
	        st.setInt(1, g_no);
	        st.setInt(2, o_no);
	        ResultSet rs = st.executeQuery(); 
	        while(rs.next()) {
	        	int depth = rs.getInt(2);	        	
	        	if(depth < d) break;
	        	o_no = rs.getInt(1);
	        	
	        }
	        st.close(); 
	        con.close();
	        
	        return o_no+1;

		} catch (Exception ex) {
			System.out.println("board dao select order error : ");
			ex.printStackTrace();
			return 0;
		}
	}
	public int selectRowCount() {
		Connection con=null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String s = "select count(*) from board";
	        PreparedStatement st = con.prepareStatement(s); 
	        ResultSet rs = st.executeQuery(); 
	        if (rs.next()) return rs.getInt(1);
	        st.close(); 
	        con.close();
	        return 0;

		} catch (Exception ex) {
			System.out.println("board dao select row count error : ");
			ex.printStackTrace();
			return 0;
		}
	}
	public int selectRowCount(String msg) {
		Connection con=null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String s = "select count(*) from board where title like ? or content like ?";
	        PreparedStatement st = con.prepareStatement(s); 
	        st.setString(1, "%"+msg+"%");
	        st.setString(2, "%"+msg+"%");
	        ResultSet rs = st.executeQuery(); 
	        if (rs.next()) return rs.getInt(1);
	        st.close(); 
	        con.close();
	        return 0;

		} catch (Exception ex) {
			System.out.println("board dao select row count error : ");
			ex.printStackTrace();
			return 0;
		}
	}
	
	/**UPDATE-------------------------------------------------------------------------*/
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
	/*DELETE-------------------------------------------------------------------------*/
	/**
	 *--- <-- delete this (main)
	 *  --- <-- delete 
	 *  --- <-- delete
	 *     --- <-- delete
	 *  --- <-- delete
	 *---
	 */
	public boolean delete(int no) {
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			BoardVo b = select(no);
			int deleteUpTo = selectOrder(b.getG_no(), b.getO_no(), b.getDepth()+1);
			String s = "delete from board where g_no=? and  o_no >= ? and o_no < ?";
	        PreparedStatement st = con.prepareStatement(s); 
	        st.setInt(1, b.getG_no());
	        st.setInt(2, b.getO_no()); 
	        st.setInt(3, deleteUpTo);
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
