package com.myapp.onlineshoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * private fields
	 */
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;
	/* Many address belong to one user */

	@ManyToOne
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	/*------------------------------------*/

	@Column(name = "address_line_one")
	@NotBlank(message = "Please enter address line one!")
	private String addressLineOne;

	@Column(name = "address_line_two")
	@NotBlank(message = "Please enter address line two!")
	private String addressLineTwo;

	@NotBlank(message = "Please enter city!")
    private String city;

	@NotBlank(message = "Please enter state!")
    private String state;

	@NotBlank(message = "Please enter country!")
    private String country;

	@Column(name = "postal_code")
	@NotBlank(message = "Please enter postal code!")
    private String postalCode;

	private boolean shipping;

	private boolean billing;

	/*
	 * getters and setters for the fields
	 * 
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public boolean isShipping() {
		return shipping;
	}

	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}

	public boolean isBilling() {
		return billing;
	}

	public void setBilling(boolean billing) {
		this.billing = billing;
	}

	/*
	 * toString for logging and debugging activity
	 */

	@Override
	public String toString() {
		return "Address [id=" + id + ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode=" + postalCode
				+ ", shipping=" + shipping + ", billing=" + billing + "]";
	}

}
