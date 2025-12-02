package com.pratham.blogapp.Service.ServiceImpl;

import com.pratham.blogapp.Exceptions.UserNotFound;
import com.pratham.blogapp.Payloads.UserDto;
import com.pratham.blogapp.Repository.UserRepo;
import com.pratham.blogapp.Service.UserSevice;
import com.pratham.blogapp.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserSevice {


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepo userRepo;
    
   
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {

       User user= modelMapper.map(userDto, User.class);
       
       user.setPassword(passwordEncoder.encode(userDto.getPassword()));

      User savedUser= userRepo.save(user);

        return modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public UserDto updateUser(Integer userId, UserDto userDto) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new UserNotFound("User", "User Id", userId));

       
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
       user.setGender(userDto.getGender());
       user.setAge(userDto.getAge());

        User updatedUser = userRepo.save(user);
        return modelMapper.map(updatedUser, UserDto.class);
    }
    
    

    @Override
    public void deleteUserByID(Integer userId) {
    	
    User avilableUSer=userRepo.findById(userId).orElseThrow(()->new UserNotFound("User","User Id",userId));
      userRepo.delete(avilableUSer);
        
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> allUsers = userRepo.findAll();

        List<UserDto> users = allUsers.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());

        return users;
    }

    @Override
    public UserDto findUserByID(Integer userId) {
    	
    	User user=userRepo.findById(userId).orElseThrow(()->new UserNotFound("USer","User ID",userId));
    	
    	UserDto availableUser=modelMapper.map(user,UserDto.class);
    	
        return availableUser;
    }
}


