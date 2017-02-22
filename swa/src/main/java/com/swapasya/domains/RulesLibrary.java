package com.swapasya.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "RulesLibrary")
public class RulesLibrary {
	
	@Id
	private String readerType_BkCatORissueType; 
	private int maxQuantity ;  // ** only MAND for category type issue
	private int dayLimit ;  // *** MAND
	private int maxTotalQuantity ; 
	
	private double finePerDay ; 
	
	
	
}
