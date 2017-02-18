package com.swapasya.domains;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Umesh
 *
 */
@Document(collection = "Person")
public class Person {
 @Id
 private String personID;
 private String password;
 @Indexed
 private String personName;
 private String address; /////
// private String gUser;
 private String emailId;
 private long mobileNo;
 private long contactNo;
 private String degree;
 private String branch;
 private int courseyear;
 private String division;
 private String rollNo;
 private String role;
 private Date admissionDate;
// private String inPossession; // depricated
 //private String totalCategoryBksInPossesion;
 
 
 
 @Override
 public String toString() {
  return "Person [personID=" + personID + ", personName=" + personName + ", rollNo="
    + rollNo + ", branch=" + branch + "]";
 }
}
