package service;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.sun.javafx.fxml.ParseTraceElement;

import controller.Controller;
import controller.DbConnector;

@Path("/companies")
public class CompaniesService {

	private String table = "institution";
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getInfoOnId(	
				@QueryParam("company_id") String id) {
		System.out.println("Table " + table + " is exist!".toString());
		List<Map<String, Object>> mapList = new ArrayList();;
		if(id == null) {
			mapList = Controller.executeQuery("select * from " + table);
		}else {
			mapList = Controller.executeQuery("select * from " + table + " where keyinst="+id);
		}
		return mapList.toString();
	}


}