package com.rh.innovation.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.rh.innovation.config.SecurityConfig;

@SpringBootApplication
public class RHInnovationApplication implements WebApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RHInnovationApplication.class, args);
	}

	public void onStartup(ServletContext servletContext,
			String filtro,
			String springSecurityFilter) throws ServletException {
		AnnotationConfigApplicationContext root = new 
				AnnotationConfigApplicationContext();
		
		root.register(SecurityConfig.class);
		servletContext.addListener(new ContextLoaderListener((WebApplicationContext) root));
		
		servletContext.addFilter(filtro, new DelegatingFilterProxy(springSecurityFilter))
			.addMappingForUrlPatterns(null, false, "/*");
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}