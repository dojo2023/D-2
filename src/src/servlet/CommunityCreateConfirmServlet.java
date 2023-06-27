package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommunityDao;
import model.Community;

/**
 * Servlet implementation class CommunityCreateConfirmServlet
 */
@WebServlet("/community_create_confirm")
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

		HttpSession session=request.getSession();
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("community_name");
		String sendLang = request.getParameter("sendLang");
		String[] language= {};
		if(sendLang.length()!=0) {
			language = sendLang.substring(1).split(",");
		}
		String sendPurp = request.getParameter("sendPurp");
		String[] purpose= {};
		if(sendPurp.length()!=0) {
			purpose = sendPurp.substring(1).split(",");
		}
		String sendCert = request.getParameter("sendCert");
		String[]certification= {};
		if(sendCert.length()!=0) {
			certification = sendCert.substring(1).split(",");
		}
		String career = request.getParameter("career");
		String summary = request.getParameter("community_summary");

		Community community=new Community(0,"",name,language,purpose,career,certification,summary);
		CommunityDao cyDao=new CommunityDao();
		int communityId =cyDao.addCommunity(community);
		String communityIdStr = String.valueOf(communityId);
		session.setAttribute("community_id_ss", communityIdStr);
		response.sendRedirect("/product_D2/community");






	}

}
