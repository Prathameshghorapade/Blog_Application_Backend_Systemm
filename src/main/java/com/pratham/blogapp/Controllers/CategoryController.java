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
import com.pratham.blogapp.Payloads.CategoryDto;
import com.pratham.blogapp.Service.CategoryService;
import com.pratham.blogapp.Service.UserSevice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	

	@Autowired
	CategoryService categoryService;
	
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto>addCategory(@Valid  @RequestBody CategoryDto categoryDto) {
		
		CategoryDto cat=categoryService.addCategory(categoryDto);
		
		return new ResponseEntity<CategoryDto>(cat,HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("{categoryId}")
	public ResponseEntity<CategoryDto>updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){
		
		CategoryDto updatedCategory=categoryService.updateCategory(categoryDto, categoryId);
		
		return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);
		
		
	}
	
	
	@DeleteMapping("{categoryId}")
	public ResponseEntity<ApiResponse> DeletedCategory(@PathVariable Integer categoryId){
		
		categoryService.deleteCategory(categoryId);
		
		return new ResponseEntity<ApiResponse>( new ApiResponse("Category Deleted Successfully", true),HttpStatus.OK);
	}
	
	
	@GetMapping("{categoryId}")
	public ResponseEntity<CategoryDto>getCategory(@PathVariable Integer categoryId){
		
	CategoryDto singleCategory	=categoryService.getCategoryById(categoryId);
		
		return new ResponseEntity<CategoryDto>(singleCategory,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<CategoryDto>>getAllCategory(){
		
	List<CategoryDto>all	=categoryService.getAllCategories();
		
		return new ResponseEntity<List<CategoryDto>>(all,HttpStatus.OK);
	}
	

}
