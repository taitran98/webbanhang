package com.example.webbanhang;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class webbanhangDAO {
	
	@Autowired
	
	private JdbcTemplate jdbcTemplate;
	
	public void register(Register register)
	{
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		insert.withTableName("customer").usingColumns("email","pass");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(register);
		
		insert.execute(param);
	}

	public void update(Register register) {
		String sql = "update customer set name=:name , dob=:dob, gender=:gender, phone=:phone, address=:address, district=:district, city=:city where email=:email";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(register);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		template.update(sql, param);
	}

}
