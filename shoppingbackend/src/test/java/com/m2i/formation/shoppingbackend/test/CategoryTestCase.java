
package com.m2i.formation.shoppingbackend.test;

import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.m2i.formation.shoppingbackend.dao.CategoryDAO;
import com.m2i.formation.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.m2i.formation.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	
	@Test
	public void testAddCategory() {
		Category category = new Category() ;
		category.setName("Televison");
		category.setDescription("some description tv");
		category.setImgUrl("tv.png");
		
		
		assertEquals("successfuly added to database", true, categoryDAO.add(category));
		
	}
	

}
