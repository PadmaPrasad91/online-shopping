package com.myapp.onlineshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myapp.onlineshoppingbackend.dao.UserDao;
import com.myapp.onlineshoppingbackend.dto.Address;
import com.myapp.onlineshoppingbackend.dto.Cart;
import com.myapp.onlineshoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDao userDao;
	private User user = null;
	private Cart cart = null;
	private Address address = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.myapp.onlineshoppingbackend");
		context.refresh();

		userDao = (UserDao) context.getBean("userDao");
	}

//	@Test
//	public void testAdd() {
//
//		user = new User();
//		user.setFirstName("Lokesh");
//		user.setLastName("Rahul");
//		user.setEmail("kl.rahul@gmail.com");
//		user.setContactNumber("9185624875");
//		user.setRole("USER");
//		user.setPassword("123456");
//
//		// add user
//
//		assertEquals("Failed to add user", true, userDao.addUser(user));
//
//		address = new Address();
//		address.setAddressLineOne("Kodial Bail 3rd cross");
//		address.setAddressLineTwo("Benjana Padavu Mangalore");
//		address.setCity("Mangalore");
//		address.setState("Karnataka");
//		address.setCountry("India");
//		address.setPostalCode("578415");
//		address.setBilling(true);
//
//		// link the user with the address using id
//		address.setUserId(user.getId());
//		
//		// add the address
//		assertEquals("Failed to add address", true,userDao.addAddress(address));
//		
//		if(user.getRole().equals("USER")) {
//			
//			// create cart for this user
//			
//			cart =new Cart();
//			cart.setUser(user);
//			
//			
//			// add the cart
//			assertEquals("Failed to add cart", true,userDao.addCart(cart));
//			
//			// add a shipping address for this user
//			
//			address = new Address();
//			address.setAddressLineOne("Kodial Bail 3rd cross");
//			address.setAddressLineTwo("Benjana Padavu Mangalore");
//			address.setCity("Mangalore");
//			address.setState("Karnataka");
//			address.setCountry("India");
//			address.setPostalCode("578415");
//			// set shipping address to true
//			address.setShipping(true);
//			
//			// link it with the user
//			
//			address.setUserId(user.getId());
//			
//			// add the shipping address
//			assertEquals("Failed to add shipping address", true,userDao.addAddress(address));
//
//		}
//	}

//	@Test
//	public void testAdd() {
//
//		user = new User();
//		user.setFirstName("Lokesh");
//		user.setLastName("Rahul");
//		user.setEmail("kl.rahul@gmail.com");
//		user.setContactNumber("9185624875");
//		user.setRole("USER");
//		user.setPassword("123456");
//
//		// add user
//
//
//		if(user.getRole().equals("USER")) {
//			
//			// create cart for this user	
//			cart =new Cart();
//		    cart.setUser(user);
//		    
//		    // attach cart with the user
//		    user.setCart(cart);
//		}
//		
//		assertEquals("Failed to add user", true, userDao.addUser(user));
//
//	}

//	@Test
//	public void testUpdateCart() {
//		// fetch the user by its email
//
//		user = userDao.getByEmail("kl.rahul@gmail.com");
//
//		// get the cart of the user
//
//		cart = user.getCart();
//
//		cart.setGrandTotal(12564);
//		cart.setCartLines(2);
//		assertEquals("Failed to update the cart!", true, userDao.updateCart(cart));
//	}

//	@Test
//	public void testAddAddress() {
//		
//		// we need to add an user
//		
//		user = new User();
//		user.setFirstName("Lokesh");
//		user.setLastName("Rahul");
//		user.setEmail("kl.rahul@gmail.com");
//		user.setContactNumber("9185624875");
//		user.setRole("USER");
//		user.setPassword("123456");
//
//		// add user
//
//		assertEquals("Failed to add user", true, userDao.addUser(user));
//
//		//we are going to add the addresss
//		
//		address = new Address();
//		address.setAddressLineOne("Kodial Bail 3rd cross");
//		address.setAddressLineTwo("Benjana Padavu Mangalore");
//		address.setCity("Mangalore");
//		address.setState("Karnataka");
//		address.setCountry("India");
//		address.setPostalCode("578415");
//		address.setBilling(true);
//   
//		// attach the user to the address
//		address.setUser(user);
//		
//		assertEquals("Failed to add address",true,userDao.addAddress(address));
//		
//		
//		
//		//we are going to add the shipping address
//		
//		address = new Address();
//		address.setAddressLineOne("Kodial Bail 3rd cross");
//		address.setAddressLineTwo("Benjana Padavu Mangalore");
//		address.setCity("Mangalore");
//		address.setState("Karnataka");
//		address.setCountry("India");
//		address.setPostalCode("578415");
//
//		// attach the user to the address
//				address.setUser(user);
//		
//		assertEquals("Failed to add shipping address", true,userDao.addAddress(address));
//	}

//	@Test
//	public void testAddres() {
//		// we are also going to add the shipping address
//
//		// we are going to add the shipping address
//		user = userDao.getByEmail("kl.rahul@gmail.com");
//		address = new Address();
//		address.setAddressLineOne("Kodial Bail 3rd cross");
//		address.setAddressLineTwo("Benjana Padavu Mangalore");
//		address.setCity("Kudroli");
//		address.setState("karnataka");
//		address.setCountry("India");
//		address.setPostalCode("586324");
//		address.setShipping(true);
//
//		// attach the user to the address
//		address.setUser(user);
//
//		assertEquals("Failed to add shipping address", true, userDao.addAddress(address));
//	}

	@Test
	public void testGetAddresses() {
		user = userDao.getByEmail("kl.rahul@gmail.com");

		assertEquals("Failed to fetch the list of address and size does not match",1,userDao.listShippingAddresses(user).size());
	
		assertEquals("Failed to fetch the billing address and size does not match","Mangalore",userDao.getBillingAddress(user).getCity());

	}
}
