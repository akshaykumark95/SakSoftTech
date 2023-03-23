package com.main.service;

import java.util.List;

import com.main.exception.EmployeeNotFound;
import com.main.model.Employee;

public interface EmployeeService {
	//get all emp
	List<Employee> getAllEmp();
	//get emp by id
	Employee getById(int id) throws EmployeeNotFound;
	//insert info
	Employee saveEmp(Employee emp);
	//upadte info
	Employee updateInfo(Employee emp,int id) throws EmployeeNotFound;
	//delete data
	void deleteInfo(int id) throws EmployeeNotFound;

}
