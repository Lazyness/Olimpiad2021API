package testApi;

import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class test {
	
	private static String address = "http://localhost:8080/api/";
	
	private static HttpClient httpClient = HttpClientBuilder.create().build();
	
	public static String executeRequest(HttpRequestBase request){	
		try {
			HttpResponse response = httpClient.execute(request);
			int code = response.getStatusLine().getStatusCode();
			if (code != 200)
				return "ERROR! "+response.getStatusLine().toString();
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity);		
		} catch (Exception e) {
			return "ERROR! "+e.getStackTrace()[0].toString();
		}
	}
	
	public static void testRequestGet(String request){	
		request = address + request;
		try {	
			URIBuilder bd = new URIBuilder(request);
			System.out.println(executeRequest(new HttpGet(bd.build())));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public static String testRequestPost(String request, Map<String, Object> map){	
		request = address + request;
		System.out.println(request);
		try {
			URIBuilder bd = new URIBuilder(request);
			for (String key : map.keySet()) {
				bd.addParameter(key, map.get(key).toString());
			}
			String res = executeRequest(new HttpPost(bd.build()));
			System.out.println(res);
			return res;
							
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args){
		System.out.println("Test 1:");
		testRequestGet("companies");
		
		System.out.println("Test 2:");
		testRequestGet("companies?company_id=0");
		
		System.out.println("Test 3:");
		testRequestGet("companies?company_id=1");
		
		System.out.println("Test 4:");
		testRequestGet("categories");
		
		System.out.println("Test 5:");
		testRequestGet("categories?category_id=0");
		
		System.out.println("Test 6:");
		testRequestGet("categories?category_id=1");
		
		System.out.println("Test 7:");
		testRequestGet("dishes");
		
		System.out.println("Test 8:");
		testRequestGet("dishes?dish_id=0");
		
		System.out.println("Test 9:");
		testRequestGet("dishes?dish_id=1");
		
		Map<String, Object> map;
		String res; 
		JSONArray ar;
		JSONObject obj;
		

		try {
			System.out.println("Test 10:");
			map = new LinkedHashMap();
			map.put("id", 0);
			map.put("name", "test");
			res = testRequestPost("orders", map);
			
			System.out.println("Test 12:");
			ar = new JSONArray(res);
			obj = (JSONObject) ar.get(0);
			testRequestGet("orders?order_id=" + obj.getInt("id"));
			
			map = new LinkedHashMap();
			map.put("id", 0);
			map.put("name", "test");
			res = testRequestPost("orders", map);
			
			System.out.println("Test 13:");
			ar = new JSONArray(res);
			obj = (JSONObject) ar.get(0);
			testRequestGet("orders?order_id=" + obj.getInt("id"));
			
			map = new LinkedHashMap();
			map.put("id", 0);
			map.put("name", "test");
			res = testRequestPost("orders", map);
			
			map = new LinkedHashMap();
			map.put("id", 0);
			map.put("name", "test");
			res = testRequestPost("orders", map);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
}
