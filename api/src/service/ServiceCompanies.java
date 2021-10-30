package service;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.sun.javafx.fxml.ParseTraceElement;

import controller.Controller;
import controller.DbConnector;

@Path("/companies")
public class ServiceCompanies {

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Test done!";
	}

	@GET
	@Path("/exist/{table}")
	@Produces(MediaType.TEXT_PLAIN)
	public String tableExist(@PathParam("table") String table, @QueryParam("db") String db) {
		DbConnector.setPathToDb(db);
		Boolean b = Controller.tableExist(table.toUpperCase());
		return b.toString();
	}

	@GET
	@Path("/create/{table}")
	@Produces(MediaType.TEXT_PLAIN)
	public String createTable(@PathParam("table") String table, @QueryParam("db") String db) {
		DbConnector.setPathToDb(db);
		if (!Controller.tableExist(table.toUpperCase())) {
			Controller.createTable(table);
			return "Table " + table + " was created!".toString();
		} else {
			return "Table " + table + " was not created!";
		}
	}
	
	@GET
	@Path("/execute/")
	@Produces(MediaType.TEXT_PLAIN)
	public String execute(	
				@QueryParam("db") String db,
				@QueryParam("query") String query) {
		
		DbConnector.setPathToDb(db);
		List<Map<String, Object>> mapList = 
				Controller.executeQuery(query);
		return mapList.toString();
	}

	@GET
	@Path("/update/")
	@Produces(MediaType.TEXT_PLAIN)
	public int update(	
				@QueryParam("db") String db,
				@QueryParam("query") String query) {
		
		DbConnector.setPathToDb(db);
		int n = Controller.executeUpdate(query);
		return n;
	}

}

@Path("/dishes")
class ServiceDishes {

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Test done!";
	}

	@GET
	@Path("/exist/{table}")
	@Produces(MediaType.TEXT_PLAIN)
	public String tableExist(@PathParam("table") String table, @QueryParam("db") String db) {
		DbConnector.setPathToDb(db);
		Boolean b = Controller.tableExist(table.toUpperCase());
		return b.toString();
	}

	@GET
	@Path("/create/{table}")
	@Produces(MediaType.TEXT_PLAIN)
	public String createTable(@PathParam("table") String table, @QueryParam("db") String db) {
		DbConnector.setPathToDb(db);
		if (!Controller.tableExist(table.toUpperCase())) {
			Controller.createTable(table);
			return "Table " + table + " was created!".toString();
		} else {
			return "Table " + table + " was not created!";
		}
	}
	
	@GET
	@Path("/execute/")
	@Produces(MediaType.TEXT_PLAIN)
	public String execute(	
				@QueryParam("db") String db,
				@QueryParam("query") String query) {
		
		DbConnector.setPathToDb(db);
		List<Map<String, Object>> mapList = 
				Controller.executeQuery(query);
		return mapList.toString();
	}

	@GET
	@Path("/update/")
	@Produces(MediaType.TEXT_PLAIN)
	public int update(	
				@QueryParam("db") String db,
				@QueryParam("query") String query) {
		
		DbConnector.setPathToDb(db);
		int n = Controller.executeUpdate(query);
		return n;
	}

}
