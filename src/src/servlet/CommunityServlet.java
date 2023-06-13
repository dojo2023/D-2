package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommunityDAO;
import model.Community;

/**
 * Servlet implementation class CommunityServlet
 */
@WebServlet("/CommunityServlet")
public class CommunityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/community.jsp");
		dispatcher.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String CommunityName = request.getParameter("communityname");
		//String CommunityLanguage = request.getParameter("CommunityLanguage");
		//String CommunityPurpose = request.getParameter("CommunityPurpose");
		//String CommunityCareer = request.getParameter("CommunityCareer");
		//String CommunityCertification = request.getParameter("CommunityCertification");
		//String CommunitySummary= request.getParameter("CommunitySummary");
		// 検索処理を行う
		CommunityDAO bDao = new CommunityDAO();
		List<Community> cardList = bDao.select(new Community(CommunityName,CommunityLanguage,CommunityPurpose,CommunityCareer,CommunityCertification,CommunitySummary));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/community_search.jsp");
		dispatcher.forward(request, response);
	}

}
