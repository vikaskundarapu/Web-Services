package com.vikas.restws;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.vikas.restws.entities.Product;
import com.vikas.restws.repos.ProductRepository;

public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository repository;

	@Override
	public List<Product> getProducts() {
		return repository.findAll();
	}

	@Override
	public Product getProduct(int id) {
		return repository.findById(id).get();
	}

	@Override
	public Response createProduct(Product product) {
		Product savedProduct = repository.save(product);
		return Response.ok(savedProduct).build();
	}

	@Override
	public Response updateProduct(Product product) {
		Product savedProduct = repository.save(product);
		return Response.ok(savedProduct).build();
	}

	@Override
	public void deleteProduct(int id) {
		repository.deleteById(id);
		return ;
	}

}
