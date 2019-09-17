package com.myapp.onlineshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myapp.onlineshoppingbackend.dao.CategoryDao;
import com.myapp.onlineshoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDao categoryDao;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.myapp.onlineshoppingbackend");
		context.refresh();

		categoryDao = (CategoryDao) context.getBean("categoryDao");
	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category(); category.setName("Laptop");
	 * category.setDescription("This is a 15.6 inch laptop!");
	 * category.setImageURL("CAT_5.png");
	 * 
	 * assertEquals("Successfully added a category inside the table",true,
	 * categoryDao.add(category)); }
	 */

	/*
	 * @Test public void testGetCategory() { category = categoryDao.get(1);
	 * assertEquals("Successfully fetched a single category from the table"
	 * ,"Television",category.getName());
	 * 
	 * }
	 */

//	@Test
//	public void testUpdateCategory() {
//		category = categoryDao.get(1);
//		category.setName("TV");
//		assertEquals("Successfully updated a single category in the table", true, categoryDao.update(category));
//
//	}

//	@Test
//	public void testDeleteCategory() {
//		category = categoryDao.get(3);
//		assertEquals("Successfully deleted a single category in the table", true, categoryDao.delete(category));
//
//	}

//	@Test
//	public void testListCategory() {
//		assertEquals("Successfully fetched the list of  categories from the table",2, categoryDao.list().size());
//
//	}

	@Test
	public void testCRUDCategory() {

		// add operation
		category = new Category();
		category.setName("Television");
		category.setDescription("This is a 45.6 inch Television!");
		category.setImageURL("CAT_1.png");

		assertEquals("Successfully added a single category from the table", true, categoryDao.add(category));

		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is a 15.6 inch laptop!");
		category.setImageURL("CAT_2.png");

		assertEquals("Successfully added a single category from the table", true, categoryDao.add(category));

		// fetching and updating the category

		category = categoryDao.get(1);
		category.setName("TV");


		assertEquals("Successfully updated a single category in the table", true, categoryDao.update(category));
		
		// deleting the category
		
		assertEquals("Successfully deleted a single category in the table", true, categoryDao.delete(category));
		
		// fetching the list
		
		assertEquals("Successfully fetched the list of  categories from the table",1, categoryDao.list().size());
	}

}
