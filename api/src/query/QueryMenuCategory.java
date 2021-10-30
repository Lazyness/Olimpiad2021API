package query;

import java.util.Map;

public class QueryMenuCategory {

	public static String queryCreate() {
		String sql = "create table MENUCATEGORY ("
				+ "KEYMC integer generated always as identity,"
				+ "NAMEMC varchar(40) default '' not null, " 
				+ "primary key (KEYMC))";
		return sql;
	}
	
//Запит на отримання вмісту таблиці БД
	public static String queryGetAll() {
		return "select * from MENUCATEGORY";
	}

	//Запит на додавння 
	public static String queryAdd(Map<String, Object> map) {	
		return String.format("insert into MENUCATEGORY"
				+ "(NAMEMC) "
				+ "values('%s')",
				map.get("namemc")); 
	}

	//Запит на редагування 
	public static String queryEdit(Map<String, Object> map) {	
		return String.format("update MENUCATEGORY"
				+ " set  NAMEMC = '%s' where KEYMC = %d",
				map.get("namemc"), map.get("keymc"));
	}

	//Запит на видалення 
	public static String queryDelById(int keymc) {	
		return "DELETE FROM MENUCATEGORY WHERE KEYMC = " + keymc;
	}	

}