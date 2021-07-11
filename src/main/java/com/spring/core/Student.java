package com.spring.core;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Student implements ApplicationContextAware {
	
	private int id;
	private String name;
	private Address address;
	private List<String> phones;
	private Map<String,String> courses;
	
	@Autowired
    private ObjectFactory<Address> prototypeBeanObjectFactory;
	private ApplicationContext applicationContext;
	

	public Student() {
		super();
		System.out.println("Student::Student()");
	}

	public Student(int id, String name, Address address, List<String> phones, Map<String, String> courses) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phones = phones;
		this.courses = courses;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	//@Lookup    // 1. solve Injecting Prototype bean into a Singleton bean (method injection)
	public Address getAddress() {
		//return prototypeBeanObjectFactory.getObject();    // 2. solve Injecting Prototype bean into a Singleton bean (ObjectFactory)
		//return applicationContext.getBean(Address.class);    // 3. solve Injecting Prototype bean into a Singleton bean (ApplicationContextAware)
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getPhones() {
		return phones;
	}
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}
	public Map<String, String> getCourses() {
		return courses;
	}
	public void setCourses(Map<String, String> courses) {
		this.courses = courses;
	}
	
	public void init() {
		System.out.println("Student::init()");
	}
	
	public void destroy() {
		System.out.println("Student::destroy()");
	}
	
	/*
	@PostConstruct
	public void init() {
		System.out.println("Student::init()");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("Student::destroy()");
	}
	*/

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", phones=" + phones + ", courses="
				+ courses + "]";
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
