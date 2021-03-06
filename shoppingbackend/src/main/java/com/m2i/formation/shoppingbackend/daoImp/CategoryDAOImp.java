package com.m2i.formation.shoppingbackend.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.formation.shoppingbackend.dao.CategoryDAO;
import com.m2i.formation.shoppingbackend.dto.Category;

@Repository(value = "categoryDAO")
@Transactional
@Service

public class CategoryDAOImp implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * private static List<Category> categories = new ArrayList<>();
	 * 
	 * static {
	 * 
	 * add first category Category category = new Category(); category.setId(1);
	 * category.setName("Televison");
	 * category.setDescription("some description tv"); category.setImgUrl("tv.png");
	 * 
	 * categories.add(category);
	 * 
	 * add second category Category category2 = new Category(); category2.setId(2);
	 * category2.setName("Telephone");
	 * category2.setDescription("some description phone");
	 * category2.setImgUrl("phone.png");
	 * 
	 * categories.add(category2);
	 * 
	 * add third category Category category3 = new Category(); category3.setId(3);
	 * category3.setName("watch");
	 * category3.setDescription("some description watch");
	 * category3.setImgUrl("watch.png");
	 * 
	 * categories.add(category3);
	 * 
	 * add another category Category category4 = new Category(); category4.setId(4);
	 * category4.setName("sport");
	 * category4.setDescription("some description watch");
	 * category4.setImgUrl("watch.png");
	 * 
	 * categories.add(category4);
	 * 
	 * }
	 */

	@Override
	public List<Category> list() {

		String activeCategory = "FROM Category WHERE active = :active";

		org.hibernate.query.Query query = sessionFactory.getCurrentSession().createQuery(activeCategory);

		query.setParameter("active", true);

		return query.getResultList();
	}

	/*
	 * method to get a single category based on id
	 *
	 */
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		try {
			// add the cateory to the database
			sessionFactory.getCurrentSession().persist(category);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * updating a single category
	 */

	@Override
	public boolean update(Category category) {
		try {
			//
			sessionFactory.getCurrentSession().update(category);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {

		category.setActive(false);

		try {
			//
			sessionFactory.getCurrentSession().update(category);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
