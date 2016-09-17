package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.User;
import model.Category;
import model.Event;
import model.Premises;
import model.Review;

public class MySQLBaseReader {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;
  
  public MySQLBaseReader() throws ClassNotFoundException {
	// TODO Auto-generated constructor stub
	  Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      try {
		connect = DriverManager
		      .getConnection("jdbc:mysql://localhost/reviewer?"
		          + "user=kristina&password=password");
      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  }
  
  public boolean createEvent(String object, String date, String description){
	  try {
		    preparedStatement = connect
		            .prepareStatement("insert into  reviewer.events values (default, ?, ?, ?, ?);");
		       	preparedStatement.setString(1, date);
		        preparedStatement.setString(2, description);
		        preparedStatement.setString(3, "https://a2ua.com/event/event-007.jpg");
		        preparedStatement.setString(4, object);
		        preparedStatement.executeUpdate();
		    	return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return false;
		}
  }
  
  public List<Category> getCategories(){
		List<Category> result = new ArrayList<Category>();
		try {
			resultSet = statement.executeQuery("SELECT * FROM reviewer.categories;");
			while (resultSet.next()){
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				Category cat = new Category();
				cat.setDescription(description);
				cat.setName(name);
				result.add(cat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
  }
  
  public User checkUser(String username, String password){
	 try {
		resultSet = statement.executeQuery(
				 "SELECT * FROM reviewer.users WHERE username='"+username
				 +"' AND password='" + password + "';");
		User user = null;
	    while (resultSet.next()) {
	    	String name = resultSet.getString("name");
	    	String surname = resultSet.getString("surname");
	    	String email = resultSet.getString("email");
	    	String iconpath = resultSet.getString("iconpath");
	    	String phonenumber = resultSet.getString("phonenumber");
	    	String role = resultSet.getString("role");
	    	user= new User();
	    	
	    	user.setUsername(username);
	    	user.setName(name);
	    	user.setSurname(surname);
	    	user.setPassword(password);
	    	user.setEmail(email);
	    	user.setIconpath(iconpath);
	    	user.setPhoneNumber(phonenumber);
	    	user.setRole(role);
	    	return user;
	    }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 return null;
	}

	 return null;
}
  
  public boolean deleteObject(String tin){
	  try {
		  statement = connect.createStatement();
		  String sql = "DELETE FROM reviewer.objects WHERE tin='"+tin+"';";
		  statement.executeUpdate(sql);
		  return true;
	  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return false;
		}
  }
  
  public boolean deleteReview(String object, String user){
	  try {
		  statement = connect.createStatement();
		  String sql = "DELETE FROM reviewer.reviews WHERE objectTIN='"+object+"' AND userID='"+user+"';";
		  statement.executeUpdate(sql);
		  return true;
	  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return false;
		}
  }
  
  public List<Review> getObjectReviews(String tin){
	  List<Review> result = new ArrayList<Review>();
	  try {
			resultSet = statement.executeQuery("SELECT * FROM reviewer.reviews"
+ " INNER JOIN reviewer.users "
+ "ON reviewer.reviews.userID=reviewer.users.username WHERE objectTIN='"+tin+ "';");
		    while (resultSet.next()) {
		    	Review review = new Review();
		    	User mapped = new User();

	    		mapped.setUsername(resultSet.getString("username"));
	    		mapped.setIconpath(resultSet.getString("iconpath"));
		    	review.setCreator(mapped);
		    	review.setDate(resultSet.getString("created"));
		    	review.setId(resultSet.getInt("id")+"");
		    	review.setPremises(tin);
		    	review.setRate(resultSet.getInt("rate"));
		    	review.setReviewText(resultSet.getString("reviewText"));
		    	
		    	result.add(review);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return result;
  }
  
  public List<Event> searchEvents(String objectTin){
	  List<Event> result = new ArrayList<Event>();
	  try {
			resultSet = statement.executeQuery("SELECT * FROM reviewer.events"
					+ " WHERE object='"+objectTin+ "';");

		    while (resultSet.next()) {
		    	Event event = new Event();
		    	event.setCheckinDate(resultSet.getString("checkinDate"));
		    	event.setDescription(resultSet.getString("description"));
		    	event.setIconPath(resultSet.getString("iconPath"));
		    	event.setObject(resultSet.getString("object"));
		    	
		    	result.add(event);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return result;
  }
  
  public boolean createReview(String object, String user, String reviewText, String date, int rate){
	  try {
		    preparedStatement = connect
		            .prepareStatement("insert into  reviewer.reviews values (default, ?, ?, ?, ? , ?)");
		       	preparedStatement.setString(1, date);
		        preparedStatement.setString(2, reviewText);
		        preparedStatement.setInt(3, rate);
		        preparedStatement.setString(4, user);
		        preparedStatement.setString(5, object);
		        preparedStatement.executeUpdate();
		    	return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return false;
		}
  }
  
  public User signUp(String username, String email, String password){
		 try {
			resultSet = statement.executeQuery(
					 "SELECT * FROM reviewer.users WHERE username='"+username
					 +"' OR email='" + email + "';");
			User user = null;
		    while (resultSet.next()) {
		    	user = new User();
		    }
		    if (user!=null){
		    	return null;
		    }
		    preparedStatement = connect
		            .prepareStatement("insert into  reviewer.users values (?, ?, ?, ?, ? , ?, ?, ?)");
		       	preparedStatement.setString(1, username);
		        preparedStatement.setString(2, "");
		        preparedStatement.setString(3, "");
		        preparedStatement.setString(4, email);
		        preparedStatement.setString(5, password);
		        preparedStatement.setString(6, "http://userproplugin.com/userpro/wp-content/plugins/userpro/img/default_avatar_male.jpg");
		        preparedStatement.setString(7, "");
		        preparedStatement.setString(8, "customer");
		        preparedStatement.executeUpdate();
		    
		        user= new User();
		    	user.setUsername(username);
		    	user.setPassword(password);
		    	user.setEmail(email);
		    	user.setRole("customer");
		    	return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return null;
		}
	}
  
  public boolean createObject(String name, String address, String town, String phone,
		  String email, String website, String tin,String bank_account, String manager, String category){
	  try {
	  resultSet = statement.executeQuery(
				 "SELECT * FROM reviewer.objects WHERE tin='"+tin
				 +"' OR bankAccount='" + bank_account + "';");
		Premises premises = null;
	    while (resultSet.next()) {
	    	premises = new Premises();
	    }
	    if (premises!=null){
	    	return false;
	    }
	    preparedStatement = connect
	            .prepareStatement("insert into  reviewer.objects values (?, ?, ?, ?, ? , ?, ?, ?, ?, ?, ?)");
	       	preparedStatement.setString(1, name);
	        preparedStatement.setString(2, address);
	        preparedStatement.setString(3, town);
	        preparedStatement.setString(4, phone);
	        preparedStatement.setString(5, email);
	        preparedStatement.setString(6, website);
	        preparedStatement.setString(7, "http://www.hoianriverresort.com/assets_hotel/images/restaurant.jpeg");
	        preparedStatement.setString(8, tin);
	        preparedStatement.setString(9, bank_account);
	        preparedStatement.setString(10, manager);
	        preparedStatement.setString(11, category);
	        
	        preparedStatement.executeUpdate();
	    
	  return true;
	  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return false;
		}
  }
  
  public List<Premises> searchObjects(String query){
	  List<Premises> result = new ArrayList<Premises>();
		try {
			resultSet = statement.executeQuery("SELECT * FROM reviewer.objects WHERE name LIKE '"+query
					+"%' OR address LIKE'" + query
					 +"%' OR town LIKE '" + query + "%';");
		    while (resultSet.next()) {
		    	Premises premises = new Premises();
		    	premises.setName(resultSet.getString("name"));
		    	premises.setAddress(resultSet.getString("address"));
		    	premises.setTown(resultSet.getString("town"));
		    	premises.setPhoneNumber(resultSet.getString("phone"));
		    	premises.setEmail(resultSet.getString("email"));
		    	premises.setWebsite(resultSet.getString("website"));
		    	premises.setIconPath(resultSet.getString("iconpath"));
		    	premises.setCategory(resultSet.getString("category"));
		    	premises.setTin(resultSet.getString("tin"));
		    	premises.setBankAccount(resultSet.getString("bankAccount"));
		    	premises.setManager(resultSet.getString("manager"));
		    	result.add(premises);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  return result;
  }


  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }

} 