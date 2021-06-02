package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.BoardDTO;

public class BoardDAO {
	
	private Connection dbConn() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb?useUnicode=true&characterEncoding=utf-8","jspuser","jsppass");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}
	
	public ArrayList<BoardDTO> getList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = dbConn();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select number,writer,subject,created from board");
			
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
			
			while(rs.next()){ 
				BoardDTO board = new BoardDTO();
				
				int number = rs.getInt("number");
				String writer = rs.getString("writer");
				String subject= rs.getString("subject");
				Date created = rs.getDate("created");
				
				board.setNumber(number);
				board.setWriter(writer);
				board.setSubject(subject);
				board.setCreated(created);
				
				list.add(board);
			}
			return list;
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return null;
	}
	
	public void delete(String number) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try{
			conn = dbConn();
			
			stmt = conn.createStatement();
			stmt.executeUpdate("delete from board where number="+number);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
	
	public BoardDTO read(String number) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = dbConn();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from board where number="+number);
			
			if(rs.next()){
				BoardDTO board = new BoardDTO();
				
				int num = rs.getInt("number");
				String writer = rs.getString("writer");
				String subject= rs.getString("subject");
				String contents= rs.getString("contents");
				Date created = rs.getDate("created");
				
				board.setNumber(num);
				board.setWriter(writer);
				board.setSubject(subject);
				board.setContents(contents);
				board.setCreated(created);
				
				return board;
				
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		return null;
	}
	
	public void insert(BoardDTO board) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try{
			conn = dbConn();
			
			String sql = "insert into board(writer,subject,contents,password,created) values(?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getContents());
			pstmt.setString(4, board.getPassword());
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void update(BoardDTO board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			conn = dbConn();
			
			String sql = "update board set writer=?, subject=?, contents=? where number=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getContents());
			pstmt.setInt(4, board.getNumber());
			
			pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	

}
