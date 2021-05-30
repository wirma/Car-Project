package com.car.systems.repositories;

import com.car.systems.models.User;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long>{

	@Query("Select u from User u where u.username=:username and u.password=:password")
    public Optional<User> findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
	
	@Query("Select u from User u where u.username=:username")
    public Optional<User> findByUsername(@Param("username") String username);
}
