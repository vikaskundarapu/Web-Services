package com.vikas.restws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.http.ResponseEntity;

import com.vikas.restws.entities.Product;

@Consumes("application/json")
@Produces("application/json")
@Path("productservice")
public interface ProductService {

	@GET
	@Path("/products")
	List<Product> getProducts();

	@GET
	@Path("/products/{id}")
	Product getProduct(@PathParam(value = "id") int id);

	@POST
	@Path("/products")
	Response createProduct(Product product);

	@PUT
	@Path("/products")
	Response updateProduct(Product product);

	@DELETE
	@Path("/products/{id}")
	void deleteProduct(@PathParam("id") int id);
}
