package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.exception.EmployeeNotFound;
import com.main.model.Employee;
import com.main.service.EmployeeService;

@RestController
@RequestMapping("/getEmp")
public class EmployeeController {
	
	@Autowired
	EmployeeService es;
	
	@GetMapping("/all")
	public List<Employee> getAllEmployee()
	{
		return es.getAllEmp();	
	}
	
	@GetMapping("/emp/{id}")
	public Employee getById(@PathVariable int id) throws EmployeeNotFound {
		return es.getById(id);
	}
	
	@PostMapping("/add")
	public String saveData(@RequestBody Employee emp) {
		es.saveEmp(emp);
		return "Data added successfully"; 
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteData(@PathVariable int id) throws EmployeeNotFound {
		es.deleteInfo(id);
		return "deleted";
	}
	
	@PutMapping("/update/{id}")
	public String updateData(@PathVariable int id,@RequestBody Employee emp) throws EmployeeNotFound {
		Employee emp1=es.updateInfo(emp, id);
		return "Updated";
		
	}

}
