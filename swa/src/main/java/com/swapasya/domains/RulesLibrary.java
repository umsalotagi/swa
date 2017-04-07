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

	/**
	 * @param readerType_BkCatORissueType
	 * @param maxQuantity
	 * @param dayLimit
	 * @param maxTotalQuantity
	 * @param finePerDay
	 */
	public RulesLibrary(String readerType_BkCatORissueType, int maxQuantity, int dayLimit, int maxTotalQuantity,
			double finePerDay) {
		super();
		this.readerType_BkCatORissueType = readerType_BkCatORissueType;
		this.maxQuantity = maxQuantity;
		this.dayLimit = dayLimit;
		this.maxTotalQuantity = maxTotalQuantity;
		this.finePerDay = finePerDay;
	}

	/**
	 * @return the readerType_BkCatORissueType
	 */
	public String getReaderType_BkCatORissueType() {
		return readerType_BkCatORissueType;
	}

	/**
	 * @param readerType_BkCatORissueType the readerType_BkCatORissueType to set
	 */
	public void setReaderType_BkCatORissueType(String readerType_BkCatORissueType) {
		this.readerType_BkCatORissueType = readerType_BkCatORissueType;
	}

	/**
	 * @return the maxQuantity
	 */
	public int getMaxQuantity() {
		return maxQuantity;
	}

	/**
	 * @param maxQuantity the maxQuantity to set
	 */
	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	/**
	 * @return the dayLimit
	 */
	public int getDayLimit() {
		return dayLimit;
	}

	/**
	 * @param dayLimit the dayLimit to set
	 */
	public void setDayLimit(int dayLimit) {
		this.dayLimit = dayLimit;
	}

	/**
	 * @return the maxTotalQuantity
	 */
	public int getMaxTotalQuantity() {
		return maxTotalQuantity;
	}

	/**
	 * @param maxTotalQuantity the maxTotalQuantity to set
	 */
	public void setMaxTotalQuantity(int maxTotalQuantity) {
		this.maxTotalQuantity = maxTotalQuantity;
	}

	/**
	 * @return the finePerDay
	 */
	public double getFinePerDay() {
		return finePerDay;
	}

	/**
	 * @param finePerDay the finePerDay to set
	 */
	public void setFinePerDay(double finePerDay) {
		this.finePerDay = finePerDay;
	} 
	
	
	
}
