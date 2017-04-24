package com.swapasya.domains;

import org.springframework.data.annotation.Id;

public class Address {
	
	@Id
	private String id;
	
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	
	private String city;
	private String pincode;
	private String state;
	private String country;
	
	
	public Address(String id, String addressLine1, String addressLine2, String addressLine3, String city,
			String pincode, String state, String country) {
		super();
		this.id = id;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}


	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}


	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	/**
	 * @return the addressLine3
	 */
	public String getAddressLine3() {
		return addressLine3;
	}


	/**
	 * @param addressLine3 the addressLine3 to set
	 */
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}


	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}


	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}


	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	

}
