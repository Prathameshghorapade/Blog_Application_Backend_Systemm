package com.pratham.blogapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratham.blogapp.entities.Catagory;
import com.pratham.blogapp.entities.Post;
import com.pratham.blogapp.entities.User;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post>findByUser(User user);
	
	List<Post>findByCatagory(Catagory catagory);  
	
	List<Post>findByTitleContaining(String title);

}
