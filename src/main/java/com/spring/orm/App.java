package com.spring.orm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.spring.orm.dao.StudentDao;
import com.spring.orm.entity.Certificate;
import com.spring.orm.entity.Student;

/*
 * Hibernate Framework --
 * Hibernate is Java framework that simplifies the development of Java appln to interact with DB.
 * Hibernate is an object–relational mapping (ORM) tool.
 * Hibernate implements the specifications of JPA (Java Persistence API) for data persistence.
 * It is invented by Gavin King in 2011.
 * 
 * ORM Framework --
 * ORM is a programming technique that maps the object to the data stored in the database.
 * Example: Hibernate, Toplink, iBATIS
 * 
 * get() vs load() --
 * get() returns null if object is not found in session cache or database, while load() throws ObjectNotFoundException.
 * get() loads data on the spot (Eager loading) while load() loads data only when we explicitly call get or set method (Lazy loading) 
 * 
 * Hibernate Lifecycle state --
 * Transient - when we create new entity object
 * Persistent - when object is associated with session and database (session.save)
 * Detached - when object is associated with database but not with session (session.close)
 * Removed - when object is associated with session but not with database (session.delete)
 * 
 * Caching --
 * Caching is mechanism to enhance performance of application
 * Cache is used to reduce number of DB queries
 * First Level (default) - associated with session object
 * Second Level - associated with SessionFactory object
 *  
 */

public class App {

	public static void main(String[] args) throws Exception {
		
		System.out.println( "Hello World!" );
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		
		Student student = new Student(1, "Anil Jesrani", "Kolhapur");
		studentDao.insert(student);
		System.out.println( "Record inserted!!!" );
		
		System.out.println( "-------------------------------------------------" );
		
		/*System.out.println( "Hibernate" );
		SessionFactory factory = new Configuration().configure("com/spring/orm/hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		*/
		/*
		// when creating only 1 entity using @Embeddable
		Student student = new Student(1, "Anil Jesrani", "Kolhapur");
		Certificate certificate = new Certificate(10, "Andriod", "2M");
		student.setCertificate(certificate);
		session.save(student);
		*/
		
		/*
		// @OneToOne (can be unidirectional and bidirectional)
		Student student = new Student(1, "Anil Jesrani", "Kolhapur");
		Certificate certificate = new Certificate(10, "Andriod", "2M");
		certificate.setStudent(student);
		student.setCertificate(certificate);
		session.save(certificate);
		session.save(student);
		*/
		
		/*
		// @OneToMany and @ManyToOne
		Student student = new Student(1, "Anil Jesrani", "Kolhapur");
		Certificate certificate1 = new Certificate(10, "Andriod", "2M");
		Certificate certificate2 = new Certificate(20, "Java", "3M");
		certificate1.setStudent(student);
		certificate2.setStudent(student);
		student.setCertificate(new ArrayList<Certificate>(Arrays.asList(certificate1, certificate2)));
		session.save(certificate1);			// no need to save explicitly if set CascadeType.ALL
		session.save(certificate2);
		session.save(student);
		*/
		
		/*
		// @ManyToMany
		Student student1 = new Student(1, "Anil Jesrani", "Kolhapur");
		Student student2 = new Student(2, "Nitin Gore", "Amravati");
		Certificate certificate1 = new Certificate(10, "Andriod", "2M");
		Certificate certificate2 = new Certificate(20, "Java", "3M");
		List<Student> students = new ArrayList<Student>(Arrays.asList(student1, student2));
		List<Certificate> certificates = new ArrayList<Certificate>(Arrays.asList(certificate1, certificate2));
		student1.setCertificate(certificates);
		certificate1.setStudent(students);
		session.save(certificate1);
		session.save(certificate2);
		session.save(student1);
		session.save(student2);
		*/
		
		// select
		//Student obj = (Student) session.get(Student.class, 1);
		//Student obj = (Student) session.load(Student.class, 1);
		//System.out.println(obj);
		/*
		// HQL
		Student student1 = new Student(1, "Anil Jesrani", "Kolhapur");
		Student student2 = new Student(2, "Nitin Hirani", "Kolhapur");
		Student student3 = new Student(3, "Nitin Gore", "Nanded");
		session.save(student1);
		session.save(student2);
		session.save(student3);
		
		//String query = "from Student where city='Kolhapur'";
		//String squery = "from Student where city=:ct";
		String squery = "from Student";
		Query q1 = session.createQuery(squery);
		//q1.setParameter("ct", "Kolhapur");
		//q1.setFirstResult(0);
		//q1.setMaxResults(2);
		List<Student> students = q1.getResultList();
		for(Student s : students)
			System.out.println(s);
		
		String dquery = "delete from Student as s where s.city='Nanded'";
		//String uquery = "update from Student set city='Amravati' where name='Nitin Gore'";
		//Query q2 = session.createQuery(dquery);
		//int result = q2.executeUpdate();
		//System.out.println("Deleted records: " + result);

		String jquery = "select s.name, c.course from Student s INNER JOIN s.certificate as c";
		Query q3 = session.createQuery(jquery);
		//List<Object []> slist = q3.getResultList();
		//for(Object [] s : slist)
		//	System.out.println(Arrays.toString(s));
		
		//Native SQL
		//String query = "select * from Student";
		//NativeQuery nq = session.createSQLQuery(query);
		
		//Criteria API
		Criteria cc = session.createCriteria(Student.class);
		//cc.add(Restrictions.eq("city", "Nanded"));
		cc.add(Restrictions.gt("id", 2));
		List<Student> cs = cc.list();
		for(Student s : cs)
			System.out.println(s);

		tx.commit();
		session.close();
*/
	}

}
