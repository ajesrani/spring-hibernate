package com.spring.orm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/*@Embeddable*/
@Entity
public class Certificate {
	
	@Id
	@Column(name="CERTIFICATE_ID")
	private int id;
	private String course;
	private String duration;
	
	/*@OneToOne(mappedBy = "certificate")
	private Student student;*/
	
	/*@ManyToOne
	private Student student;*/
	
	//@ManyToMany(mappedBy = "certificate")
	private List<Student> student;

	public Certificate() {
		super();
	}

	public Certificate(int id, String course, String duration) {
		super();
		this.id = id;
		this.course = course;
		this.duration = duration;
	}
	
	/*public void setStudent(Student student) {
		this.student = student;
	}*/
	
	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Certificate [id=" + id + ", course=" + course + ", duration=" + duration + "]";
	}	

}
