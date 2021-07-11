package com.spring.orm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entity.Student;

@Component
public class StudentDao {
	
	/*@Autowired*/
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public void insert(Student student)
	{
		hibernateTemplate.save(student);
		//hibernateTemplate.saveOrUpdate(student);
	}
	
	@Transactional
	public void delete(int id)
	{
		Student student = hibernateTemplate.get(Student.class, id);
		hibernateTemplate.delete(student);
	}
	
	@Transactional
	public void update(Student student)
	{
		hibernateTemplate.update(student);
	}
	
	public Student getStudent(int id)
	{
		Student student = hibernateTemplate.get(Student.class, id);
		return student;
	}
	
	public List<Student> getAllStudent()
	{
		List<Student> student = hibernateTemplate.loadAll(Student.class);
		return student;
	}

}
