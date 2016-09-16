package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import model.User;

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

  public void readDataBase() throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/reviewer?"
              + "user=kristina&password=password");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      resultSet = statement
          .executeQuery("select * from reviewer.users");
      writeResultSet(resultSet);

    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }

  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    while (resultSet.next()) {
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
      String username = resultSet.getString("username");
      String password = resultSet.getString("password");
      System.out.println("Username: " + username);
      System.out.println("Password: " + password);
    }
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