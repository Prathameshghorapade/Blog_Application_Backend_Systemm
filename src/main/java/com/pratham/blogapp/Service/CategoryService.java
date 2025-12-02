package com.pratham.blogapp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pratham.blogapp.Payloads.CategoryDto;

@Service
public interface CategoryService {

	//create 
	CategoryDto addCategory(CategoryDto categoryDto);
	
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	
	//Delete
	void deleteCategory(Integer categoryId);
	
	//getSingleCategory
	CategoryDto getCategoryById(Integer categoryId);
	
	
    //getAllCategory
	List<CategoryDto>getAllCategories();
	
	
}
