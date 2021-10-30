package query;

import java.util.Map;

public class Query�ompositionOrder {

	//������ �� ��������� ������� ��
		public static String queryCreate() {	
			String sql ="create table �OMPOSITIONORDER ("
					+ "PRICECO integer default 0," 
					+ "KEYDISH int constraint FK_DISH1_CTH "
					+ "references DISH on delete cascade, " 
					+ "ORDERNUMBER int constraint FK_ORDERT1_CTH "
					+ "references ORDERT on delete cascade)";
			return sql;
		}


	//����� �� �������� 
	public static String queryAdd(Map<String, Object> map) {	
		return String.format("insert into �OMPOSITIONORDER"
				+ "(PRICECO, KEYDISH, ORDERNUMBER) "
				+ "values(%d, %d, %d)",
				map.get("priceco"), map.get("keydish"), 
				map.get("ordernumber"));
	}
}