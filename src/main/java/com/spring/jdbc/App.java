package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.SpringConfiguration;
import com.spring.jdbc.dao.TeamDao;
import com.spring.jdbc.entity.Team;


public class App {

	public static void main(String[] args) {
		
		System.out.println( "Hello World!" );
		//ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		
		/*
		//insert query
		JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
		String query = "insert into team(first_name, last_name, sex, age) values(?, ?, ?, ?)";
		int result = jdbcTemplate.update(query, "Nitin", "Gore", "M", 28);
		System.out.println("Number of records inserted: " + result);
		*/
		
		TeamDao teamDao = context.getBean("teamDao", TeamDao.class);
		
		//Team team = new Team("Rohini", "Tattee", "F", 26);
		//int result = teamDao.insert(team);
		//int result = teamDao.change(team);
		//int result = teamDao.delete(28);
		//System.out.println("Number of records inserted/updated/deleted: " + result);
		
		Team team = teamDao.getTeam(26);
		System.out.println(team);
		
		List<Team> teams = teamDao.getAllTeam();
		System.out.println(teams);
	}

}
