package com.myapp.onlineshoppingbackend.dao;

import java.util.List;

import com.myapp.onlineshoppingbackend.dto.Category;

public interface CategoryDao {
	
	List<Category> list();
	Category get(int id);

}
