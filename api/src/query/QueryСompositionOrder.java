package query;

import java.util.Map;

public class QueryСompositionOrder {

	//Запити на створення таблиці БД
		public static String queryCreate() {	
			String sql ="create table СOMPOSITIONORDER ("
					+ "PRICECO integer default 0," 
					+ "KEYDISH int constraint FK_DISH1_CTH "
					+ "references DISH on delete cascade, " 
					+ "ORDERNUMBER int constraint FK_ORDERT1_CTH "
					+ "references ORDERT on delete cascade)";
			return sql;
		}


	//Запит на додавння 
	public static String queryAdd(Map<String, Object> map) {	
		return String.format("insert into СOMPOSITIONORDER"
				+ "(PRICECO, KEYDISH, ORDERNUMBER) "
				+ "values(%d, %d, %d)",
				map.get("priceco"), map.get("keydish"), 
				map.get("ordernumber"));
	}
}