/**
 * 
 */
package com.example.mockito.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mockito.exception.ResourceNotFoundException;
import com.example.mockito.model.Employee;
import com.example.mockito.repository.EmployeeRepository;
import com.example.mockito.service.EmployeeService;

/**
 * @author Goutam Sikder
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	/**
	 * 
	 */
	
	
	private EmployeeRepository employeeRepository;

	/**
	 * @param employeeRepository
	 */
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		Optional<Employee> employeeDB = employeeRepository.findByEmail(employee.getEmail());
		if(employeeDB.isPresent()) {
			throw new ResourceNotFoundException("Email Id exists"+employee.getEmail());
		}
		return employeeRepository.save(employee);
	}

}
