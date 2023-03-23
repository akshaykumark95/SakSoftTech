package com.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.exception.EmployeeNotFound;
import com.main.model.Employee;
import com.main.repository.EmployeeRepository;
import com.main.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository er;

	@Override
	public List<Employee> getAllEmp() {
		return er.findAll();
	}

	@Override
	public Employee getById(int id) throws EmployeeNotFound {
		
		return er.findById(id).orElseThrow(()-> new EmployeeNotFound(id));
	}

	@Override
	public Employee saveEmp(Employee emp) {
		return er.save(emp);
	}

	@Override
	public Employee updateInfo(Employee emp, int id) throws EmployeeNotFound {

		if(!er.existsById(id)) {
			throw new EmployeeNotFound(id);
		}
		Employee e1=er.findById(id).get();
		e1.setId(emp.getId());
		e1.setFirst_name(emp.getFirst_name());
		e1.setLast_name(emp.getLast_name());
		e1.setEmail(emp.getEmail());
		e1.setAge(emp.getAge());
		
		return er.save(e1);
	}

	@Override
	public void deleteInfo(int id) throws EmployeeNotFound {
		if(!er.existsById(id)) {
			throw new EmployeeNotFound(id);
		}
		er.deleteById(id);
		
	}

}
