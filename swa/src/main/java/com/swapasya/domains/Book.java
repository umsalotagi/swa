package com.swapasya.domains;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * @author Umesh
 *
 */

public class Book {
	
	// NOTES
		//  waitlist, no. of books of same title.logic is yet to be decided
		//  same book is not allowed to return and again take away in same day by same person.
		@Id
		private String bookID;   //  ***Mand
		
		private Date purchaseDate;
		private double price;
		
		@Indexed
		private String borrowedBy; //(personid)
		private String issuedType; // (e.g bookbank/normalissue?)(to be decided at run time for return date)
		private String categoryType ; // (e.g CD/book/magazine)decided while storing book   ***Mand
		
		@DateTimeFormat(iso = ISO.DATE_TIME)
		private Date issueDate ;
		@DateTimeFormat(iso = ISO.DATE_TIME)
		private Date expectedReturnDate ;

}
