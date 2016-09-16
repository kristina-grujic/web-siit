package model;

import java.util.ArrayList;
import java.util.Date;

public class Event {
	private String id; //id is unique
	private String checkinDate;
	private String description;
	private String iconPath;
	private ArrayList<String> checkedUsers;

	@Override
	public String toString() {
		return "{\"id\" :\"" + id 
				+ "\", \"description\":\"" + description 
				+ "\", \"icon\":\"" + iconPath 
				+ "\", \"checkinDate\":\"" + checkinDate 
				+ "\", \"users\":\"" + checkedUsers.toString() + "\"}";
	}
	
	public ArrayList<String> getCheckedUsers() {
		return checkedUsers;
	}
	public void setCheckedUsers(ArrayList<String> checkedUsers) {
		this.checkedUsers = checkedUsers;
	}

	public boolean checkinUser(String user){
		if (this.userCheckedIn(user)!=-1){
			return false;
		}
		checkedUsers.add(user);
		return true;
	}

	public boolean uncheckUser(String user){
		int userIndex = this.userCheckedIn(user);
		if (userIndex!=-1){
			checkedUsers.remove(userIndex);
			return true;
		}
		return false;
	}

	public int userCheckedIn(String checkuser){
		for (int i=0; i<checkedUsers.size(); i++) {
			if (checkedUsers.get(i).equals(checkuser))
				return i;
		}
		return -1;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCheckinDate() {
		return checkinDate;
	}
	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIconPath() {
		return iconPath;
	}
	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public Event(){
	}
}
