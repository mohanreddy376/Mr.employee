package com.employee.data.dao;

import java.awt.Image;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

public interface EmployeeDao {
	
	boolean saveEmployee(int empno,String ename,double sal,int deptno, byte[] image);
	List<Map<String,Object>> fetchEmployeeData();
	 String updateEmployeeName(int empno, String ename) ;
	 public String updateEmployeeImage(int empno, byte[] bytes);
	 String updateEmployeeSal(int empno,double sal) ;
	 String updateEmployeeDepartment(int empno,int deptno) ;
	 void deleteData(int empno);
	 Map<String, Object> searchEmolyee(int empno);
	 void updateEmployeeData(int empno,String ename,double sal,int deptno);
}
