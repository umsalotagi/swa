package com.swapasya.domains;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class WaitList {
	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
