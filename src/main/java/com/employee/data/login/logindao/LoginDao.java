package com.employee.data.login.logindao;

import java.util.Map;

import org.springframework.stereotype.Repository;


public interface LoginDao {
	
	boolean register(String name,String email,String passWord);
	Map<String,Object> loginData(String email);

}
