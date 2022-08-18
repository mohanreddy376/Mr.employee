package com.employee.data.service.impl;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.data.dao.EmployeeDao;
import com.employee.data.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao ;
	
	@Override
	public boolean addEmployee(int empno, String ename, double sal, int deptno, byte[] image) {
		
		return employeeDao.saveEmployee(empno, ename, sal, deptno,image);
	}

	@Override
	public List<Map<String, Object>> readEmployee() {
		return employeeDao.fetchEmployeeData();
	}

	@Override
	public String updateName(int empno, String ename) {
		
		return employeeDao.updateEmployeeName(empno, ename);
	}
	@Override
	public String updateImage(int empno, byte[] bytes) {
		
		return employeeDao.updateEmployeeImage(empno, bytes);
	}

	@Override
	public String updateSal(int empno, double sal) {
		
		return employeeDao.updateEmployeeSal(empno, sal);
	}

	@Override
	public String updateDepartment(int empno, int deptno) {
		
		return employeeDao.updateEmployeeDepartment(empno, deptno);
	}

	@Override
	public void deleteEmployee(int empno) {
		
		employeeDao.deleteData(empno);
		
	}

	@Override
	public Map<String, Object> findEmolyee(int empno) {
		return employeeDao.searchEmolyee(empno);
	}

	@Override
	public void updateEmployee(int empno, String ename, double sal, int deptno) {
		
		 employeeDao.updateEmployeeData(empno, ename, sal, deptno);
	}
}
