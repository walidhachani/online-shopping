package com.m2i.formation.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.m2i.formation.shoppingbackend.dto" })
@EnableTransactionManagement
public class HibernateConfig {

	private static final String DATABASE_URL = " jdbc:h2:tcp://localhost/~/onlineShopping";
	private static final String DATABASE_DRIVER = "org.h2.Driver";
	private static final String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialcet";
	private static final String DATABASE_USERNAME = "sa";
	private static final String DATABASE_PASSWORD = "";

	// dataSource bean will be available

	@Bean
	private DataSource getDataSource() {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(DATABASE_URL);
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);

		return dataSource;
	}

	// SessionFactory bean will be available

	@Bean
	private SessionFactory getSessionFatcory(DataSource dataSource) {

		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);

		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.m2i.formation.shoppingbackend.dto");
		return builder.buildSessionFactory();

	}

	
	// all the hibernate properties will be returned in this method
	private Properties getHibernateProperties() {
		
		Properties properties = new Properties() ;
		properties.put("hibernate.dialect", DATABASE_DIALECT) ; 
		properties.put("hibernate.show_sql", "true") ; 
		properties.put("hibernate.format_sql", "true") ; 
		
		
		return properties;
	}
	
	
	@Bean
	private HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory) ; 
		
	    return transactionManager ;	
	}
	

}
