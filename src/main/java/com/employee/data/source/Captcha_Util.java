package com.employee.data.source;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.FlatColorBackgroundProducer;

@Component
public class Captcha_Util {
	
	public String captchaImage;
	public String captchaText;
	
	public Captcha createCaptcha(int width, int height)
	{
		
		return new Captcha.Builder(width, height)
				.addBackground( new FlatColorBackgroundProducer())
				.addText()
				.addNoise().build();
	}
	
	// create image
	public String encodeBase64(Captcha captcha) throws Exception
	{
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		 ImageIO.write(captcha.getImage(),"png",os);
		 byte[] arr = Base64.getEncoder().encode(os.toByteArray());
		 return new String(arr);
		
		 
		
	}
	
}
