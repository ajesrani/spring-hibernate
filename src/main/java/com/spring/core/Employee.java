package com.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/*
 * We can implement dependency injection with:
 * constructor-based injection
 * setter-based injection
 * field-based injection.
 */

public class Employee {
	
	@Autowired
	@Qualifier("addressObject")
	private Address address;
	
	public Employee() {
		super();
		System.out.println("Employee::Employee()");
	}

	/*@Autowired*/
	public Employee(Address address) {
		super();
		this.address = address;
	}
	
	public Address getAddress() {
		return address;
	}
	
	/*@Autowired*/
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Employee [address=" + address + "]";
	}

}
