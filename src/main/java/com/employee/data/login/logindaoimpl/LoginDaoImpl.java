package com.employee.data.login.logindaoimpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.employee.data.login.logindao.LoginDao;

@Repository
public class LoginDaoImpl implements LoginDao{

	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Override
	public boolean register(String name,String email,String passWord) {
		
try {
			jdbctemplate.update("INSERT INTO LOGINDATA VALUES (?,?,?)",name,email,passWord);
			return true;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Map<String, Object> loginData(String email) {
		
		return jdbctemplate.queryForMap("SELECT * FROM LOGINDATA WHERE EMAIL=?",email);
	}
}
