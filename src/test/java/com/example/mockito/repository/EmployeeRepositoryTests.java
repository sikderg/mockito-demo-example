/**
 * 
 */
package com.example.mockito.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.mockito.model.Employee;

import lombok.Builder;

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

	// JUnit test for get save employee operation
	@DisplayName("JUnit test for get save employee operation")
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

	// JUnit test for find List of Employee
	@DisplayName("JUnit test for find List of Employee")
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
	
	//JUnit test for get Employee By Id

	@DisplayName("JUnit test for get Employee By Id")
	@Test
	public void givenEmployeeObjectWhenFindByIdThenReturnEmployeeObject() {
		//given - precondition or setup
		Employee employee = Employee.builder().fullName("Goutam Sikder").email("g@s.com").build();
		employeeRepository.save(employee);

		//when - action to behavior that we are going to test
		Employee savedEmployee = employeeRepository.findById(employee.getId()).get();

		//then - verify the output
		assertThat(savedEmployee.getId()).isNotNull();
		assertThat(savedEmployee).isEqualTo(employee);
		assertThat(savedEmployee.getId()).isEqualTo(employee.getId());
	}
	
	//JUnit test for get employee by email operation

	@DisplayName("JUnit test for get employee by email operation")
	@Test
	public void givenEmployeeEmailWhenFindByEmailThenReturnEmployeeOnject() {
		
		//given - precondition or setup
		Employee employee = Employee.builder().fullName("Goutam Sikder").email("g@s.com").build();
		employeeRepository.save(employee);
		
		//when - action to behavior that we are going to test
		Employee savedEmployee = employeeRepository.findByEmail(employee.getEmail()).get();
		
		//then - verify the output
		assertThat(savedEmployee).isNotNull();
		assertThat(savedEmployee).isEqualTo(employee);
	}
	
	//JUnit test for update employee operation

	@DisplayName("JUnit test for update employee operation")
	@Test
	public void givenEmployeeWhenUpdateEmployeeThenReturnUpdatedEmployee() {
		//given - precondition or setup
		Employee employee = Employee.builder().fullName("Goutam Sikder").email("g@s.com").build();
		employeeRepository.save(employee);

		//when - action to behavior that we are going to test
		Employee savedEmployee = employeeRepository.findById(employee.getId()).get();
		savedEmployee.setEmail("s@s.com");
		savedEmployee.setFullName("G Sikder");
		Employee updatedEmployee = employeeRepository.save(savedEmployee);
		//then - verify the output
		assertThat(updatedEmployee.getEmail()).isEqualTo("s@s.com");
		assertThat(updatedEmployee.getFullName()).isEqualTo("G Sikder");
	}

}
