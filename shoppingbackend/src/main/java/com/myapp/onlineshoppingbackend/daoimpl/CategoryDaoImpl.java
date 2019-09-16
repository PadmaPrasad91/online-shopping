package com.myapp.onlineshoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;
import org.springframework.stereotype.Repository;

import com.myapp.onlineshoppingbackend.dao.CategoryDao;
import com.myapp.onlineshoppingbackend.dto.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	private static List<Category> categories = new ArrayList<>();

	static {

		// addding first category
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is a 43 inch television!");
		category.setImageURL("CAT_1.png");
		categories.add(category);

		// second category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is a 5 inch mobile!");
		category.setImageURL("CAT_2.png");
		categories.add(category);

		// third category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is a 39.6 inch mobile!");
		category.setImageURL("CAT_3.png");
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories

		;
	}

	@Override
	public Category get(int id) {

		// enhanced for loop
		for (Category category : categories) {
			if (category.getId() == id)
				return category;
		}
		return null;
	}

}
