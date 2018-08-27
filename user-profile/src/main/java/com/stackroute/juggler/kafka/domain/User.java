package com.stackroute.juggler.kafka.domain;

import java.util.Arrays;

import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//these are the annotations for lambok so that we wont use setters and getters
//This domain object is used to save the data ie., interact with the database
//Password is ignored and not saved into database but published in the message bus


@Document
public class User {


	// this user_id is set as id
	@Id
	private int userId;
	@Size(min = 6, max = 20)
	private String userName;
	private String emailId;
	private double mobileNo;
	@Size(min = 8, max = 20)
	private String password;
	private String gender;
	private String dateOfBirth;
	private String[] LanguagesKnown;
	private String[] genre;
	private String location;
	private String[] paymentMethods;
	private String likes;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public double getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(double mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String[] getLanguagesKnown() {
		return LanguagesKnown;
	}
	public void setLanguagesKnown(String[] languagesKnown) {
		LanguagesKnown = languagesKnown;
	}
	public String[] getGenre() {
		return genre;
	}
	public void setGenre(String[] genre) {
		this.genre = genre;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String[] getPaymentMethods() {
		return paymentMethods;
	}
	public void setPaymentMethods(String[] paymentMethods) {
		this.paymentMethods = paymentMethods;
	}
	public String getLikes() {
		return likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", emailId=" + emailId + ", mobileNo=" + mobileNo
				+ ", password=" + password + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", LanguagesKnown="
				+ Arrays.toString(LanguagesKnown) + ", genre=" + Arrays.toString(genre) + ", location=" + location
				+ ", paymentMethods=" + Arrays.toString(paymentMethods) + ", likes=" + likes + "]";
	}
	public User(int userId, @Size(min = 6, max = 20) String userName, String emailId, double mobileNo,
			@Size(min = 8, max = 20) String password, String gender, String dateOfBirth, String[] languagesKnown,
			String[] genre, String location, String[] paymentMethods, String likes) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.password = password;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		LanguagesKnown = languagesKnown;
		this.genre = genre;
		this.location = location;
		this.paymentMethods = paymentMethods;
		this.likes = likes;
	}
	public User() {
		super();
	}
	
	
}
