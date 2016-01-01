package beans;

import java.awt.Image;

public class Object implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6168508222041817569L;

	String name;
	String location;
	String town;
	String telephone;
	String email;
	String website;
	int tin;
	String giro;
	Image image;
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
	public Object(String name, String location, String town, String telephone, String email, String website, int tin,
			String giro, Image image) {
		super();
		this.name = name;
		this.location = location;
		this.town = town;
		this.telephone = telephone;
		this.email = email;
		this.website = website;
		this.tin = tin;
		this.giro = giro;
		this.image = image;
	}
	
}
