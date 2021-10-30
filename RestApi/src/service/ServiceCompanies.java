package service;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.sun.javafx.fxml.ParseTraceElement;

import controller.Controller;
import controller.DbConnector;

@Path("/companies")
public class ServiceCompanies {
	private String db = "d:/1/dbByv";
	private String table = "companies";
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String getList() {
		DbConnector.setPathToDb(db);
		if (!Controller.tableExist(table.toUpperCase())) {
			System.out.println("Table " + table + " is exist!".toString());
			List<Map<String, Object>> mapList = 
					Controller.executeQuery("select * from NAME_TABLE");
			return mapList.toString();
		} else {
			return "Table " + table + " was not exist!".toString();
		}
//		return "Test done!";
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String getInfoOnId(	
				@QueryParam("company_id") String id) {
		
		DbConnector.setPathToDb(db);
		if (!Controller.tableExist(table.toUpperCase())) {
			System.out.println("Table " + table + " is exist!".toString());
			List<Map<String, Object>> mapList = 
					Controller.executeQuery("select * from NAME_TABLE where id="+id);
			return mapList.toString();
		} else {
			return "Table " + table + " was not exist!".toString();
		}
	}


}