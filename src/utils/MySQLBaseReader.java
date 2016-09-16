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
import model.Premises;

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