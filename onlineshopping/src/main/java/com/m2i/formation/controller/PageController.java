package com.m2i.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.m2i.formation.shoppingbackend.dao.CategoryDAO;
import com.m2i.formation.shoppingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO CategoryDAO;

	@RequestMapping(value = { "/", "/index", "/home" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "home");
		mv.addObject("userClickHome", true);

		// paste liste of category
		mv.addObject("listCat", CategoryDAO.list());

		return mv;

	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About us");
		mv.addObject("userClickAbout", true);
		return mv;

	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact us");
		mv.addObject("userClickContact", true);
		return mv;

	}

	/*
	 * 
	 * method to load all the products and based on category
	 * 
	 */

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);

		// paste liste of category
		mv.addObject("listCat", CategoryDAO.list());

		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {

		// method to fetch single category
		Category category = null;
		category = CategoryDAO.get(id);

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", category.getName());

		mv.addObject("userClickCategoryProducts", true);

		// paste liste of category
		mv.addObject("listCat", CategoryDAO.list());
		
		// paste the single category object
		mv.addObject("category", category);

		return mv;
	}

}
