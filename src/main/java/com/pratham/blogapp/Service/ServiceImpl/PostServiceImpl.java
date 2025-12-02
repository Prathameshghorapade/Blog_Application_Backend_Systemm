package com.pratham.blogapp.Service.ServiceImpl;

import org.springframework.data.domain.Sort;
import java.util.Date;
import java.util.List;
import java.util.Locale.Category;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pratham.blogapp.Exceptions.CategoryNotFound;
import com.pratham.blogapp.Exceptions.PostNotFound;
import com.pratham.blogapp.Exceptions.UserNotFound;
import com.pratham.blogapp.Payloads.PostDto;
import com.pratham.blogapp.Payloads.PostResponse;
import com.pratham.blogapp.Repository.CategoryRepo;
import com.pratham.blogapp.Repository.PostRepo;
import com.pratham.blogapp.Repository.UserRepo;
import com.pratham.blogapp.Service.PostService;
import com.pratham.blogapp.entities.Catagory;
import com.pratham.blogapp.entities.Post;
import com.pratham.blogapp.entities.User;

@Service
public class PostServiceImpl implements PostService {
	

	 @Autowired
	 ModelMapper modelMapper;
	 
	 @Autowired
	 UserRepo userRepo;
	 
	 @Autowired
	 CategoryRepo categoryRepo;
	 
	 @Autowired
	 PostRepo postRepo;
	 
	
	
	
	
	@Override
	@CacheEvict(value ={"postbyid","posts","allpostbycategory","allpostbyuser","search"},allEntries = true )
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		
	User user=userRepo.findById(userId).orElseThrow(()->new UserNotFound("User", "User Id", userId));
	
	 Catagory catagoryy=categoryRepo.findById(categoryId).orElseThrow(()->new CategoryNotFound("Category", "Category ID", categoryId));
		
	   Post post = modelMapper.map(postDto, Post.class);
	     
	   post.setUser(user);
	   post.setCatagory(catagoryy);
	   post.setAddedDate(new Date());
		
	   Post newPost=postRepo.save(post);
	   
		return modelMapper.map(newPost, PostDto.class);
	}

	
	
	

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		
	Post post=postRepo.findById(postId).orElseThrow(()->new PostNotFound("Post", "Post ID", postId));
		
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		
	Post updatedPost=postRepo.save(post);
		return modelMapper.map(updatedPost, PostDto.class);
	}
	
	
	
	

	@Override
	public void deletePost(Integer postId) {
	Post post=postRepo.findById(postId).orElseThrow(()->new PostNotFound("Post", "PostId", postId));
		
	 postRepo.delete(post);
	}
	
	
	

	@Override
	@Cacheable(value = "postbyid",key = "#postId")
	public PostDto getPostById(Integer postId) {
		
	Post post=postRepo.findById(postId).orElseThrow(()->new PostNotFound("Post", "Post Id", postId));
		
		return  modelMapper.map(post, PostDto.class);
	}
	
	

	@Override
	@Cacheable(value = "posts",key = "#pageNumber + '-' + #pageSize + '-' + #sortBy")
	public PostResponse getAllPosts(Integer pageNumber,Integer pageSize,String sortBy) {
		
	Pageable p=PageRequest.of(pageNumber,pageSize,Sort.by(sortBy));
		
    Page<Post>pagePosts=postRepo.findAll(p);
    
    List<Post>allpost= pagePosts.getContent();
		
	List<PostDto>allPost=pagePosts.stream().map(post->modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
	
	PostResponse postResponse=new PostResponse();
	
	postResponse.setContent(allPost);
	
	postResponse.setPageNumber(pagePosts.getNumber());
	
	postResponse.setPageSize(pagePosts.getSize());
	
	postResponse.setTotalElement(pagePosts.getTotalElements());
	
	postResponse.setTotalPages(pagePosts.getTotalPages());
	
	postResponse.setLastPage(pagePosts.isLast());
	
		
	return postResponse;
	
	}
	
	
	

	@Override
	@Cacheable(value = "allpostbycategory",key = "#categoryId")
	public List<PostDto> getAllPostByCategory(Integer categoryId) {
		
		Catagory category=categoryRepo.findById(categoryId).orElseThrow(()->new CategoryNotFound("Category", "Category ID",categoryId ));
		List<Post>allPosts=postRepo.findByCatagory(category);
		
		List<PostDto>postss=allPosts.stream().map(post->modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postss;
	}
	
	
	

	@Override
	@Cacheable(value = "allpostbyuser",key="#userId")
	public List<PostDto> getAllPostByUSer(Integer userId) {
		
		User user=userRepo.findById(userId).orElseThrow(()->new UserNotFound("User", "User Id", userId));
		
	List<Post>users	=postRepo.findByUser(user);
	List<PostDto>posts=users.stream().map(post->modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	 
		return posts;
	}
	
	
	

	@Override
	@Cacheable(value = "search",key = "#keyWord")
	public List<PostDto> search(String keyWord) {
		
	List<Post>posts=postRepo.findByTitleContaining(keyWord);
	List<PostDto> postdtos=posts.stream().map(post->modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

		return postdtos;
	}

	

}
