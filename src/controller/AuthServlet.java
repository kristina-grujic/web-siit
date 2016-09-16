package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		System.out.println("post");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (password.equals("password")){
			response.setContentType("application/json");
			
			String jsonObject = "{\"data\": {\"token\":\"user_token\"}}";
			PrintWriter out = response.getWriter();
			response.setStatus(HttpServletResponse.SC_OK);
			out.println(jsonObject);
			out.close();
		}
		else{
			response.setContentType("application/json");
			String jsonObject = "{\"errors\": {\"error\":\"Login failed\"}}";
			PrintWriter out = response.getWriter();
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			out.println(jsonObject);
			out.close();
		}
	}

}
