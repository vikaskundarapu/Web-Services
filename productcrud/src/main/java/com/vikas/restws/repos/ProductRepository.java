package com.vikas.restws.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikas.restws.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
