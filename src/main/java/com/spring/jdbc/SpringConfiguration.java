package com.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.TeamDao;
import com.spring.jdbc.dao.TeamDaoImpl;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dao"})
public class SpringConfiguration {

	@Bean("driverManager")
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource driverManager = new DriverManagerDataSource();
		driverManager.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driverManager.setUrl("jdbc:oracle:thin:@clm-aus-udfysd.bmc.com:1521:ORA12C");
		driverManager.setUsername("patmon");
		driverManager.setPassword("bmcAdm1n");
		return driverManager;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	/*@Bean("teamDao")
	public TeamDao getTeamDao()
	{
		TeamDaoImpl teamDao = new TeamDaoImpl();
		teamDao.setJdbcTemplate(getTemplate());
		return teamDao;
	}*/
}
