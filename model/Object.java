package model;

import java.awt.Image;
import java.util.ArrayList;

public class Object implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6168508222041817569L;

	private String name;
	private String location;
	private String town;
	private String telephone;
	private String email;
	private String website;
	private int tin;
	private String giro;
	private Image image;
	private User manager;
	private ArrayList<Review> reviews;
	private Category category;
	private ArrayList<Event> events;

	
	public ArrayList<Review> getReviews() {
		return reviews;
	}
	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public ArrayList<Event> getEvents() {
		return events;
	}
	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}
	public User getManager() {
		return manager;
	}
	public void setManager(User manager) {
		this.manager = manager;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public int getTin() {
		return tin;
	}
	public void setTin(int tin) {
		this.tin = tin;
	}
	public String getGiro() {
		return giro;
	}
	public void setGiro(String giro) {
		this.giro = giro;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Object [name=" + name + ", location=" + location + ", town=" + town + ", telephone=" + telephone
				+ ", email=" + email + ", website=" + website + ", tin=" + tin + ", giro=" + giro + ", image=" + image
				+ "]";
	}
	public Object() {
		super();
	}
	
}
