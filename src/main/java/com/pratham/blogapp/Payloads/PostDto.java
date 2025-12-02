package com.pratham.blogapp.Payloads;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;




public class PostDto implements Serializable {
	
	private int postId;
	private String title;
	
	private String content;
	
	private Date addedDate;
	
	
   private UserDto user;
   
   

private CategoryDto catagory;





   
   public PostDto() {}
   
 



public PostDto(int postId, String title, String content, Date addedDate, UserDto user, CategoryDto catagory
) {
	super();
	this.postId = postId;
	this.title = title;
	this.content = content;
	this.addedDate = addedDate;
	this.user = user;
	this.catagory = catagory;
	
}





public int getPostId() {
	return postId;
}





public void setPostId(int postId) {
	this.postId = postId;
}





public String getTitle() {
	return title;
}





public void setTitle(String title) {
	this.title = title;
}





public String getContent() {
	return content;
}





public void setContent(String content) {
	this.content = content;
}





public Date getAddedDate() {
	return addedDate;
}





public void setAddedDate(Date addedDate) {
	this.addedDate = addedDate;
}





public UserDto getUser() {
	return user;
}





public void setUser(UserDto user) {
	this.user = user;
}





public CategoryDto getCatagory() {
	return catagory;
}





public void setCatagory(CategoryDto catagory) {
	this.catagory = catagory;
}












	

	

	
	
	
	

}
