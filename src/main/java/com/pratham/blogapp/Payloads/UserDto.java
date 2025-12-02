package com.pratham.blogapp.Payloads;


import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class UserDto implements Serializable{

    private int id;

    @NotEmpty
    @Size(min =3,message="Name IS Must be Minimum 3 Characters !!")
    private String name;

    @NotEmpty
    @Email(message="Email Format Must be Correct!!")
    private String email;
    
    @NotEmpty
    @Size(min =3,max=10,message="Password Must be Minimum 3 and Maximum 10 Characters!!")
    private String password;

    @NotEmpty
    private String gender;

    @NotNull
    private int age;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	

}
