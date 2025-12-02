package com.pratham.blogapp.Repository;

import com.pratham.blogapp.Payloads.UserDto;
import com.pratham.blogapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
	
	
 public User findByEmail(String email);

}
