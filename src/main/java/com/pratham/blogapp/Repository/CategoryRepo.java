 package com.pratham.blogapp.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.pratham.blogapp.entities.Catagory;
import com.pratham.blogapp.entities.User;

public interface CategoryRepo extends JpaRepository<Catagory,Integer> {
	

}
