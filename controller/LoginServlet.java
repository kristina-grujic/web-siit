package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

public class LoginServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7194706477901469142L;

	public LoginServlet(){
		super();
	}

	protected User login(String username, String password, ArrayList<User> users){
		for (int i = 0; i<users.size(); i++){
			if (users.get(i).getUsername().equals(username)&&
					users.get(i).getPassword().equals(password)){
				return users.get(i);
			}
		}
		return null;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u = (String) request.getParameter("user");
		String p = (String) request.getParameter("passwd");
		ArrayList<User> users = (ArrayList<User>) getServletContext().getAttribute("users");
		User user = login(u,p, users);
		if (user == null) {
			 request.setAttribute("success", "false");
			 getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		else {
			getServletContext().setAttribute("logged", user);
			 getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
				return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
