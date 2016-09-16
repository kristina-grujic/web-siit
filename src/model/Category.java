package model;

public class Category {
	private String name; //name is unique
	private String description;
	

	@Override
	public String toString() {
		return "{\"name\" :\"" + name 
				+ "\", \"description\":\"" + description + "\"}";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Category(){
	}
}
