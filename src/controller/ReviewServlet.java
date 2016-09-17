package controller;

import model.Premises;
import model.Review;
import utils.MySQLBaseReader;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ObjectServlet
 */
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
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
			List<Review> result = dao.getObjectReviews(objectID);
			PrintWriter out = response.getWriter();
			System.out.println(result.toString());
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
		//String object, String user, String reviewText, String date, int rate
		String object = request.getParameter("object");
		String user = request.getParameter("user");
		String reviewText = request.getParameter("reviewText");
		int rate = Integer.parseInt(request.getParameter("rate"));
		String date = request.getParameter("date");
		
		MySQLBaseReader dao;
		try {
			dao = new MySQLBaseReader();
			boolean result = dao.createReview(object, user, reviewText, date, rate);
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
