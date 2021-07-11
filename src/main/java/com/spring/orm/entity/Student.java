package com.spring.orm.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="STUDENT")
public class Student {
	
	@Id
	@Column(name="STUDENT_ID")
	/*@GeneratedValue(strategy = GenerationType.AUTO)*/
	private int id;
	
	@Column(length=50, name="NAME")
	private String name;

	@Column(name="CITY")
	private String city;
	
	@Column(name="DATE")
	@Temporal(TemporalType.DATE)
	@Transient
	private Date date;
	
	@Lob
	@Transient
	private byte[] image;
	
	/*@OneToOne
	@JoinColumn(name="CERT_ID")
	private Certificate certificate;*/

	// Default - FetchType.LAZY
	//@OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//private List<Certificate> certificate;
	
	//@ManyToMany
	//@JoinTable(name="STUDENT_CERTIFICATE") 
	//private List<Certificate> certificate;

	public Student() {
		super();
	}

	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	/*public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}*/
	
	/*public void setCertificate(List<Certificate> certificate) {
		this.certificate = certificate;
	}*/

	@Override
	public String toString() {
		//return "Student [id=" + id + ", name=" + name + ", city=" + city + ", certificate=" + certificate + "]";
		return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
	}	

}
