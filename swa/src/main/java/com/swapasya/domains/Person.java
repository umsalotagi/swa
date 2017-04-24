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

	// private String gUser;
	private String emailId;
	private long mobileNo;

	private String degree;
	private String branch;
	private int courseyear;
	private String division;
	private String rollNo;
	private String role;
	private Date admissionDate;

	private String parentName;
	private long parentContactNo;

	private Address permanentAddress; /////
	private Address currentAddress; /////
	// private String inPossession; // depricated
	// private String totalCategoryBksInPossesion;
	// Gender

	/**
	 * Full constructor
	 * 
	 * @param personID
	 * @param password
	 * @param personName
	 * @param emailId
	 * @param mobileNo
	 * @param degree
	 * @param branch
	 * @param courseyear
	 * @param division
	 * @param rollNo
	 * @param role
	 * @param admissionDate
	 * @param parentName
	 * @param parentContactNo
	 * @param permanentAddress
	 * @param currentAddress
	 */
	public Person(String personID, String password, String personName, String emailId, long mobileNo, String degree,
			String branch, int courseyear, String division, String rollNo, String role, Date admissionDate,
			String parentName, long parentContactNo, Address permanentAddress, Address currentAddress) {
		super();
		this.personID = personID;
		this.password = password;
		this.personName = personName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.degree = degree;
		this.branch = branch;
		this.courseyear = courseyear;
		this.division = division;
		this.rollNo = rollNo;
		this.role = role;
		this.admissionDate = admissionDate;
		this.parentName = parentName;
		this.parentContactNo = parentContactNo;
		this.permanentAddress = permanentAddress;
		this.currentAddress = currentAddress;
	}

	/**
	 * @return the parentName
	 */
	public String getParentName() {
		return parentName;
	}

	/**
	 * @param parentName
	 *            the parentName to set
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	/**
	 * @return the parentContactNo
	 */
	public long getParentContactNo() {
		return parentContactNo;
	}

	/**
	 * @param parentContactNo
	 *            the parentContactNo to set
	 */
	public void setParentContactNo(long parentContactNo) {
		this.parentContactNo = parentContactNo;
	}

	/**
	 * @return the personID
	 */
	public String getPersonID() {
		return personID;
	}

	/**
	 * @param personID
	 *            the personID to set
	 */
	public void setPersonID(String personID) {
		this.personID = personID;
	}

	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}

	/**
	 * @param personName
	 *            the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the mobileNo
	 */
	public long getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo
	 *            the mobileNo to set
	 */
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * @param degree
	 *            the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}

	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * @param branch
	 *            the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

	/**
	 * @return the courseyear
	 */
	public int getCourseyear() {
		return courseyear;
	}

	/**
	 * @param courseyear
	 *            the courseyear to set
	 */
	public void setCourseyear(int courseyear) {
		this.courseyear = courseyear;
	}

	/**
	 * @return the division
	 */
	public String getDivision() {
		return division;
	}

	/**
	 * @param division
	 *            the division to set
	 */
	public void setDivision(String division) {
		this.division = division;
	}

	/**
	 * @return the rollNo
	 */
	public String getRollNo() {
		return rollNo;
	}

	/**
	 * @param rollNo
	 *            the rollNo to set
	 */
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the admissionDate
	 */
	public Date getAdmissionDate() {
		return admissionDate;
	}

	/**
	 * @param admissionDate
	 *            the admissionDate to set
	 */
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	/**
	 * @return the permanentAddress
	 */
	public Address getPermanentAddress() {
		return permanentAddress;
	}

	/**
	 * @param permanentAddress
	 *            the permanentAddress to set
	 */
	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	/**
	 * @return the currentAddress
	 */
	public Address getCurrentAddress() {
		return currentAddress;
	}

	/**
	 * @param currentAddress
	 *            the currentAddress to set
	 */
	public void setCurrentAddress(Address currentAddress) {
		this.currentAddress = currentAddress;
	}

	@Override
	public String toString() {
		return "Person [personID=" + personID + ", personName=" + personName + ", rollNo=" + rollNo + ", branch="
				+ branch + "]";
	}

}
