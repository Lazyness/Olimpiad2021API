package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import controller.Controller;

@Path("/categories")
public class CategoriesService {
	
	private String table = "MENUCATEGORY";
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getById(
			@QueryParam("category_id") String id
		) 
	{	
			System.out.println("Table " + table + " is exist!".toString());
			List<Map<String, Object>> mapList = new ArrayList();;
			if(id != null)
				mapList= Controller.executeQuery("select * from " + table + " where keymc="+id);
			else
				mapList= Controller.executeQuery("select * from " + table);
			return mapList.toString();	
	}
}
