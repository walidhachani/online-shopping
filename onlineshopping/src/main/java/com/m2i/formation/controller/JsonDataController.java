package com.m2i.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m2i.formation.shoppingbackend.dao.ProductDAO;
import com.m2i.formation.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	ProductDAO productDAO ;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		
		return productDAO.listActiveProduct() ; 
	}
	
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getAllProductsbyCategory(@PathVariable int id){
		
		return productDAO.listActiveProductByCategory(id) ; 
	}

}
