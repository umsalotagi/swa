package com.swapasya.domains;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class WaitList {
	@Id
	private String id;

	private Date timestamp;
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
