package com.spring.core;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Address implements InitializingBean, DisposableBean {
	
	private String country;
	private Properties props;
	private List<String> type;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String country, Properties props, List<String> type) {
		super();
		this.country = country;
		this.props = props;
		this.type = type;
		
		System.out.println("Address::Address(String, Properties, List)");
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Address::afterPropertiesSet()");
	}
	
	public void destroy() throws Exception {
		System.out.println("Address::destroy()");
	}
	
	@Override
	public String toString() {
		return "Address [country=" + country + ", props=" + props + ", type=" + type + "]";
	}

}
