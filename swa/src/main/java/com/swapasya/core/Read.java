package com.swapasya.core;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import java.util.List;

import com.mongodb.DBCollection;
import com.swapasya.dataTypes.BookProp;
import com.swapasya.dataTypes.BookTitleProp;
import com.swapasya.dataTypes.NameKinds;
import com.swapasya.dataTypes.PersonProp;
import com.swapasya.dataTypes.TransactionHistoryProp;

public class Read {
	

	
	public Read (String nameSpace) {
		

		
	}
	
	
	
	// AssignList, waitlist 
	
	public ArrayList<HashMap<String, String>> getAssignList (String personID) {

		return null;
	}
	
	
	public ArrayList<HashMap<String, String>> getWaitList (String personID) {
	    	
		return null;
	}
	
	
	
	
	
	public DBCollection getPerson (String personID) {
		
		return null;
	}
	
	
	public DBCollection getBook (String bookID) {
		
		return null;
	}
	
	public List<String> getBid()
	{
		List<String> l=new ArrayList<String>();
		
		try{
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return l;
	}
	
	public DBCollection getBookTitle (String titleID) {
		
		return null;
	}
	
	
	
	public DBCollection getBookTitle (DBCollection book) {
		
		return null;
	}
	
	
	public List<DBCollection> getHistory (String personID) throws TransactionFailed {
		
		
		return null;
		
		
	}
	
	
public List<DBCollection> getHistory2 (String personID) throws TransactionFailed {
		
		
		return null;
		
		
	}


	public List<DBCollection> searchCatalogue (String bookName) throws TransactionFailed {
		
	
		
		return null;
		
		
	}
	
	
	public List<DBCollection> getHistoryForBook (String bookID) throws TransactionFailed {
		
		
		
		return null;
	}

}
