package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Event;
import model.Premises;
import utils.MySQLBaseReader;

/**
 * Servlet implementation class EventServlet
 */
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String objectID = request.getParameter("objectID");
		
		MySQLBaseReader dao;
		try {
			dao = new MySQLBaseReader();
			List<Event> result = dao.searchEvents(objectID);
			PrintWriter out = response.getWriter();
			
			out.write("{\"data\":" + result.toString() + "}");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String object = request.getParameter("object");
		String date = request.getParameter("date");
		String description = request.getParameter("description");
		
		MySQLBaseReader dao;
		try {
			dao = new MySQLBaseReader();
			boolean result = dao.createEvent(object, date, description);
			PrintWriter out = response.getWriter();
			if (result){
				out.write("{\"data\": \"created\"}");
				out.close();
				return;
				
			}
			out.write("{\"errors\": \"Unable to create\"}");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
