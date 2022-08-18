package com.employee.data.login.loginservice;

import java.util.Map;

public interface LoginService {
	boolean registerUser(String name,String email,String passWord);
	Map<String,Object> userLoginData(String email);
}
