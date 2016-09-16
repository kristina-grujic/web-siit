package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import utils.MySQLBaseReader;

/**
 * Servlet implementation class AuthServlet
 */
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		MySQLBaseReader dao;
		try {
			dao = new MySQLBaseReader();
			User user = dao.checkUser(username, password);
			response.setContentType("application/json");
			if (user!=null){
				String jsonObject = "{\"data\": {\"token\":\"user_token\", \"user\": "+
							user.toString() + "}}";
				PrintWriter out = response.getWriter();
				response.setStatus(HttpServletResponse.SC_OK);
				out.println(jsonObject);
				out.close();
				return;
			}
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
