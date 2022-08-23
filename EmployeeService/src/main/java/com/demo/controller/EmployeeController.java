package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Employee;
import com.demo.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@ApiOperation(value ="To get the employees' detail")
	@GetMapping("/details")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> list = null;
		list = this.employeeService.getAllEmployees();
		if (list.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
     
	@ApiOperation(value ="To get the employee detail using id")
	@GetMapping("/details/{id}")
	public ResponseEntity<Employee> getEmployeeDetailsById(@PathVariable(value = "id") int id) {
		Employee employee = this.employeeService.getById(id);
		if (employee == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(employee));
	}

	@ApiOperation(value ="To get the employee details using id")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmployeeDetatilsById(@PathVariable(value = "id") int id) {
		try {
			this.employeeService.deleteEmployeeById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@ApiOperation(value ="To add new employee details")
	@PostMapping("/add")
	public ResponseEntity<Employee> addNewEmployeeDetails(@RequestBody Employee employee) {
		Employee employee2 = null;
		try {
			employee2 = this.employeeService.addNewEmployee(employee);
			return ResponseEntity.of(Optional.of(employee2));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@ApiOperation(value ="To update existing employee details")
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updatingDetailsOfEmployee(@RequestBody Employee emp,
			@PathVariable(value = "id") int id) {
		try {
			this.employeeService.updateDetailsById(emp, id);
			return ResponseEntity.ok().body(emp);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}
