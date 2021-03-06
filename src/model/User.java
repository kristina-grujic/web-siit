package model;

public class User {
	private String username; //username is unique
	private String password;
	private String name;
	private String surname;
	private String email;
	private String iconpath;
	private String phoneNumber;
	private String role;
	
	
	@Override
	public String toString() {
		return "{\"username\" :\"" + username 
				+ "\", \"name\":\"" + name 
				+ "\", \"surname\":\"" + surname 
				+ "\", \"icon\":\"" + iconpath 
				+ "\", \"phone\":\"" + phoneNumber 
				+ "\", \"role\":\"" + role 
				+ "\", \"email\":\"" + email + "\"}";
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIconpath() {
		return iconpath;
	}
	public void setIconpath(String iconpath) {
		this.iconpath = iconpath;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public User(){
	}
}
