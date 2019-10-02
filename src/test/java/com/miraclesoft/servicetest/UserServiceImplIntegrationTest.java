package com.miraclesoft.servicetest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.miraclesoft.entity.UserDetail;
import com.miraclesoft.repository.UserRepository;
import com.miraclesoft.service.UserService;

@RunWith(SpringRunner.class)
public class UserServiceImplIntegrationTest { 

	@TestConfiguration
    static class UserServiceImplTestContextConfiguration {
  
        @Bean
        public UserService userService() {
            return new UserService();
        }
    }
 
    @Autowired
    private UserService userService;
 
    @MockBean
    private UserRepository userRepository;
    
    @Before
    public void setUp() {
        UserDetail alex = new UserDetail(100);
        alex.setUserid(199);
     
        Mockito.when(userRepository.getUserWithId(alex.getUserid()))
          .thenReturn(alex);
        
        System.out.println("test 1");
    }
    
    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        int id = 199;
        UserDetail found = userService.getUserWithId(id);
      
         assertThat(found.getAge())
          .isEqualTo(100);
     }
}
