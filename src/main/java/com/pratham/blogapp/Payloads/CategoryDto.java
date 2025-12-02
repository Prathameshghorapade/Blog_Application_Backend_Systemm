package com.pratham.blogapp.Payloads;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class CategoryDto implements Serializable {
	
	public CategoryDto() {}

	
	private int categoryId;
	
	@NotEmpty
    @Size(min =3,message="Title IS Must be Minimum 3 Characters  and Maximum 20 Characters!!")
	private String categoryTitle;
	
	
	@NotEmpty
    @Size(min =10,message="Category Description IS Must be Minimum 10 Characters  and Maximum 50 Characters!!")
	private String categoryDescription;
	
	

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	
	
	

}
