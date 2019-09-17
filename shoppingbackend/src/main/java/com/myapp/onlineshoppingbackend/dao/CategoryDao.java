package com.myapp.onlineshoppingbackend.dao;

import java.util.List;

import com.myapp.onlineshoppingbackend.dto.Category;

public interface CategoryDao {

	Category get(int id);

	List<Category> list();

	boolean add(Category category);

	boolean update(Category category);

	boolean delete(Category category);

}
