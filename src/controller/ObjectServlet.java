package controller;

import model.Premises;
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
    
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		List<Premises> objects = new ArrayList<Premises>();

		Premises a = new Premises();
		a.setName("objekat 1");
		a.setAddress("adresa 1");
		objects.add(a);

		Premises a1 = new Premises();
		a1.setName("objekat 2");
		a1.setAddress("adresa 2");
		objects.add(a1);
		
		getServletContext().setAttribute("objects", objects);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		@SuppressWarnings("unchecked")
		List<Premises> articles = (List<Premises>) getServletContext()
				.getAttribute("objects");
		out.write("{\"data\":" + articles.toString() + "}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
