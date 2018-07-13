package com.m2i.formation.shoppingbackend.dao;

import java.util.List;

import com.m2i.formation.shoppingbackend.dto.Product;

public interface ProductDAO {

	// crud methods
	Product get(int id);

	List<Product> list();

	boolean add(Product product);

	boolean update(Product product);

	boolean delete(Product product);

	// business methods

	List<Product> listActiveProduct() ;
	List<Product> listActiveProductByCategory(int categorId) ; 
	List<Product> getLatestActiveProducts(int count) ; 
	
}
