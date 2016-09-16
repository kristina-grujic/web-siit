package controller;

import model.Review;
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

    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		List<Review> objects = new ArrayList<Review>();

		Review a = new Review();
		a.setReviewText("text of review 1");
    a.setPremises("tin");
		objects.add(a);

    Review a1 = new Review();
    a1.setReviewText("text of review 2");
    a.setPremises("tin");
		objects.add(a1);

    Review a2 = new Review();
    a2.setReviewText("text of review 3");
    a.setPremises("tin2");
		objects.add(a2);

		getServletContext().setAttribute("reviews", objects);
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
		List<Premises> articles = (List<Premises>) getServletContext().getAttribute("objects");
		for(Premises article : articles){
			if (article.getName().toLowerCase().startsWith(query.toLowerCase())
				|| article.getAddress().toLowerCase().startsWith(query.toLowerCase())
				|| article.getTown().toLowerCase().startsWith(query.toLowerCase())){
				result.add(article);
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
