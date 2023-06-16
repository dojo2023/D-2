package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommunityDAO;
import model.Remark;

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


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/community_xxxx.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		//Int remarkId = request.getParameter("REMARKID");
		//Int communityId  = request.getParameter("COMMUNITYID");
		//String userId  = request.getParameter("USERID");
		String remarkText = request.getParameter("REMARKTEXT");
		//String remarkDate  = request.getParameter("REMARKDATE");

		CommunityDAO bDao = new CommunityDAO();
		 //bDao.insert(new Remark(remarkId,communityId,userId,remarkText,remarkDate));
		bDao.insert(new Remark(remarkText));
		// メニューページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/community.jsp");
				dispatcher.forward(request, response);
		}


}
