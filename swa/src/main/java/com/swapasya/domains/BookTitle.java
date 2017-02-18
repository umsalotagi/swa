package com.swapasya.domains;

import java.util.ArrayList;

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
	private String author; // ***Mand
	@Indexed
	private String publication;

	private String bindingType;
	@Indexed
	private ArrayList<String> tags; // e.g. english;general
	private int noOfPages;
	private String language;
	private String imgPath;
}
