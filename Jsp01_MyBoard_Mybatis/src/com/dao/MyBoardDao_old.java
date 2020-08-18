package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dto.MyBoardDto;

public class MyBoardDao_old {

	Connection con = null;

	public MyBoardDao_old() {

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("디비 연결");
		} catch (ClassNotFoundException e) {
			System.out.println("디비 연결 실패");
			e.printStackTrace();
		}
		
	
	}
	
	public ArrayList<MyBoardDto> selectall() {
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KH","KH");
			System.out.println("계정 연결");
		} catch (SQLException e) {
			System.out.println("계정 연결 실패");
			e.printStackTrace();
		}
		
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<MyBoardDto> res = new ArrayList<>();
		String sql="SELECT * FROM MYBOARD";
		
		try {
			stmt= con.createStatement();
			
			rs=stmt.executeQuery(sql);
			System.out.println("query 준비");
			
			while(rs.next()) {
				MyBoardDto dto = new MyBoardDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));
				res.add(dto);
			}
			System.out.println("query 실행");
			
		} catch (SQLException e) {
			System.out.println("query 구문 실패");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				con.close();
				System.out.println("db 종료\n");
			} catch (SQLException e) {
				System.out.println("db 종료 실패");
				e.printStackTrace();
			}
		}
		
		
		
		return res;
	}
	
	public MyBoardDto selectone(int myno) {
		
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KH","KH");
			System.out.println("계정 연결");
		} catch (SQLException e) {
			System.out.println("계정 연결 실패");
			e.printStackTrace();
		}
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyBoardDto res = null;
		String sql = "SELECT * FROM MYBOARD WHERE MYNO=?";
		
		try {
			pstm= con.prepareStatement(sql);
			pstm.setInt(1, myno);
			System.out.println("query 준비");
			
			rs = pstm.executeQuery();
			while(rs.next()) {
				res = new MyBoardDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));
			}
			System.out.println("query 실행 및 리턴");
			
			
		} catch (SQLException e) {
			System.out.println("query 구문 실패");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstm.close();
				con.close();
				System.out.println("db 종료 \n");
			} catch (SQLException e) {
				System.out.println("db 종료 실패");
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	public int insert(MyBoardDto dto) {
		
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KH","KH");
			System.out.println("계정 연결");
		} catch (SQLException e) {
			System.out.println("계정 연결 실패");
			e.printStackTrace();
		}
		
		PreparedStatement pstm = null;
		int res = 0;
		String sql="INSERT INTO MYBOARD VALUES(MYSEQ.NEXTVAL,?,?,?,SYSDATE) ";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, dto.getMyname());
			pstm.setString(2, dto.getMytitle());
			pstm.setString(3, dto.getMycontent());
			System.out.println("query 준비");
			
			res=pstm.executeUpdate();
			System.out.println("query 실행 및 리턴");
			
		} catch (SQLException e) {
			System.out.println("3/4 단계 실패");
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
				con.close();
				System.out.println("db 종료 \n");
			} catch (SQLException e) {
				System.out.println("db 종료 실패");
				e.printStackTrace();
			}
		}

		return res;
	}
	
	public int delete(int myno) {
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KH","KH");
			System.out.println("계정 연결");
		} catch (SQLException e) {
			System.out.println("계정 연결 실패");
			e.printStackTrace();
		}
		
		PreparedStatement pstm = null;
		int res =0;
		
		String sql="DELETE FROM MYBOARD WHERE MYNO=?";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, myno);
			
			System.out.println("query 준비");
			
			res = pstm.executeUpdate();
			System.out.println("query 실행 및 리턴");
			
		} catch (SQLException e) {
			System.out.println("3/4 단계 실패");
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
				con.close();
				System.out.println("db 종료 \n");
			} catch (SQLException e) {
				System.out.println("db 종료 실패");
				e.printStackTrace();
			}
			
		}

		return res;
	}
	
	
	public int update(MyBoardDto dto) {
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KH","KH");
			System.out.println("계정 연결 성공");
		} catch (SQLException e) {
			System.out.println("계정 연결 실패");
			e.printStackTrace();
		}
		
		PreparedStatement pstm = null;
		int res = 0;
		String sql ="UPDATE MYBOARD SET MYTITLE=?, MYCONTENT=? WHERE MYNO=?";
		
		try {
			pstm= con.prepareStatement(sql);
			pstm.setString(1, dto.getMytitle());
			pstm.setString(2, dto.getMycontent());
			pstm.setInt(3, dto.getMyno());
			System.out.println("query 준비");
			
			res = pstm.executeUpdate();
			System.out.println("query 실행 및 리턴");
		} catch (SQLException e) {
			System.out.println("3/4 단계 실패");
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
				con.close();
				System.out.println("db 종료 \n");
			} catch (SQLException e) {
				System.out.println("db 종료 실패");
				e.printStackTrace();
			}
			
		}
		
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
