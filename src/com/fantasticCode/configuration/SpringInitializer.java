package com.fantasticCode.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(SpringConfiguration.class);
		ctx.setServletContext(container);
		ServletRegistration.Dynamic servlet = container.addServlet("spring-software", new DispatcherServlet(ctx));
		// Indica el mapeo inicial de la apliacion URL de la app.
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);

	}

}