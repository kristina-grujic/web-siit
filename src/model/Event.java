package model;

import java.util.ArrayList;
import java.util.Date;

public class Event {
	private String id; //id is unique
	private Date checkinDate;
	private String description;
	private String iconPath;
	private ArrayList<User> checkedUsers;
	
	public ArrayList<User> getCheckedUsers() {
		return checkedUsers;
	}
	public void setCheckedUsers(ArrayList<User> checkedUsers) {
		this.checkedUsers = checkedUsers;
	}
	
	public boolean checkinUser(User user){
		if (this.userCheckedIn(user)!=-1){
			return false;
		}
		checkedUsers.add(user);
		return true;
	}
	
	public boolean uncheckUser(User user){
		int userIndex = this.userCheckedIn(user);
		if (userIndex!=-1){
			checkedUsers.remove(userIndex);
			return true;
		}
		return false;
	}
	
	public int userCheckedIn(User checkuser){
		for (int i=0; i<checkedUsers.size(); i++) {
			if (checkedUsers.get(i).getUsername().equals(checkuser.getUsername()))
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
	public Date getCheckinDate() {
		return checkinDate;
	}
	public void setCheckinDate(Date checkinDate) {
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
