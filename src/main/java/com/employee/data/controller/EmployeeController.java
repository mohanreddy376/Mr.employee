package com.employee.data.controller;




import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.employee.data.service.EmployeeService;
import com.employee.data.source.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/Home")
	public String homePage()
	{
		return "Home";
	}
	@GetMapping("/Add_Employee")
	public String addEmployee()
	{
		return "Add_Employee";
	}
	
	@PostMapping("/Submit")
	public String saveEmployee(@RequestParam int empno,@RequestParam String ename,@RequestParam double sal,@RequestParam int deptno,@RequestParam MultipartFile empimage, Model model) throws Throwable
	{
		byte[] bytes = empimage.getBytes();
		
		String status;
		boolean flag = employeeService.addEmployee(empno, ename, sal, deptno,bytes);
		if(flag)
			status="Employee Details Added Successfully";
		else
			status="Duplicate Employee Number Not Allowed";
		model.addAttribute("status", status);
		return "Status";
	}
	@GetMapping("/View_Employees")
	public String viewEmployee(Model model)
	{
	List<Employee>	emplist = employeeService.readEmployee().stream()
	.map(o-> new Employee((int)o.get("empno"), (String)o.get("ename"), (int) o.get("sal"),(int) o.get("deptno"),(byte[])o.get("employee_image")))
	.collect(Collectors.toList());
	
	model.addAttribute("title","EMPLOYEES DETAILS");
	model.addAttribute("employees", emplist);
		return "View_Employee";
	}
	@GetMapping("/Update_Employee")
	public String UpdateEmployee()
	{
		return "Update_Employee";
	}
	@GetMapping("/SubmitName")
	public String UpdateName(@RequestParam int empno,@RequestParam String ename,Model model)
	{
		String status = employeeService.updateName(empno, ename);
		model.addAttribute("status", status);
		return "Status";
	}
	@GetMapping("/SubmitSalary")
	public String UpdateSalary(@RequestParam int empno,@RequestParam double sal,Model model)
	{
		String status = employeeService.updateSal(empno, sal);
		model.addAttribute("status", status);
		return "Status";
	}
	@GetMapping("/SubmitDeparment")
	public String UpdateDepartment(@RequestParam int empno,@RequestParam int deptno,Model model)
	{
		String status = employeeService.updateDepartment(empno, deptno);
		model.addAttribute("status", status);
		return "Status";
	}
	@GetMapping("/Delete_Employee")
	public String DeleteEmployee()
	{
		return "Delete_Employee";
	}
	@GetMapping("/Delete")
	public String deleteEmployee(@RequestParam int empno,Model model)
	{
		employeeService.deleteEmployee(empno);
		
		return viewEmployee(model);
	}
	@GetMapping("/Update")
	public String updateEmployee(@RequestParam int empno,@RequestParam String ename,@RequestParam double sal,@RequestParam int deptno, Model model)
	{
		 employeeService.updateEmployee(empno, ename, sal, deptno);
		return viewEmployee(model);
	}
	
	@GetMapping("/Find_Employee")
	public String FindEmployee()
	{
		return "Find_Employee";
	}
	
	@GetMapping("/Find")
	public String FindEmployees(@RequestParam int empno,Model model)
	{
		try{
			Map<String,Object> m = employeeService.findEmolyee(empno);
			List<Employee>	emplist = new ArrayList<>();
					emplist.add(new Employee((int)m.get("empno"), (String)m.get("ename"),(int)m.get("sal"),(int)m.get("deptno"),(byte[]) m.get("employee_image")));		
					model.addAttribute("title","Employee number "+ (int)m.get("empno")+" details");
					model.addAttribute("employees", emplist); 
					
						return "View_Employee";
		}catch (EmptyResultDataAccessException e) {
			model.addAttribute("status", "invalid Employee number");
			return "Status";
		}
	}
	
	@GetMapping("/Image")
	public String getImage(@RequestParam Integer empno, Model model)
	{
	Map<String, Object> map = 	employeeService.findEmolyee(empno);
	String image;
	byte[] arr = Base64.encodeBase64( (byte[]) map.get("employee_image"));
	try {
		image = new String(arr,"UTF-8");
	} catch (Exception e) {	
		image =null;
	}
	model.addAttribute("empno", empno);
	model.addAttribute("image", image);
		return "View_image"; 
	}
	
	@PostMapping("/Update_image")
	public String updateImage(@RequestParam int empno,@RequestParam MultipartFile empimage,Model model) throws Throwable
	{
		byte[] bytes= empimage.getBytes();
		employeeService.updateImage(empno, bytes);
		return viewEmployee(model);
	}
}
