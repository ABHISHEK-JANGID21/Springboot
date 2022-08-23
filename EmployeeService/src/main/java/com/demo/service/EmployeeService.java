package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.dao.EmployeeRepository;
import com.demo.entity.Employee;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		List<Employee> list = (List<Employee>) this.employeeRepository.findAll();
		return list;
	}

	public Employee getById(int id) {
		Employee employee = null;
		try {
			employee = this.employeeRepository.findById(id);
		} catch (Exception e) {
			System.out.println("Employee with Id " + id + " does not exist");
		}
		return employee;
	}

	public void deleteEmployeeById(int id) {
		this.employeeRepository.deleteById(id);
	}

	public void updateDetailsById(Employee employee, int id) {
		employee.setId(id);
		this.employeeRepository.save(employee);
	}

	public Employee addNewEmployee(Employee e) {
		Employee employee = this.employeeRepository.save(e);
		return employee;
	}

}
