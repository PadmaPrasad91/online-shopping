package com.myapp.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.myapp.onlineshopping.model.RegisterModel;
import com.myapp.onlineshoppingbackend.dao.UserDao;
import com.myapp.onlineshoppingbackend.dto.Address;
import com.myapp.onlineshoppingbackend.dto.Cart;
import com.myapp.onlineshoppingbackend.dto.User;

@Component
public class RegisterHandler {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public RegisterModel init() {

		return new RegisterModel();
	}

	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}

	public String validateUser(User user, MessageContext error) {

		String transitionValue = "success";

		// checking if password matches confirm password
		if (!(user.getPassword().equals(user.getConfirmPassword()))) {

			error.addMessage(new MessageBuilder().error().source("confirmPassword")
					.defaultText("Password does not match").build());
			transitionValue = "failure";

		}

		// check the uniqueness of email id
		if (userDao.getByEmail(user.getEmail()) != null) {

			error.addMessage(
					new MessageBuilder().error().source("email").defaultText("This email id  already exists!").build());

			transitionValue = "failure";

		}

		return transitionValue;
	}

	public String saveAll(RegisterModel model) {

		String transitionValue = "success";

		// fetch the user

		User user = model.getUser();

		if (user.getRole().equals("USER")) {

			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}

		// encode the password
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		// save the user
		userDao.addUser(user);

		// get the address
		Address billing = model.getBilling();
		billing.setUser(user);
		billing.setBilling(true);

		// save the address

		userDao.addAddress(billing);

		return transitionValue;

	}
}
