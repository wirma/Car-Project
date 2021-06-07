package com.car.systems;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.car.systems.services.UserService;

@SpringBootTest
public class CarUnitTest {
	 	@Autowired
	    private TestEntityManager entityManager;
	 
	 	@Autowired
	 	private UserService userService;
	 	
	 	@Test
	 	public void whenFindByName_thenReturnEmployee() {
	 	    
	 		
	 	   boolean isFound = false;
	 	   try { 
	 		  userService.register("Vase", "Vase");
	 		   userService.login("Vase", "Vase");
	 		  isFound = true;
	 	   }catch(Exception e) {
	 		   }
	 	   
	 	   assertTrue(isFound);
	 	}

}
