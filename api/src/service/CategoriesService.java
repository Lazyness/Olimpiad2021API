package service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/categories")
public class CategoriesService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getList() {
		return "Test done!";
		
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String getById(@QueryParam("CATEGORY_ID") String id) {
		return "Test done!" + id;
		
	}
}
