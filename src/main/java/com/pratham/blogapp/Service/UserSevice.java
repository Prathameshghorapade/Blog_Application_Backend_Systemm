package com.pratham.blogapp.Service;

import com.pratham.blogapp.Payloads.UserDto;
import com.pratham.blogapp.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserSevice {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(Integer userId,UserDto userDto);

    void deleteUserByID(Integer userId);

    List<UserDto>findAllUsers();

    UserDto findUserByID(Integer userId);



}
