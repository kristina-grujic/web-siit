package model;

import java.awt.Image;
import java.util.ArrayList;

public class User implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6016133035899131575L;
	
	private String username;
	private String password;
	private String name;
	private String surname;
	private Role role;
	private String telephone;
	private String email;
	private Image image;
	private ArrayList<Review> reviews;
	private ArrayList<Object> objects;
	
	
	
	public ArrayList<Review> getReviews() {
		return reviews;
	}
	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}
	public ArrayList<Object> getObjects() {
		return objects;
	}
	
	public void setObjects(ArrayList<Object> objects) throws Exception{
		if (role==Role.MANAGER){
			this.objects = objects;
		}
		else{
			throw new Exception("User is not a manager");
		}
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
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
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ ", role=" + role + ", telephone=" + telephone + ", email=" + email + ", image=" + image + "]";
	}
}
