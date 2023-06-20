package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommunityDao;
import model.Community;

/**
 * Servlet implementation class CommunityCreateConfirmServlet
 */
@WebServlet("/CommunityCreateConfirmServlet")
public class CommunityCreateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/community_confirm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("community_name");
		String sendLang = request.getParameter("sendLang");
		String[] language = sendLang.substring(1).split(",");
		String sendPurp = request.getParameter("sendPurp");
		String[] purpose = sendPurp.substring(1).split(",");
		String sendCert = request.getParameter("sendCert");
		String[] certification = sendCert.substring(1).split(",");
		String career = request.getParameter("career");
		String summary = request.getParameter("community_summary");

		Community community=new Community(name,language,purpose,career,certification,summary);
		CommunityDao cyDao=new CommunityDao();
		String communityId= cyDao.addCommunity(community);



		RequestDispatcher dispatcher = request.getRequestDispatcher("/product_D2/CommunityServlet");
		dispatcher.forward(request, response);



	}

}
