package com.project.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.dao.CategoryDAO;
import com.project.model.Category;

public class CategoryUnitTest {
    
	static CategoryDAO categoryDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	     context.scan("com.project");
	     context.refresh();
	     categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	     
	}
	@Test
	public void test() 
	{
		Category category = new Category();
		category.setCategoryName("Shirt");
		category.setCategoryDesc("Full Sleve");
		assertTrue("Problem in adding Category",categoryDAO.addCategory(category));
	}

}
