package basicCRUD;

import java.sql.*;

public class SelectOracle {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
			con = DriverManager.getConnection(url, "mytest", "mytest");
			stmt = con.createStatement();
			String sql = "SELECT * FROM test";

			rs = stmt.executeQuery(sql);

			rs.next();
			int no = rs.getInt(1);
			String str = rs.getString(2);
			System.out.printf("%d : %s", no, str);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
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
