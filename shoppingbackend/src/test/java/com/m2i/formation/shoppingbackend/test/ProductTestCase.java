
package com.m2i.formation.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.m2i.formation.shoppingbackend.dao.ProductDAO;
import com.m2i.formation.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context ; 
	private static ProductDAO productDAO ; 
	
	private Product product ; 
	
	@BeforeClass
	public static void init() {
		
		context= new AnnotationConfigApplicationContext() ; 
		context.scan("com.m2i.formation.shoppingbackend");
		context.refresh();
		
		productDAO=(ProductDAO) context.getBean("productDAO") ; 
	}
	
	
	/*@Test
	public void testCRUDProduct() {
		
		
		product= new Product() ; 
		product.setName("galaxy j5");
		product.setBrand("galaxy");
		product.setDescription("some description of j5");
		product.setUnitPrice(1500);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("something wrent wrong while adding product", true, productDAO.add(product));
		
		// reading and updating 
		
		product = productDAO.get(2) ; 
		assertEquals("something wrent wrong while updating product", true, productDAO.update(product));
		assertEquals("something wrent wrong while deleting product", true, productDAO.delete(product));
		 
		
		// list
		assertEquals("something wrent wrong while fetching list of product",6,productDAO.list().size());
	}
	*/
	
	
/*	@Test
	public void testDeleteProduct() {
		product= productDAO.get(3) ; 
		assertEquals("something wrent wrong while deleting ", true, productDAO.delete(product));
		
	}*/
	
	
	@Test
	public void testListActiveProduct() {
		assertEquals("something wrent wrong while fetching list of product",5,productDAO.listActiveProduct().size());
		
	}
	
	

	@Test
	public void testListActiveProductByCategory() {
		assertEquals("something wrent wrong while fetching list of product by cat",2,productDAO.listActiveProductByCategory(1).size());
		
	}

	
}
