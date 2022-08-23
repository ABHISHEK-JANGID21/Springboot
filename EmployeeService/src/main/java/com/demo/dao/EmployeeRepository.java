package com.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.demo.entity.Employee;

@Component
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	public Employee findById(int id);
}
