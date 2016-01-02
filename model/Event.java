package model;

import java.awt.Image;
import java.util.Date;

public class Event implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1175616276017341271L;
	private int id;
	private Date exp_date;
	private String description;
	private Image image;
	
	public Event(){
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getExp_date() {
		return exp_date;
	}
	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "Event [id=" + id + ", exp_date=" + exp_date + ", description=" + description + ", image=" + image + "]";
	}
	
	
}
