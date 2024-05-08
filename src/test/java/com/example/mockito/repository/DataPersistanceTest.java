/**
 * 
 */
package com.example.mockito.repository;


import static org.assertj.core.api.Assertions.assertThat;

import jakarta.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Goutam Sikder
 *
 */
@DataJpaTest
public class DataPersistanceTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplete;

	@Autowired
	private EntityManager entityManager;

	@DisplayName("Jnuit test for DataSource null check")
	@Test
	void injectedComponentsAreNotNull() {
		assertThat(dataSource).isNotNull();
		assertThat(jdbcTemplete).isNotNull();
		assertThat(entityManager).isNotNull();
	}
}
