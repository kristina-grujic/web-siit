package model;

import java.util.ArrayList;

public class Category {
	private String name;
	private String description;
	private ArrayList<Object> objects;
	
	public ArrayList<Object> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<Object> objects) {
		this.objects = objects;
	}

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
