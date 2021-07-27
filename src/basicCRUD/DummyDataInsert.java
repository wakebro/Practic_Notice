package basicCRUD;

import java.sql.*;

public class DummyDataInsert {
	// 오라클에 더미 데이터를 넣기 위한 구문
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
			con = DriverManager.getConnection(url, "mytest", "mytest");
			for (int i = 1; i < 10; i++) {
				int dd = i * 3;
				int mm = i * 3;
				String date = "2021-05-" + dd + " 17:" + mm + ":10";
				String sql = "INSERT INTO notice(id, title, content, create_date) VALUES('alex',? , ?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ("ate" + i + "?"));
				pstmt.setString(2, (". ee" + i));
				pstmt.setString(3, date);
				pstmt.executeUpdate();
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
