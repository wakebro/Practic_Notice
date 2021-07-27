package com.wakebro.app.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.wakebro.app.entity.Notice;

// CRUD를 담당하는 서비스 클래스 생성
public class NoticeService {
	// SELECT하여 각 컬럼의 값을 가져오는 메소드
	// List 형식으로 받아와 리턴하기 때문에 객체 Notice를 만들어 거기서 값을 받아와 저장
	public List<Notice> getList() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		con = DriverManager.getConnection(url, "mytest", "mytest");
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
}
