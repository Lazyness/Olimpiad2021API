package service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/orders")
public class OrdersService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String get() {
		return "Test done!";
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String post() {
		return "Post done!";
	}

}
