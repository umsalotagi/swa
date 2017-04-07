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
	
	/**
	 * @param transactionID
	 * @param issuetype
	 * @param dateOfIssue
	 * @param dateOfReturn
	 * @param bookID
	 * @param bookTitleID
	 * @param fineCollected
	 * @param personID
	 * @param courseyear
	 * @param branch
	 * @param degree
	 * @param renewIndex
	 * @param bookName
	 * @param authour
	 */
	public TransactionHistory(String transactionID, String issuetype, Date dateOfIssue, Date dateOfReturn,
			String bookID, String bookTitleID, double fineCollected, String personID, int courseyear, String branch,
			String degree, String renewIndex, String bookName, String authour) {
		super();
		this.transactionID = transactionID;
		this.issuetype = issuetype;
		this.dateOfIssue = dateOfIssue;
		this.dateOfReturn = dateOfReturn;
		this.bookID = bookID;
		this.bookTitleID = bookTitleID;
		this.fineCollected = fineCollected;
		this.personID = personID;
		this.courseyear = courseyear;
		this.branch = branch;
		this.degree = degree;
		this.renewIndex = renewIndex;
		this.bookName = bookName;
		this.authour = authour;
	}
	
	
	
}
