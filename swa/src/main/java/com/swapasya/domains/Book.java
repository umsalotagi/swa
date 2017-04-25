package com.swapasya.domains;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * @author Umesh
 *
 */
/*
 * this @Document is very important otherwise it will be just object not embeddd document
 * and more @Document due to this id will be unique across row
 */
//@Document
public class Book {
	
	// NOTES
		//  waitlist, no. of books of same title.logic is yet to be decided
		//  same book is not allowed to return and again take away in same day by same person.
//		@Id
//		private String bookID; 
	
//		@Id
//		private ObjectId id = new ObjectId();
	
		@Indexed(unique=true,sparse=true)
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
		
		
		/**
		 * @param bookID
		 * @param purchaseDate
		 * @param price
		 * @param categoryType
		 */
		public Book(String bookID, Date purchaseDate, double price, String categoryType) {
			this.bookID = bookID;
			this.purchaseDate = purchaseDate;
			this.price = price;
			this.categoryType = categoryType;
		}


		public String getBookID() {
			return bookID;
		}


		public void setBookID(String bookID) {
			this.bookID = bookID;
		}


		public Date getPurchaseDate() {
			return purchaseDate;
		}


		public void setPurchaseDate(Date purchaseDate) {
			this.purchaseDate = purchaseDate;
		}


		public double getPrice() {
			return price;
		}


		public void setPrice(double price) {
			this.price = price;
		}


		public String getBorrowedBy() {
			return borrowedBy;
		}


		public void setBorrowedBy(String borrowedBy) {
			this.borrowedBy = borrowedBy;
		}


		public String getIssuedType() {
			return issuedType;
		}


		public void setIssuedType(String issuedType) {
			this.issuedType = issuedType;
		}


		public String getCategoryType() {
			return categoryType;
		}


		public void setCategoryType(String categoryType) {
			this.categoryType = categoryType;
		}


		public Date getIssueDate() {
			return issueDate;
		}


		public void setIssueDate(Date issueDate) {
			this.issueDate = issueDate;
		}


		public Date getExpectedReturnDate() {
			return expectedReturnDate;
		}


		public void setExpectedReturnDate(Date expectedReturnDate) {
			this.expectedReturnDate = expectedReturnDate;
		}
		
		

}
