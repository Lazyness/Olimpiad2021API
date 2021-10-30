package query;

public class Query {
	
	public static String query1(int place) {	
		return String.format("SELECT * FROM RAILWAY WHERE PLACE = %d",place);
	}
	
	public static String query2(int distance) {	
		return String.format("SELECT * FROM DIRECTION WHERE DIRECTION.DISTANCE > %d",distance);
	}

}
