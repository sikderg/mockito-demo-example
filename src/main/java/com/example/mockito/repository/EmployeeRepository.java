/**
 * 
 */
package com.example.mockito.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

	/**
	 * @param fullNanme
	 * @param email
	 * @return Employee
	 */
	@Query("select e from Employee e where fullName = ?1 and email=?2")
	Employee findJPQLQueryFullNameAndEmail(String fullNanme, String email);

}
