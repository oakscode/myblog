package com.oakscode.spring.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.oakscode.spring.dao.AdminDao;
import com.oakscode.spring.dao.AdminDaoImpl;

@Configuration
@ComponentScan(basePackages = "com.oakscode.spring")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/assets/**").addResourceLocations("/resources/assets/");
		registry.addResourceHandler("/ckeditor/**").addResourceLocations("/resources/ckeditor/");
		registry.addResourceHandler("/starters/**").addResourceLocations("/resources/starter/");
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		
		
		  dataSource.setUrl("jdbc:mysql://localhost:3306/oakscode");
		  dataSource.setUsername("admin"); 
		  dataSource.setPassword("root");
		 
		 

		
//		  dataSource.setUrl("jdbc:mysql://192.168.5.115:3306/oakscode");
//		  dataSource.setUsername("vishnu"); 
//		  dataSource.setPassword("vishnu123");
		 

		return dataSource;
	}

	@Bean
	public AdminDao getAdminDao() {
		return new AdminDaoImpl(getDataSource());
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver() throws IOException {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();

		// Set the maximum allowed size (in bytes) for each individual file.
		resolver.setMaxUploadSize(5242880);// 5MB

		// You may also set other available properties.

		return resolver;
	}

}
