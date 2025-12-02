package com.pratham.blogapp.Controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratham.blogapp.Payloads.ApiResponse;
import com.pratham.blogapp.Payloads.UserDto;
import com.pratham.blogapp.Service.UserSevice;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserSevice userService;
	
//	@PostMapping("/adduser")
//	public ResponseEntity<UserDto> createUSer(@Valid @RequestBody UserDto userDto) {
//		
//		UserDto user=userService.createUser(userDto);
//		
//		return new ResponseEntity<UserDto>(user,HttpStatus.CREATED) ;
//		
//		
//		
//	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDto>updateUSer( @Valid @RequestBody UserDto userDto,@PathVariable Integer userId){
		
		UserDto user=userService.updateUser(userId,userDto);		
		
		return new ResponseEntity<UserDto>(user,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserDto>>getAllUsers(){
		
		List<UserDto>allUSers=userService.findAllUsers();
		
		return new ResponseEntity<List<UserDto>>(allUSers,HttpStatus.OK);
	}
	
	@GetMapping("{userId}")
	public ResponseEntity<UserDto>getUserById(@PathVariable Integer userId){
		
		UserDto user=userService.findUserByID(userId);
		
		return new ResponseEntity<UserDto>(user,HttpStatus.OK);
	}
	
	
	@DeleteMapping("{userId}")
	public ResponseEntity<ApiResponse>deleteUserById(@PathVariable Integer userId){
		
		userService.deleteUserByID(userId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Sucessfully", true),HttpStatus.OK);
	}
	
	
	
	
	

}
