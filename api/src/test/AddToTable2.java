
package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import controller.DbConnector;

public class AddToTable2 {
	public static void main(String[] args) {
		Connection conn = DbConnector.getConnection();
		String query = "insert into MENUCATEGORY(NAMEMC)"
				+ " values(?)";
		try {
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,"Sushi");
			pst.executeUpdate();

			pst.setString(1,"Pizza");
			pst.executeUpdate();
			
			pst.setString(1,"Paste");
			pst.executeUpdate();
			
			pst.setString(1,"Burger");
			pst.executeUpdate();
			
			pst.setString(1,"Dessert");
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}