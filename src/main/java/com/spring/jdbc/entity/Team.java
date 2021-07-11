package com.spring.jdbc.entity;

public class Team {
	
	private String firstName;
	private String lastName;
	private String sex;
	private int age;

	public Team() {
		super();
	}

	public Team(String firstName, String lastName, String sex, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", sex=" + sex + ", age=" + age + "]";
	}

}
