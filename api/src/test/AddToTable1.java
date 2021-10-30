
package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import controller.DbConnector;

public class AddToTable1 {
	public static void main(String[] args) {
		Connection conn = DbConnector.getConnection();
		String query = "insert into INSTITUTION(NAMEINST, DESCRIPTIONINST)"
				+ " values(?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,"DA!BRO");
			pst.setString(2,"Are you hungry? Then the Da! Bro team will feed you fresh and tasty burgers, french fries, ribs. And in general why listen to us? Taste every day!");
			pst.executeUpdate();

			pst.setString(1,"I WANT SUSHI");
			pst.setString(2, "I Want Sushi is an online restaurant of Japanese cuisine for those who just love roles, real roles. The menu includes popular classic items at affordable prices. We cook from fresh quality products. We deliver as quickly as possible within Chernihiv. We guarantee satisfaction");
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}