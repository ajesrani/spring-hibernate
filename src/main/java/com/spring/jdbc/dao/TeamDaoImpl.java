package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entity.Team;

@Component("teamDao")
public class TeamDaoImpl implements TeamDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Team team) {
		//insert query
		String query = "insert into team(first_name, last_name, sex, age) values(?, ?, ?, ?)";
		int result = this.jdbcTemplate.update(query, team.getFirstName(), team.getLastName(), team.getSex(), team.getAge());
		return result;
	}
	
	public int change(Team team) {
		String query = "update team set first_name=? , last_name=? , sex=? where age=?";
		int result = this.jdbcTemplate.update(query, team.getFirstName(), team.getLastName(), team.getSex(), team.getAge());
		return result;
	}
	
	public int delete(int age) {
		String query = "delete from team where age=?";
		int result = this.jdbcTemplate.update(query, age);
		return result;
	}
	
	public Team getTeam(int age) {
		// Interface which helps to convert resultset object into java class object
		RowMapper<Team> rowMapper = new RowMapperImpl();
		
		String query = "select * from team where age=?";
		Team team = this.jdbcTemplate.queryForObject(query, rowMapper, age);
		return team;
	}

	public List<Team> getAllTeam() {
		String query = "select * from team";
		List<Team> teams = this.jdbcTemplate.query(query, new RowMapperImpl());
		return teams;
	}

}
