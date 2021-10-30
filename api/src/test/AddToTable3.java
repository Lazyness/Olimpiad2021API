
package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import controller.DbConnector;

public class AddToTable3 {
	public static void main(String[] args) {
		Connection conn = DbConnector.getConnection();
		String query = "insert into DISH(NAMEDISH, PHOTO, DESCRIPTIONDISH, PRICE, KEYMC)"
				+ " values(?,?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,"Burher Ko-ko dvizh");
			pst.setString(2,"http://primebeef.ru/images/cms/data/img_3911.jpg");
			pst.setString(3,"Fresh homemade bun, BBQ sauce, juicy beef, pickle, Gouda cheese.");
			pst.setInt(4,100);
			pst.setInt(5,1);
			pst.executeUpdate();

			pst.setString(1,"Burher Chilling time");
			pst.setString(2,"https://zira.uz/wp-content/uploads/2019/06/burger.jpg");
			pst.setString(3,"Sauce 1000 islands, two juicy beef cutlets, two cheeses, bacon, onion rings, maple syrup, iceberg, arugula, tomato.");
			pst.setInt(4,125);
			pst.setInt(5,2);
			pst.executeUpdate();
			
			pst.setString(1,"Burher Explosive brigade");
			pst.setString(2,"https://www.bodo.ua/resize/upload/files/cm-experience/104/103868/images_file/all_all_big-t1591950914-r1w768h425q90zc1.jpg");
			pst.setString(3,"Smoked torn pork with smoked cherries, bun, gouda cheese, pickle, iceberg lettuce, romesco sauce, apple barbecue sauce, tsatsiki sauce.");
			pst.setInt(4,95);
			pst.setInt(5,1);
			pst.executeUpdate();
			
			pst.setString(1,"Seth Unagi Boom");
			pst.setString(2,"https://static-sl.insales.ru/images/products/1/7008/373381984/%D0%A1%D0%B5%D1%82-17-%D0%A1%D1%83%D1%88%D0%B8-%D0%9F%D0%B0%D0%BF%D0%B0.jpg");
			pst.setString(3,"Rolls Philadelphia Light with salmon, California Black with salmon, California Light with snow crab 2 amount Sticks, soy sauce, ginger and wasabi are added to the rolls.");
			pst.setInt(4,499);
			pst.setInt(5,2);
			pst.executeUpdate();
			
			pst.setString(1,"Seth Philadelphia Kong");
			pst.setString(2,"https://roll-club.kh.ua/wp-content/uploads/2015/09/fila-set-2021.jpg");
			pst.setString(3,"California roll with snow crab and unagi sauce, Philadelphia roll in tuna chips, California roll with perch Izumadi and spicy sauce, California roll with mussels and unagi sauce, Vega roll, poppies with cucumber");
			pst.setInt(4,356);
			pst.setInt(5,1);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}