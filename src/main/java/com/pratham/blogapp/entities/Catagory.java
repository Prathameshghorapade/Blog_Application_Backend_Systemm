package com.pratham.blogapp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catagory implements Serializable {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int categoryId;
private String categoryTitle;

private String categoryDescription;


	@OneToMany(mappedBy = "catagory",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	List<Post>posts=new ArrayList<Post>();
	
	
	

}
