package com.spring.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*@Component("personObject")*/
@Component
@Scope("prototype")
public class Person {
	
	/*@Value("Anil Jesrani")*/
	@Value("#{ new java.lang.String('Anil Jesrani') }")
	private String name;

	@Value("#{ T(java.lang.Math).sqrt(900) }")
	private int age;
	
	@Value("#{ T(java.lang.Math).PI }")
	private double pi;
	
	@Value("#{addressType}")
	private List<String> addressType;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getPi() {
		return pi;
	}
	public void setPi(double pi) {
		this.pi = pi;
	}
	public List<String> getAddressType() {
		return addressType;
	}
	public void setAddressType(List<String> addressType) {
		this.addressType = addressType;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", pi=" + pi + ", addressType=" + addressType + "]";
	}
	

}
