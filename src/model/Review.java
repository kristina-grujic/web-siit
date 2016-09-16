package model;

import java.util.Date;

public class Review {
	private String id; //id is unique
	private String reviewText;
	private Date date;
	private int rate; //rate can take value from 1 to 5
	private String user;
	private String premisesTIN;

	public String getUser(){
		return user;
	}
	public String getPremises() {
		return premisesTIN;
	}
	public void setPremises(String premises) {
		this.premisesTIN = premises;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}

	public Review(){
	}
}
