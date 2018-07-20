package com.m2i.formation.exception;

import org.hibernate.cfg.annotations.NamedProcedureCallDefinition;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoFoundException() {
		
		ModelAndView mv = new ModelAndView("error") ;
		
		mv.addObject("errorTitle", "the page is not constructed !") ;
		mv.addObject("errorDescription" , "the page you are looking for is not availble !") ; 
		mv.addObject("title", "404 Error Page") ; 
		
			
		return mv;
		
	}
	
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView productNoFoundException() {
		
		ModelAndView mv = new ModelAndView("error") ;
		
		mv.addObject("errorTitle", " Product not available!") ;
		mv.addObject("errorDescription" , "the product you are looking for is not availble right now !") ; 
		mv.addObject("title", "404 product not found ") ; 
		
			
		return mv;
		
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView Exception(Exception ex) {
		
		ModelAndView mv = new ModelAndView("error") ;
		
		mv.addObject("errorTitle", " contact the administrator") ;
		mv.addObject("errorDescription" ,ex.toString() ) ; 
		mv.addObject("title","error" ) ; 
		
			
		return mv;
		
	}
	
	
	

}
