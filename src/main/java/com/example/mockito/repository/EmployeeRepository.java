/**
 * 
 */
package com.example.mockito.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mockito.model.Employee;

/**
 * @author Goutam Sikder
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	/**
	 * @param email
	 * @return Employee
	 */
	Optional<Employee> findByEmail(String email);

}
