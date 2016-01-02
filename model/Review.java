package model;

import java.util.Date;

public class Review implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6896076124262039046L;
	private int id;
	private String text;
	private Date date;
	private int rate;
	
	public Review(){
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	@Override
	public String toString() {
		return "Review [id=" + id + ", text=" + text + ", date=" + date + ", rate=" + rate + "]";
	}
	
	
	
}
