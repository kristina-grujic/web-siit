package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;
import model.Event;
import model.Review;
import model.Object;
import model.User;

public class MasterServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2511666839191793525L;
	ArrayList<User> users= new ArrayList<User>();
	ArrayList<Object> objects = new ArrayList<Object>();
	ArrayList<Review> reviews = new ArrayList<Review>();
	ArrayList<Event> events = new ArrayList<Event>();
	ArrayList<Category> categories = new ArrayList<Category>();
	
	public MasterServlet(){
		super();

	}
	@Override
	public void init() throws ServletException {
		super.init();		
		getServletContext().setAttribute("objects", objects);
		getServletContext().setAttribute("reviews", reviews);
		getServletContext().setAttribute("events", events);
		getServletContext().setAttribute("categories", categories);
		getServletContext().setAttribute("logged", null);
		User u = new User();
		u.setUsername("proba");
		u.setPassword("proba");
		users.add(u);
		getServletContext().setAttribute("users", users);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String referer = (String) request.getParameter("referer");
		if (referer.equals("login")){
			getServletContext().getRequestDispatcher("/LoginServlet").forward(request, response);
		}
		if (referer.equals("logout")){
			getServletContext().setAttribute("logged", null);
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
	}
}
