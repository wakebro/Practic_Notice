package basicCRUD;

import java.sql.*;

public class DeleteOracle {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
			con = DriverManager.getConnection(url, "mytest", "mytest");
			String sql = "DELETE test WHERE no=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 2);
			pstmt.executeUpdate();

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
