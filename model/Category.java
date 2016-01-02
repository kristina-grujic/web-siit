package model;

public class Category {
	private String name;
	private String description;
	
	public Category(){
		super();
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
	
	@Override
	public String toString() {
		return "Category [name=" + name + ", description=" + description + "]";
	}
	
	
	
}
