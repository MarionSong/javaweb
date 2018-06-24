package com.beans.dao.impl;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.beans.dao.employee;
import com.beans.pojo.Employee;
public class employeeImpl implements employee{
	private JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource dataSource) {  
        this.jdbcTemplate = new JdbcTemplate(dataSource);  
    }
	@Override
	public Employee findById(Integer id) {
		RowMapper<Employee> mapper=new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee queryForObject = jdbcTemplate.queryForObject("select * from product where id =?", mapper,id);
		return queryForObject;
	}
}
