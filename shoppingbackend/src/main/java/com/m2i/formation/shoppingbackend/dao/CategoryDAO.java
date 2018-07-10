package com.m2i.formation.shoppingbackend.dao;

import java.util.List;

import com.m2i.formation.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list() ; 
	
	Category get(int id) ; 
	
	boolean add(Category category) ;

}
