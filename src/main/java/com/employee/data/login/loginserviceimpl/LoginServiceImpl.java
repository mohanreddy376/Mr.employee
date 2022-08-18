package com.employee.data.login.loginserviceimpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.data.login.logindao.LoginDao;
import com.employee.data.login.loginservice.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDao logindao;
	
	@Override
	public boolean registerUser(String name,String email, String passWord) {
		
		return logindao.register(name, email, passWord);
	}

	@Override
	public Map<String, Object> userLoginData(String email) {
		
		return logindao.loginData(email);
	}
	

}
