package com.pratham.blogapp.Exceptions;

public class CategoryNotFound extends RuntimeException {

	 private String resourceName;
	    private String fieldName;
	    private long fieldValue;

	    public CategoryNotFound(String resourceName, String fieldName, long fieldValue) {
	        // This line correctly passes the message to RuntimeException
	        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
	        this.resourceName = resourceName;
	        this.fieldName = fieldName;
	        this.fieldValue = fieldValue;
	    }

	    public String getResourceName() {
	        return resourceName;
	    }

	    public String getFieldName() {
	        return fieldName;
	    }

	    public long getFieldValue() {
	        return fieldValue;
	    }

	
}
