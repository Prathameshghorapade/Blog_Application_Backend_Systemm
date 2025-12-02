package com.pratham.blogapp.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import com.pratham.blogapp.Payloads.JwtRequest;
import com.pratham.blogapp.Payloads.JwtResponse;
import com.pratham.blogapp.Payloads.UserDto;
import com.pratham.blogapp.Service.UserSevice;
import com.pratham.blogapp.security.JwtHelper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager; 
    
    @Autowired
    UserSevice userSevice;


   
    
    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

        this.doAuthenticate(request.getUsername(), request.getPassword());

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = this.helper.generateToken(userDetails);

        JwtResponse response = new JwtResponse(token, userDetails.getUsername());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }
    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }
    
	@PostMapping("/create-user")
	public ResponseEntity<UserDto> createUSer(@Valid @RequestBody UserDto userDto) {
		
		UserDto user=userSevice.createUser(userDto);
		
		return new ResponseEntity<UserDto>(user,HttpStatus.CREATED) ;
		
		
		
	}
}