package query;

import java.util.Map;

public class QueryInstitution {

	public static String queryCreate() {
		String sql = "create table INSTITUTION ("
				+ "KEYINST integer generated always as identity,"
				+ "NAMEINST varchar(40) default '' not null, " 
				+ "DESCRIPTIONINST varchar(500) default '', "
				+ "primary key (KEYINST))";
		return sql;
	}
	
//����� �� ��������� ����� ������� ��
	public static String queryGetAll() {
		return "select * from INSTITUTION";
	}

	//����� �� �������� 
	public static String queryAdd(Map<String, Object> map) {	
		return String.format("insert into INSTITUTION"
				+ "(NAMEINST, DESCRIPTIONINST) "
				+ "values('%s', '%s')",
				map.get("nameinst"), map.get("descriptioninst")); 
	}

	//����� �� ����������� 
	public static String queryEdit(Map<String, Object> map) {	
		return String.format("update INSTITUTION"
				+ " set  NAMEINST = '%s', DESCRIPTIONINST = '%s' where KEYINST = %d",
				map.get("nameinst"), map.get("descriptioninst"), 
				map.get("keyinst"));
	}

	//����� �� ��������� 
	public static String queryDelById(int keyinst) {	
		return "DELETE FROM INSTITUTION WHERE KEYINST = " + keyinst;
	}	

}