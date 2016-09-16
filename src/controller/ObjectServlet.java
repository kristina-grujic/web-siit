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
		a.setName("Borsalino");
		a.setTin("tin");
		a.setAddress("Vojvodjanska 32");
		a.setTown("Novi Sad");
		objects.add(a);

		Premises a1 = new Premises();
		a1.setName("Pekara Evropa");
		a1.setTin("tin");
		a1.setAddress("Bulevar Oslobodjenja 11");
		a1.setTown("Novi Sad");
		objects.add(a1);

		Premises a2 = new Premises();
		a2.setName("555");
		a2.setTin("tin2");
		a2.setAddress("Trg Mladenaca");
		a2.setTown("Novi Sad");
		objects.add(a2);

		getServletContext().setAttribute("objects", objects);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String query = request.getParameter("query");
		PrintWriter out = response.getWriter();
		List<Premises> result = new ArrayList<Premises>();
		@SuppressWarnings("unchecked")
		List<Premises> objects = (List<Premises>) getServletContext().getAttribute("objects");
		for(Premises object : objects){
			if (object.getName().toLowerCase().startsWith(query.toLowerCase())
				|| object.getAddress().toLowerCase().startsWith(query.toLowerCase())
				|| object.getTown().toLowerCase().startsWith(query.toLowerCase())){
				result.add(object);
			}
		}
		out.write("{\"data\":" + result.toString() + "}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
