package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommunityCreateServlet
 */
@WebServlet("/CommunityCreateServlet")
public class CommunityCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/community_create.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("community_name");
		String[] language = request.getParameterValues("language");
		String[] purpose = request.getParameterValues("purpose");
		String[] certification = request.getParameterValues("certification");
		String career = request.getParameter("career");
		String summary = request.getParameter("community_summary");

		//CommunityDao cDao=new CommunityDao();
		//List<community> cardList=cDao.select();

		String[] tag=new String [language.length+purpose.length+certification.length];

		request.setAttribute("name",name);
		request.setAttribute("tag",tag);
		request.setAttribute("career",career);
		request.setAttribute("summary",summary);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/community_confirm.jsp");
		dispatcher.forward(request, response);

	}

}
