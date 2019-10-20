package com.myapp.onlineshoppingbackend.dao;

import java.util.List;

import com.myapp.onlineshoppingbackend.dto.Address;
import com.myapp.onlineshoppingbackend.dto.Cart;
import com.myapp.onlineshoppingbackend.dto.User;

public interface UserDao {

	// add an user
	boolean addUser(User user);

	User getByEmail(String email);

	// add an address
	boolean addAddress(Address address);
	// alternative
	//Address getBillingAddress(int userId)
	//	List<Address> listShippingAddresses(int userId);


	Address getBillingAddress(User user);
	
	List<Address> listShippingAddresses(User user);

	// update the cart
	boolean updateCart(Cart cart);
}
