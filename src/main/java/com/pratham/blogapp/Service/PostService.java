package com.pratham.blogapp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pratham.blogapp.Payloads.PostDto;
import com.pratham.blogapp.Payloads.PostResponse;

@Service
public interface PostService  {

	
	//add
	
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//delete
	
	void deletePost(Integer postId);
	
	
	//get
	
	PostDto getPostById(Integer postId);
	
	//getAll
	
	PostResponse getAllPosts(Integer pageNumber,Integer pageSize,String sortBy);
	
	
	//getPostByCategory
	
	List<PostDto>getAllPostByCategory(Integer categoryId);
	
	
	//getAllPostByUser
	
	List<PostDto>getAllPostByUSer(Integer userId);
	
	
	//search
	List<PostDto>search(String keyWord);
	
	
	
	
	
}
