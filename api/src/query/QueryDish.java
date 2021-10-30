package query;

import java.util.Map;

public class QueryDish {

	//Запити на створення таблиці БД
		public static String queryCreate() {	
			String sql ="create table DISH ("
					+ "KEYDISH int generated always as identity,"
					+ "NAMEDISH varchar(200) default '' not null,"
					+ "PHOTO varchar(2000) default '' not null,"
					+ "DESCRIPTIONDISH varchar(500) default '' not null,"
					+ "PRICE integer default 0," 
					+ "KEYMC int constraint FK_DISH_CTH "
					+ "references MENUCATEGORY on delete cascade, " 
					+ "primary key (KEYDISH))";
			return sql;
		}
	
//Запит на отримання вмісту таблиці БД
	public static String queryGetAll() {
		return "select DISH.KEYDISH, DISH.NAMEDISH, DISH.PHOTO, DISH.DESCRIPTIONDISH, DISH.PRICE"
				+ " MENUCATEGORY.NAMEMC AS MENUCATEGORY, "
				+ " MENUCATEGORY.KEYMC AS KEYMC"
				+ " from DISH, MENUCATEGORY "
				+ "WHERE MENUCATEGORY.KEYMC=DISH.KEYMC "
				+ " DISH BY MENUCATEGORY, DISH.NAMEDISH";
	}

	//Запит на додавння 
	public static String queryAdd(Map<String, Object> map) {	
		return String.format("insert into DISH"
				+ "(NAMEDISH, PHOTO, DESCRIPTIONDISH, PRICE, KEYMC) "
				+ "values('%s', '%s', '%s', %d, %d)",
				map.get("namedish"), map.get("photo"), 
				map.get("descriptiondish"), map.get("price") , map.get("keymc"));
	}

	//Запит на редагування 
	public static String queryEdit(Map<String, Object> map) {	
		return String.format("update DISH"
				+ " set  NAMEDISH = '%s', PHOTO = '%s', DESCRIPTIONDISH = '%s', PRICE = %d,"
				+ "KEYMC = %d where KEYDISH = %d",
				map.get("namedish"), map.get("photo"),
				map.get("descriptiondish"), map.get("price"), map.get("keymc"), map.get("keydish"));
	}

	//Запит на видалення 
	public static String queryDelById(int keydish) {	
		return "DELETE FROM DISH WHERE KEYDISH = " + keydish;
	}	
}