package com.swapasya.domains;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TransactionHistory")
public class TransactionHistory {
	
	@Id
	private String transactionID ;
	@Indexed
	private String issuetype; //(BookaBank, normalissue) 	
	@Indexed
	private Date dateOfIssue ;
	@Indexed
	private Date dateOfReturn;
	@Indexed
	private String bookID ;
	@Indexed
	private String bookTitleID ;
	private double fineCollected ;
	@Indexed
	private String personID;
	@Indexed
	private int courseyear ;
	@Indexed
	private String branch ;
	@Indexed
	private String degree ;
	private String renewIndex = "renewIndex";
	private String bookName ;
	private String authour ;
	// role of issuer
	
	
}
