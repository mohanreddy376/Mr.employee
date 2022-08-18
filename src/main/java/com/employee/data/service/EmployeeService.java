package com.employee.data.service;

import java.awt.Image;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
	
	boolean addEmployee(int empno,String ename,double sal,int deptno,byte[] image);
	List<Map<String, Object>> readEmployee();
	 String updateName(int empno, String ename) ;
	 String updateSal(int empno,double sal) ;
	 String updateDepartment(int empno,int deptno) ;
	 void deleteEmployee(int empno);
	 Map<String, Object> findEmolyee(int empno);
	 void updateEmployee(int empno,String ename,double sal,int deptno);
	  String updateImage(int empno, byte[] bytes);
	 
}
