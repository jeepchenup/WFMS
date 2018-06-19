package com.wfms.spring.mvc.annotation.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;

import com.wfms.spring.mvc.annotation.cutomer.MyServlet;

public class MyServletInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//init customer servlet
		Dynamic customerServlet = servletContext.addServlet("myServlet", MyServlet.class);
		customerServlet.addMapping("/customer/**");
		
	}

}
