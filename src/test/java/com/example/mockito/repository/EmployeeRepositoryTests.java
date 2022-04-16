/**
 * 
 */
package com.example.mockito.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.mockito.model.Employee;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Goutam Sikder
 *
 */
@DataJpaTest
public class EmployeeRepositoryTests {

	/**
	 * 
	 */
	@Autowired
	private EmployeeRepository employeeRepository;

	// JUnit test for get all employee operation
	@DisplayName("JUnit test for get all employee operation")
	@Test
	public void givenEmployeeObjectWhenSaveEmployeeThenReturnEmployeeObject() {

		// given - precondition or setup
		Employee employee = Employee.builder().fullName("Goutam Sikder").email("g@s.com").build();
		// when - action or behavior that we are going to test.
		Employee savedEmployee = employeeRepository.save(employee);

		// Verify the output
		assertThat(savedEmployee).isNotNull();
		assertThat(savedEmployee.getId()).isGreaterThan(0);

	}

	// JUnit test for Save List of Employee
	@DisplayName("JUnit test for Save List of Employee")
	@Test
	public void givenSaveListEmployeeWhenFindAllThen() {
		// given - precondition or setup
		Employee employeeGS = Employee.builder().fullName("Goutam Sikder").email("g@s.com").build();
		Employee employeeTG = Employee.builder().fullName("Tripti Ghosh").email("t@g.com").build();
		employeeRepository.save(employeeGS);
		employeeRepository.save(employeeTG);

		// when - action to behavior that we are going to test
		List<Employee> employeeList = employeeRepository.findAll();

		// then - verify the output
		assertThat(employeeList).isNotNull();
		assertThat(employeeList.size()).isEqualTo(2);
	}

}
