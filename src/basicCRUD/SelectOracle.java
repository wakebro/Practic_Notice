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
			String sql = "SELECT * FROM notice";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date date = rs.getDate("create_date");
				System.out.printf("No.%3d, Title : %20s, WriteID : %7s, Content : %s, Date : %s\n", 
						no, title, id, content,date.toString());
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (con != null && !con.isClosed()) {
					rs.close();
					stmt.close();
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
