package com.m2i.formation.shoppingbackend.daoImp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.formation.shoppingbackend.dao.ProductDAO;
import com.m2i.formation.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImp implements ProductDAO {

	@Autowired
	private SessionFactory SessionFactory;

	@Override
	public Product get(int id) {
		try {
			return SessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Product> list() {
		return SessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
	}

	@Override
	public boolean add(Product product) {
		try {
			 SessionFactory.getCurrentSession().persist(product);
			 return true ;

		} catch (Exception e) {
			e.printStackTrace();
			return false ; 
		}

		
		
		
	}

	@Override
	public boolean update(Product product) {
		try {
			 SessionFactory.getCurrentSession().update(product);
			 return true ;

		} catch (Exception e) {
			e.printStackTrace();
			return false ; 
		}
	}

	@Override
	public boolean delete(Product product) {
		
		 product.setActive(false);
		try {
			
			 SessionFactory.getCurrentSession().update(product);
			 return true ;

		} catch (Exception e) {
			e.printStackTrace();
			return false ; 
		}
	}

	@Override
	public List<Product> listActiveProduct() {
		String listActive ="FROM Product WHERE active = :active" ;
		return SessionFactory.getCurrentSession()
				.createQuery(listActive, Product.class)
				.setParameter("active", true)
				.getResultList();
	}

	@Override
	public List<Product> listActiveProductByCategory(int categorId) {
		String listActiveByCategory ="FROM Product WHERE active = :active AND categoryId = :categoryId" ;
		return SessionFactory.getCurrentSession()
				.createQuery(listActiveByCategory, Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categorId)
				.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return SessionFactory.getCurrentSession()
				.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
