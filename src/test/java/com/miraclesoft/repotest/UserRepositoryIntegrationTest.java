package com.miraclesoft.repotest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.miraclesoft.entity.UserDetail;
import com.miraclesoft.repository.UserRepository;

/*
 * @RunWith(SpringRunner.class) is used to provide a bridge between Spring Boot test features and JUnit. 
 * Whenever we are using any Spring Boot testing features in our JUnit tests, this annotation will be required.

 * @DataJpaTest provides some standard setup needed for testing the persistence layer:

    configuring H2, an in-memory database
    setting Hibernate, Spring Data, and the DataSource
    performing an @EntityScan
    turning on SQL logging
    
 * ***UserRepository is the component that we are going to test. ***

 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
    private UserRepository userRepository;
	
	@Test
	public void whenFindById_thenReturnUser() {
	    // given
	    UserDetail alex = new UserDetail(100);
	    entityManager.persist(alex);
	    entityManager.flush();
	 
	    // when
	    UserDetail found = userRepository.getUserWithId(alex.getUserid());
	 
	    // then
	    assertThat(found.getUserid())
	      .isEqualTo(alex.getUserid());
	}
}
