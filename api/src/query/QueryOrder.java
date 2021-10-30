package query;

import java.util.Map;

public class QueryOrder {

	//Запити на створення таблиці БД
		public static String queryCreate() {	
			String sql ="create table ORDERT ("
					+ "ORDERNUMBER int generated always as identity,"
					+ "ORDERPRICE integer default 0," 
					+ "PHONENUMBER varchar(45) default '' not null,"
					+ "CLIENTNAME varchar(45) default '' not null,"
					+ "KEYINST int constraint FK_ORDERT_CTH "
					+ "references INSTITUTION on delete cascade, " 
					+ "primary key (KEYINST))";
			return sql;
		}
	
//Запит на отримання вмісту таблиці БД
	public static String queryGetAll() {
		return "select ORDERT.ORDERNUMBER, ORDERT.ORDERPRICE, ORDERT.PHONENUMBER, ORDERT.CLIENTNAME,"
				+ " INSTITUTION.NAMEINST AS INSTITUTION, "
				+ " INSTITUTION.KEYINST AS KEYINST"
				+ " from ORDERT, INSTITUTION "
				+ "WHERE INSTITUTION.ORDERNUMBER=ORDERT.KEYINST "
				+ " ORDERT BY INSTITUTION";
	}

	//Запит на додавння 
	public static String queryAdd(Map<String, Object> map) {	
		return String.format("insert into ORDERT"
				+ "(ORDERPRICE, PHONENUMBER, CLIENTNAME, KEYINST) "
				+ "values(%d, '%s', '%s', %d)",
				map.get("orderprice"), map.get("phonenumber"), 
				map.get("clientname"), map.get("keyinst"));
	}

	//Запит на редагування 
	public static String queryEdit(Map<String, Object> map) {	
		return String.format("update ORDERT"
				+ " set  ORDERPRICE = %d, PHONENUMBER = '%s', CLIENTNAME = '%s', "
				+ "KEYINST = %d where ORDERNUMBER = %d",
				map.get("orderprice"), map.get("phonenumber"),
				map.get("clientname"), map.get("keyinst"), map.get("ordernumber"));
	}

	//Запит на видалення 
	public static String queryDelById(int ordernumber) {	
		return "DELETE FROM ORDERT WHERE ORDERNUMBER = " + ordernumber;
	}	
}