package com.fantasticCode.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//Indica que es una clase de configuracion.
@Configuration
//Habilita el framework MVC
@EnableWebMvc
//Indica los paquetes de la aplicacion.
@ComponentScan(basePackages = "com.fantasticCode")
public class SpringConfiguration implements WebMvcConfigurer {
	// Bean que indica la ubicacion por medio del prefio y el tipo de archivos a
	// utilizar con el sufijo .jsp.
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;

	}

	@Bean
	public MappingJackson2HttpMessageConverter jsonConverter() {
		return new MappingJackson2HttpMessageConverter();
	}

	// Permite el uso de la carpeta resources para imagenes,estilos etc.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

	}

}