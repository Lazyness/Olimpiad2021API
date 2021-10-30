package service;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.sun.javafx.fxml.ParseTraceElement;

import controller.Controller;
import controller.DbConnector;

@Path("/dishes")
public class DishesService {
	
	private String table = "dish";
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getInfoOnId(	
				@QueryParam("dish_id") String id,
				@QueryParam("categories_id") String mid
				) {	
		System.out.println("Table " + table + " is exist!".toString());
		List<Map<String, Object>> mapList = new ArrayList();;
		if(id != null)
			mapList= Controller.executeQuery("select * from " + table + " where keydish="+id);
		if(mid != null)
			mapList = Controller.executeQuery("select * from " + table +" where keymc="+id);
		if(mid == null && id == null)
			mapList = Controller.executeQuery("select * from " + table);
		return mapList.toString();
	}

}
