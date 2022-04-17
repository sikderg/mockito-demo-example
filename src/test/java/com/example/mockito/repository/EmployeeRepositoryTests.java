/**
 * 
 */
package com.example.mockito.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.example.mockito.model.Employee;

import static org.assertj.core.api.Assertions.assertThat;

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

	private Employee employee;

	/**
	 * @return
	 */
	
	@BeforeEach
	public void setupEmployeeObject() {
		employee = Employee.builder().fullName("Goutam Sikder").email("g@s.com").build();
	}
	
	// JUnit test for get save employee operation
	@DisplayName("JUnit test for get save employee operation")
	@Test
	public void givenEmployeeObjectWhenSaveEmployeeThenReturnEmployeeObject() {

		// given - precondition or setup
		
		// when - action or behavior that we are going to test.
		Employee savedEmployee = employeeRepository.save(this.employee);

		// Verify the output
		assertThat(savedEmployee).isNotNull();
		assertThat(savedEmployee.getId()).isGreaterThan(0);

	}

	// JUnit test for find List of Employee
	@DisplayName("JUnit test for find List of Employee")
	@Test
	public void givenSaveListEmployeeWhenFindAllThen() {
		// given - precondition or setup
		Employee employeeTG = Employee.builder().fullName("Tripti Ghosh").email("t@g.com").build();
		employeeRepository.save(this.employee);
		employeeRepository.save(employeeTG);

		// when - action to behavior that we are going to test
		List<Employee> employeeList = employeeRepository.findAll();

		// then - verify the output
		assertThat(employeeList).isNotNull();
		assertThat(employeeList.size()).isEqualTo(2);
	}

	// JUnit test for get Employee By Id

	@DisplayName("JUnit test for get Employee By Id")
	@Test
	public void givenEmployeeObjectWhenFindByIdThenReturnEmployeeObject() {
		// given - precondition or setup
		employeeRepository.save(this.employee);

		// when - action to behavior that we are going to test
		Employee savedEmployee = employeeRepository.findById(employee.getId()).get();

		// then - verify the output
		assertThat(savedEmployee.getId()).isNotNull();
		assertThat(savedEmployee).isEqualTo(this.employee);
		assertThat(savedEmployee.getId()).isEqualTo(employee.getId());
	}

	// JUnit test for get employee by email operation

	@DisplayName("JUnit test for get employee by email operation")
	@Test
	public void givenEmployeeEmailWhenFindByEmailThenReturnEmployeeOnject() {
		// given - precondition or setup
		
		employeeRepository.save(this.employee);

		// when - action to behavior that we are going to test
		Employee savedEmployee = employeeRepository.findByEmail(employee.getEmail()).get();

		// then - verify the output
		assertThat(savedEmployee).isNotNull();
		assertThat(savedEmployee).isEqualTo(this.employee);
	}

	// JUnit test for update employee operation

	@DisplayName("JUnit test for update employee operation")
	@Test
	public void givenEmployeeWhenUpdateEmployeeThenReturnUpdatedEmployee() {
		// given - precondition or setup
		employeeRepository.save(this.employee);

		// when - action to behavior that we are going to test
		Employee savedEmployee = employeeRepository.findById(employee.getId()).get();
		savedEmployee.setEmail("s@s.com");
		savedEmployee.setFullName("G Sikder");
		Employee updatedEmployee = employeeRepository.save(savedEmployee);
		// then - verify the output
		assertThat(updatedEmployee.getEmail()).isEqualTo("s@s.com");
		assertThat(updatedEmployee.getFullName()).isEqualTo("G Sikder");
	}

	// JUnit test for delete employee operation

	@DisplayName("JUnit test for delete employee operation")
	@Test
	public void givenEmployeeObjectWhenDeleteThenRemoveEmployee() {
		// given - precondition or setup
		employeeRepository.save(this.employee);

		// when - action to behavior that we are going to test
		employeeRepository.delete(this.employee);
		Optional<Employee> employeeDBOptional = employeeRepository.findById(employee.getId());

		// then - verify the output
		assertThat(employeeDBOptional).isEmpty();
	}

	// JUnit test for Spring Data JPQL index Parameters

	@DisplayName("JUnit test for Spring Data JPQL index Parameters")
	@Test
	public void givenEmployeeObjectWhenFindByJPQLIndexParamsThenValidateReturnEmployee() {
		// given - precondition or setup
		employeeRepository.save(this.employee);
		String fullNanme = "Goutam Sikder";
		String email = "g@s.com";
		// when - action to behavior that we are going to test
		Employee savedEmployee = employeeRepository.findJPQLQueryFullNameAndEmail(fullNanme, email);

		// then - verify the output
		assertThat(savedEmployee).isEqualTo(this.employee);
	}

	// JUnit test for Spring Data JPQL Named Parameters

	@DisplayName("JUnit test for Spring Data JPQL Named Parameters")
	@Test
	public void givenEmployeeObjectWhenFindByJPQLNamedParamsThenValidateReturnEmployee() {
		// given - precondition or setup
		employeeRepository.save(this.employee);
		String fullNanme = "Goutam Sikder";
		String email = "g@s.com";
		// when - action to behavior that we are going to test
		Employee savedEmployee = employeeRepository.findJPQLNamedParamsFullNameAndEmail(fullNanme, email);

		// then - verify the output
		assertThat(savedEmployee).isNotNull();
		assertThat(savedEmployee.getFullName()).isEqualTo(fullNanme);
		assertThat(savedEmployee).isEqualTo(this.employee);
	}

	// JUnit test for Spring Data Native Query index Parameters

	@DisplayName("JUnit test for Spring Data Native Query index Parameters")
	@Test
	public void givenEmployeeObjectWhenFindByNativeQueryIndexParamsThenValidateReturnEmployee() {
		// given - precondition or setup
		employeeRepository.save(this.employee);
		String fullNanme = "Goutam Sikder";
		String email = "g@s.com";
		// when - action to behavior that we are going to test
		Employee savedEmployee = employeeRepository.findNativeSQL(fullNanme, email);

		// then - verify the output
		assertThat(savedEmployee).isNotNull();
		assertThat(savedEmployee.getFullName()).isEqualTo(fullNanme);
		assertThat(savedEmployee).isEqualTo(this.employee);
	}

	// JUnit test for Spring Data Native Query Named Parameters

	@DisplayName("JUnit test for Spring Data Native Query Named Parameters")
	@Test
	public void givenEmployeeObjectWhenFindByNativeQueryNamedParamsThenValidateReturnEmployee() {
		// given - precondition or setup
		employeeRepository.save(this.employee);
		String fullNanme = "Goutam Sikder";
		String email = "g@s.com";
		// when - action to behavior that we are going to test
		Employee savedEmployee = employeeRepository.findNativeSQLNamedParams(fullNanme, email);

		// then - verify the output
		assertThat(savedEmployee).isNotNull();
		assertThat(savedEmployee.getFullName()).isEqualTo(fullNanme);
		assertThat(savedEmployee).isEqualTo(this.employee);
	}

}
