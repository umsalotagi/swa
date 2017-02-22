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

}
