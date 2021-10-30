package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.DbConnector;

public class PrintTable1 {
	public static void main(String[] args) {
		Connection conn = DbConnector.getConnection();
		try {
			Statement st = conn.createStatement();
			String query = "select * from INSTITUTION";
			ResultSet rs = st.executeQuery(query);
			while (rs.next())
				System.out.println(rs.getString(1) + "  " 
						+ rs.getString("NAMEINST") + "  "
						+ rs.getString("DESCRIPTIONINST"));
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	}
}