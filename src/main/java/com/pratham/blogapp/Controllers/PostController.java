package com.pratham.blogapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratham.blogapp.Payloads.ApiResponse;
import com.pratham.blogapp.Payloads.PostDto;
import com.pratham.blogapp.Payloads.PostResponse;
import com.pratham.blogapp.Service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@PostMapping("userId/{userId}/categoryId/{categoryId}/posts")
	public ResponseEntity<PostDto>addPost(@RequestBody PostDto postDto,@PathVariable Integer userId,@PathVariable Integer categoryId){
		
	PostDto post=postService.createPost(postDto, userId, categoryId);
		
		return new ResponseEntity<PostDto>(post,HttpStatus.CREATED);
	}
	
	
	@PutMapping("{postId}")
	public ResponseEntity<PostDto>updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId){
		
		PostDto post=postService.updatePost(postDto, postId);
		
		return new ResponseEntity<PostDto>(post,HttpStatus.OK);
	}
	
	
	@DeleteMapping("{postId}")
	public ResponseEntity<ApiResponse>deletePost(@PathVariable Integer postId){
		
		postService.deletePost(postId);
		
		 return new ResponseEntity<ApiResponse>( new ApiResponse("Post Deleted Successfully", true),HttpStatus.OK);
	}
	
	
	@GetMapping("{postId}")
	public ResponseEntity<PostDto>getPostById(@PathVariable Integer postId){
		PostDto post=postService.getPostById(postId);
		
		return new ResponseEntity<PostDto>(post,HttpStatus.OK);
	}
	
	@GetMapping("all")
	public ResponseEntity<PostResponse>getAllPosts( 
			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "10",required = false)Integer pageSize,
			@RequestParam(value = "sortBy",defaultValue = "postId",required = false)String sortBy)
	
	{
		
		PostResponse allPOsts=postService.getAllPosts(pageNumber,pageSize,sortBy);
	
	return new ResponseEntity<PostResponse>(allPOsts,HttpStatus.OK);
	}
	
	@GetMapping("all/categoryId/{categoryId}")
	public ResponseEntity<List<PostDto>>getAllPostByCategory(@PathVariable Integer categoryId ){
		
	 List<PostDto>allPosts=postService.getAllPostByCategory(categoryId);
	 return new ResponseEntity<List<PostDto>>(allPosts,HttpStatus.OK);
	}
	
	
	@GetMapping("all/userId/{userId}")
	public ResponseEntity<List<PostDto>>getAllPostByUser(@PathVariable Integer userId ){
		
	 List<PostDto>allPosts=postService.getAllPostByUSer(userId);
	 return new ResponseEntity<List<PostDto>>(allPosts,HttpStatus.OK);
	}
	
	
	@GetMapping("search/posts/{keywords}")
	public ResponseEntity<List<PostDto>>searchPosts(@PathVariable("keywords") String keywords ){
		
	 List<PostDto>allPosts=postService.search(keywords);
	 
	 return new ResponseEntity<List<PostDto>>(allPosts,HttpStatus.OK);
	}



}
