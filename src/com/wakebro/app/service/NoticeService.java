package com.wakebro.app.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.wakebro.app.entity.Notice;

// CRUD를 담당하는 서비스 클래스 생성
public class NoticeService {
	// SELECT하여 각 컬럼의 값을 가져오는 메소드
	// List 형식으로 받아와 리턴하기 때문에 객체 Notice를 만들어 거기서 값을 받아와 저장
	private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private String uid = "mytest";
	private String pwd = "mytest";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	public List<Notice> getList() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		Class.forName(driver);
		con = DriverManager.getConnection(url, uid, pwd);
		stmt = con.createStatement();
		String sql = "SELECT * FROM notice";

		rs = stmt.executeQuery(sql);

		List<Notice> list = new ArrayList<Notice>();

		while (rs.next()) {
			int no = rs.getInt("no");
			String id = rs.getString("id");
			String title = rs.getString("title");
			String content = rs.getString("content");
			Date date = rs.getDate("create_date");

			Notice notice = new Notice(no, id, title, content, date);

			list.add(notice);
		}

		rs.close();
		stmt.close();
		con.close();
		return list;
	}
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String id = notice.getId();
		String title = notice.getTitle();
		String content = notice.getContent();

		Class.forName(driver);
		con = DriverManager.getConnection(url, uid, pwd);
		String sql = "INSERT INTO notice(id, title, content, create_date) "
				+ "VALUES(?, ?, ?,SYSDATE)";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, title);
		pstmt.setString(3, content);
		
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		return result;
	}
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String title = notice.getTitle();
		String content = notice.getContent();
		int no = notice.getNo();

		Class.forName(driver);
		con = DriverManager.getConnection(url, uid, pwd);
		String sql = "UPDATE notice SET title=? content=? WHERE no=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setInt(3, no);
		
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		return result;
	}
	public int delete(int id) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		Class.forName(driver);
		con = DriverManager.getConnection(url, uid, pwd);
		String sql = "DELETE test WHERE no=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		return result;
	}
}
