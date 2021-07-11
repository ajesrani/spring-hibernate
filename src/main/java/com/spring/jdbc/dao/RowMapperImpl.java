package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entity.Team;

public class RowMapperImpl implements RowMapper<Team>{

	public Team mapRow(ResultSet rs, int rowNum) throws SQLException {

		Team team = new Team(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
		return team;
	}

}
