package com.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
/*@ComponentScan(basePackages = "com.spring.core")*/
public class SpringConfiguration {
	
	@Bean
	public AnnService getAnnService() {
		AnnService service = new AnnService();
		return service;
	}
	
	/*@Bean(name = {"annotation", "annotationObject"})*/
	@Bean
	public Annotation getAnnotation() {
		Annotation annotation = new Annotation(getAnnService());
		return annotation;
	}

}
