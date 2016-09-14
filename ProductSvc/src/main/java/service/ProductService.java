package service;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.security.access.annotation.Secured;

import dto.Product;
import dto.Products;

@Produces({"application/json"})
@Consumes({"application/json"})
public interface ProductService {

	
	@POST
	@Path("/product")
	public Response addProduct(Product product);
	
	//@Secured("ROLE_USER")
	@GET
	@Path("/product/{id}")
	public Product getProduct(@PathParam("id")int id);
	
	@PUT
	@Path("/product")
	public Product updateProduct(Product product);
	
	@DELETE
	@Path("/product/{id}")
	public Response deleteProduct(@PathParam("id")int id);
	
	
	@GET
	@Path("/products")
	public Products getProducts();
	
	//@Secured("ROLE_ADMIN")
	@GET
	@Path("/products")
	public Products getProductByID(@QueryParam("startID")int startID,@QueryParam("lastID")int lastID,@HeaderParam("agent") String agent,@Context HttpHeaders headers);
	
	@POST
	@Path("/product")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON,"application/x-www-form-urlencoded"})
	public void createProduct(@FormParam("productDesc")String productDesc);
	
	@GET
	@Path("/someCalc")
	public void doSomeCalc(@Suspended AsyncResponse response);
}
