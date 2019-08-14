package com.mounika.employeemanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mounika.employeemanagement.dao.EmployeeDao;
import com.mounika.employeemanagement.dao.impl.EmployeeDaoImpl;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.mounika.employeemanagement")
public class Config extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setViewClass(JstlView.class);

		viewResolver.setPrefix("/WEB-INF/Views/");

		viewResolver.setSuffix(".jsp");

		return viewResolver;

	}
	@Bean
	public EmployeeDao employeeDao()
	{
		EmployeeDao employeeDao=new EmployeeDaoImpl();
		return employeeDao;
	}
	@Override

	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

		configurer.enable();

	}
}
