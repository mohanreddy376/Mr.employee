package com.employee.data.dao.impl;

import java.awt.Image;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.employee.data.dao.EmployeeDao;

@Repository
public class EmployeeDao_Impl implements EmployeeDao {

	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Override
	public boolean saveEmployee(int empno, String ename, double sal, int deptno, byte[] image) {
		
		try {
			
			jdbctemplate.update("INSERT INTO EMPLOYEE VALUES (?,?,?,?,?)",empno,ename,sal,deptno,image);
			return true;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	@Override
	public List<Map<String, Object>> fetchEmployeeData() {
		
		return jdbctemplate.queryForList("SELECT* FROM EMPLOYEE");
	}

	@Override
	public String updateEmployeeName(int empno, String ename) {
		
		jdbctemplate.update("UPDATE EMPLOYEE SET ENAME = ? WHERE EMPNO=?",ename,empno);
		
		return "Name Updated";
	}
	@Override
	public String updateEmployeeImage(int empno, byte[] bytes) {
		
		jdbctemplate.update("UPDATE EMPLOYEE SET EMPLOYEE_IMAGE = ? WHERE EMPNO=?",bytes,empno);
		
		return "Image Updated";
	}

	@Override
	public String updateEmployeeSal(int empno, double sal) {
		jdbctemplate.update("UPDATE EMPLOYEE SET SAL = ? WHERE EMPNO=?",sal,empno);
		return "Salary Updated";
	}

	@Override
	public String updateEmployeeDepartment(int empno, int deptno) {
		jdbctemplate.update("UPDATE EMPLOYEE SET DEPTNO = ? WHERE EMPNO=?",deptno,empno);
		return "Department Updated";
	}

	@Override
	public void deleteData(int empno) {
		
		jdbctemplate.update("DELETE FROM EMPLOYEE WHERE EMPNO=?",empno);
		
	}

	@Override
	public Map<String, Object> searchEmolyee(int empno) {
		
		return jdbctemplate.queryForMap("SELECT * FROM EMPLOYEE WHERE EMPNO=?",empno);
		
	}

	@Override
	public void updateEmployeeData(int empno, String ename, double sal, int deptno) {
			jdbctemplate.update("UPDATE EMPLOYEE SET ENAME=?,SAL=?,DEPTNO = ? WHERE EMPNO=?",ename,sal,deptno,empno);
	}
}
