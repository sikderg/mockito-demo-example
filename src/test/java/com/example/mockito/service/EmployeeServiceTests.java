/**
 * 
 */
package com.example.mockito.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import com.example.mockito.model.Employee;
import com.example.mockito.repository.EmployeeRepository;
import com.example.mockito.service.impl.EmployeeServiceImpl;

/**
 * @author Goutam Sikder
 *
 */
public class EmployeeServiceTests {

	/**
	 * 
	 */

	private EmployeeRepository employeeRepository;

	private EmployeeService employeeService;

	@BeforeEach
	public void setup() {
		employeeRepository = Mockito.mock(EmployeeRepository.class);

		employeeService = new EmployeeServiceImpl(employeeRepository);
	}

	// JUnit test for saved Employee Object

	@DisplayName("JUnit test for saved Employee Object")
	@Test
	public void givenEmployeeObjectWhenSaveEmployeeThenReturnEmployeeObject() {
		// given - precondition or setup
		Employee employee = Employee.builder()
				.fullName("Goutam Sikder")
				.email("g.s@.com")
				.build();
		//Stub
		BDDMockito.given(employeeRepository.findByEmail(employee.getEmail())).willReturn(Optional.empty());
		BDDMockito.given(employeeRepository.save(employee)).willReturn(employee);

		// when - action to behavior that we are going to test
		Employee savedEmployee = employeeService.saveEmployee(employee);
		

		// then - verify the output
		assertThat(savedEmployee).isNotNull();
	}
}
