package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Role;
import model.User;

public class RegistrationServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3176904265163123085L;

	public RegistrationServlet(){
		super();
	}
	
	public String checkParams(String username, String email, String passwrd, String confirm, ArrayList<User> users){
		for (int i = 0; i < users.size(); i++){
			if (users.get(i).getUsername().equals(username)){
				return "Username already in use!";
			}
		}
		for (int i = 0; i < users.size(); i++){
			
			if (users.get(i).getEmail().equals(email)){
				return "Email already in use!";
			}
		}
		if (!(email.contains(" ")== false && email.matches(".+@.+\\.[a-z]+"))) return "Invalid e-mail address!";
		if (!passwrd.equals(confirm)) return "Passwords don't match!";
		
		return "";
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String mail = request.getParameter("mail");
		String passwd = request.getParameter("passwd");
		String cpasswd = request.getParameter("cpasswd");
		ArrayList<User> users = (ArrayList<User>) getServletContext().getAttribute("users");
		String result = checkParams(user,mail, passwd, cpasswd, users);
		if (result.equals("")){
			{
				String name = request.getParameter("name");
				String surname = request.getParameter("surname");
				String phone = request.getParameter("phone");
				String role = request.getParameter("role");
				User reg = new User();
				reg.setEmail(mail); reg.setName(name); reg.setSurname(surname);
				reg.setUsername(user); reg.setTelephone(phone); reg.setPassword(passwd);
				if (role.equals("user"))reg.setRole(Role.REVIEWER); else reg.setRole(Role.MANAGER);
				users.add(reg);
				getServletContext().setAttribute("users", users);
				request.setAttribute("registered", "success");
				
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
		else{
			request.setAttribute("success", result);
			getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
