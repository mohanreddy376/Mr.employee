package com.employee.data.source;

import org.apache.tomcat.util.codec.binary.Base64;


public class Employee {
	int empno;
	String ename;
	double sal;
	int deptno;
	String image;
	
	public Employee(int empno, String ename, double sal, int deptno, byte[] bytes) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.deptno = deptno;	
		byte[] arr = Base64.encodeBase64(bytes);
		try {
			this.image = new String(arr,"UTF-8");
		} catch (Exception e) {	
		}
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getEmpno() {
		return empno;
	}
	public String getEname() {
		return ename;
	}
	public double getSal() {
		return sal;
	}
	public int getDeptno() {
		return deptno;
		
	}	
}
