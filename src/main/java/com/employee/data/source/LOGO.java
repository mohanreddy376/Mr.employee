package com.employee.data.source;

import java.io.FileInputStream;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class LOGO {

	public String path1 = "D:\\STS_WorkSpace\\Employee_Data\\src\\main\\resources\\Logo_images\\image.png";
	
	

	public String logo(String path) {
		String logo;
		try {
		FileInputStream fis = new FileInputStream(path);
		byte[] b = fis.readAllBytes();
		byte[] arr = Base64.encodeBase64(b);
		
			logo = new String(arr,"UTF-8");
		} catch (Exception e) {	
			logo =null;
		}
		return logo;
	}
	
}
