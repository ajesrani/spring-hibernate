package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entity.Team;

public interface TeamDao {
	
	public int insert(Team team);
	
	public int change(Team team);
	
	public int delete(int age);
	
	public Team getTeam(int age);
	
	public List<Team> getAllTeam();

}
