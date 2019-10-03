package com.miraclesoft.webmvctest;



/*
 * Don't remove the unused imports, they are for reference.
 */


import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import java.util.List;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.miraclesoft.controller.UserController;
import com.miraclesoft.entity.UserDetail;
import com.miraclesoft.service.UserService;


@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserRestControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService service;
	
	@Test
	public void givenUsers_whenGetUser_thenReturnJsonArray()
	  throws Exception {
	     
	    UserDetail alex = new UserDetail(100);
	    alex.setUserid(199);
	    
	    List<UserDetail> allEmployees = Arrays.asList(alex);
	 
	    given(service.findAll()).willReturn(allEmployees);
	    
		/* Test the below as well */
	    
		/*
		 * mvc.perform(get("/app/test/199") .contentType(MediaType.APPLICATION_JSON))
		 * .andExpect(status().isOk());
		 */
	 
	    mvc.perform(get("/app/userid/199")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
	    
	    
	    
		/*
		 * mvc.perform(get("/app/userid/199") .contentType(MediaType.APPLICATION_JSON))
		 * .andExpect(status().isOk()) .andExpect(jsonPath("$", hasSize(1)))
		 * .andExpect(jsonPath("$[0].name", is(alex.getUserid())));
		 */
	}
}
