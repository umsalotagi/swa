package com.swapasya.domains;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Umesh
 *
 */
@Document(collection = "BookTitle")
public class BookTitle {

	/*
	 * in the mongo shell, you can access the creation time of the ObjectId,
	 * using the ObjectId.getTimestamp() method. sorting on an _id field that
	 * stores ObjectId values is roughly equivalent to sorting by creation time.
	 */
	@Id
	private String bookTitleID; // ***Mand
	private String isbnNumber;
	@Indexed
	private String bookName; // ***Mand
	@Indexed
	private String authour; // ***Mand
	@Indexed
	private String publication;

	private String bindingType;
	@Indexed
	private ArrayList<String> tags; // e.g. english;general
	private int noOfPages;
	private String language;
	private String imgPath;
	
	List<Book> books;
	
	/**
	 * @param bookTitleID
	 * @param isbnNumber
	 * @param bookName
	 * @param author
	 * @param publication
	 * @param bindingType
	 * @param tags
	 * @param noOfPages
	 * @param language
	 */
	public BookTitle(String bookTitleID, String isbnNumber, String bookName, String authour, String publication,
			String bindingType, ArrayList<String> tags, int noOfPages, String language) {
		super();
		this.bookTitleID = bookTitleID;
		this.isbnNumber = isbnNumber;
		this.bookName = bookName;
		this.authour = authour;
		this.publication = publication;
		this.bindingType = bindingType;
		this.tags = tags;
		this.noOfPages = noOfPages;
		this.language = language;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public void addBook (Book book) {
		this.books.add(book);
	}

	public String getBookTitleID() {
		return bookTitleID;
	}

	public void setBookTitleID(String bookTitleID) {
		this.bookTitleID = bookTitleID;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return authour;
	}

	public void setAuthor(String author) {
		this.authour = author;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getBindingType() {
		return bindingType;
	}

	public void setBindingType(String bindingType) {
		this.bindingType = bindingType;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	
	
}
