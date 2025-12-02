package com.pratham.blogapp.Service.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratham.blogapp.Exceptions.CategoryNotFound;
import com.pratham.blogapp.Exceptions.UserNotFound;
import com.pratham.blogapp.Payloads.CategoryDto;
import com.pratham.blogapp.Repository.CategoryRepo;
import com.pratham.blogapp.Service.CategoryService;
import com.pratham.blogapp.entities.Catagory;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
		
		Catagory category=modelMapper.map(categoryDto,Catagory.class);
		
		Catagory addedCategory =categoryRepo.save(category);
		
		return modelMapper.map(addedCategory, CategoryDto.class);
	}
	
	

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
	 Catagory category=categoryRepo.findById(categoryId).orElseThrow(()->new CategoryNotFound("Category","Category Id",categoryId));
     
	category.setCategoryTitle(categoryDto.getCategoryTitle());
	category.setCategoryDescription(categoryDto.getCategoryDescription());
	
	Catagory updated =categoryRepo.save(category);
		
		return modelMapper.map(updated, CategoryDto.class);
	}
	
	

	@Override
	public void deleteCategory(Integer categoryId) {
	
	Catagory foundCategory	=categoryRepo.findById(categoryId).orElseThrow(()->new CategoryNotFound("Category", "CategoryId", categoryId));
	
    	categoryRepo.delete(foundCategory);
	
	}
	
	

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		
	Catagory cat	=categoryRepo.findById(categoryId).orElseThrow(()->new CategoryNotFound("Category", "Category Id", categoryId));
		
	  CategoryDto avilableCategory =modelMapper.map(cat, CategoryDto.class);
		
		return avilableCategory;
	}

	@Override
	public List<CategoryDto> getAllCategories() {
	
		List<Catagory>AllCategory=categoryRepo.findAll();
		
   List<CategoryDto>all= AllCategory.stream()
		   .map(cate -> modelMapper.map(cate,CategoryDto.class)).collect(Collectors.toList());
		
		return all;
	}

}
