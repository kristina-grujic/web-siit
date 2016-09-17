package controller;

import model.Premises;
import model.User;
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
public class ObjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String query = request.getParameter("query");
		
		MySQLBaseReader dao;
		try {
			dao = new MySQLBaseReader();
			List<Premises> result = dao.searchObjects(query);
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
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String town = request.getParameter("town");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String website = request.getParameter("website");
		String tin = request.getParameter("tin");
		String bank_account = request.getParameter("bank_account");
		String manager = request.getParameter("manager");
		
		MySQLBaseReader dao;
		try {
			dao = new MySQLBaseReader();
			boolean result = dao.createObject(name, address, town, phone,
					email, website, tin, bank_account, manager);
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
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("application/json");
		String objectTIN = request.getParameter("tin");
		
		MySQLBaseReader dao;
		try {
			dao = new MySQLBaseReader();
			boolean result = dao.deleteObject(objectTIN);
			PrintWriter out = response.getWriter();
			if (result){
				out.write("{\"data\": \"deleted\"}");
				out.close();
				return;
				
			}
			out.write("{\"errors\": \"Unable to delete\"}");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
