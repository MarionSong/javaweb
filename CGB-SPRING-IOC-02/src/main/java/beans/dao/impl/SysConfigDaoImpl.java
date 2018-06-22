package beans.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import beans.dao.SysConfigDao;

public class SysConfigDaoImpl implements SysConfigDao{
	private JdbcTemplate jdbcTemlate;

	public void setDataSource(DataSource dataSource ) {
		this.jdbcTemlate=new JdbcTemplate(dataSource);
	}

	public SysConfig findById(Integer id) {
		RowMapper<SysConfig> mapper=new BeanPropertyRowMapper<SysConfig>(SysConfig.class);
		SysConfig sysConfig = jdbcTemlate.queryForObject("select * from sys_configs where id=?",mapper,id);
		return sysConfig;
	}

}
