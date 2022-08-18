package com.employee.data.login.logincontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.data.login.loginservice.LoginService;
import com.employee.data.source.Captcha_Util;
import com.employee.data.source.LOGO;

import cn.apiclub.captcha.Captcha;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	@Autowired
	Captcha_Util captcha_Util;
	@Autowired
	LOGO logo;
	
	
	void getCaptcha() throws Exception
	{
		Captcha captcha = captcha_Util.createCaptcha(150, 80);
		captcha_Util.captchaText = captcha.getAnswer();
		captcha_Util.captchaImage = captcha_Util.encodeBase64(captcha);
	}
	
	@GetMapping("/Index")
	public String getLoginPage(Model model) throws Exception
	{
		getCaptcha();	

			
			model.addAttribute("logo1", logo.logo(logo.path1));
		
		model.addAttribute("image", captcha_Util.captchaImage);
		return "Login";
	}
	@PostMapping ("/Valid_Login")
	public String validationLoginPage(@RequestParam String username,@RequestParam String password,@RequestParam String captcha,Model model) throws Exception
	{
		
		if(!captcha_Util.captchaText.equals(captcha))	
		{
			model.addAttribute("status", "Invalid Captcha");
			return getLoginPage(model);
		}
		Map<String, Object> userData;
		try {
		 userData = loginService.userLoginData(username);
		}catch (Exception e) {
			model.addAttribute("status", "Invalid Creditionals");
			return getLoginPage(model);
		}
		if(!userData.get("password").equals(password))
		{
			model.addAttribute("status", "Invalid Creditionals");
			return getLoginPage(model);
		}
		
		return "Home";
	}
	
	@GetMapping("/Register")
	public String getRegisterPage(Model model) throws Exception
	{
		getCaptcha();	
	model.addAttribute("image", captcha_Util.captchaImage);
		return "Register";
	}
	
	@PostMapping ("/Valid_Register")
	public String validationRegisterPage(@RequestParam String username,@RequestParam String email,@RequestParam String password,@RequestParam String con_password,@RequestParam String captcha,Model model) throws Exception
	{
		if(!password.equals(con_password))	
			{
				model.addAttribute("status", "password mismatch");
				return getRegisterPage(model);
			}
			if(!captcha_Util.captchaText.equals(captcha))	
		{
			model.addAttribute("status", "InValid Captcha");
			return getRegisterPage(model);
		}
			
			if(!loginService.registerUser(username, email, con_password))
			{
				model.addAttribute("status", "Email already Exist");
				return getRegisterPage(model);
			}
		return getLoginPage(model);
	}
}
