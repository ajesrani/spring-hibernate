package com.spring.core;

import org.springframework.stereotype.Component;

/*@Component*/
public class Annotation {
	
	private AnnService service;

	public Annotation(AnnService service) {
		super();
		this.service = service;
	}

	public AnnService getService() {
		return service;
	}

	public void setService(AnnService service) {
		this.service = service;
	}
	
}
