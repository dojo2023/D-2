package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommunityDao;
import model.Community;
import model.Remark;

/**
 * Servlet implementation class CommunityServlet
 */
@WebServlet("/CommunityServlet")
public class CommunityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//メッセージ表示
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		int communityId=Integer.parseInt(request.getParameter("community_id"));
		CommunityDao cDao=new CommunityDao();

		Community community_data=cDao.getCommunityById(communityId);
		ArrayList<Remark> chat_data=cDao.getRemarks(communityId);

		request.setAttribute("chat_data", chat_data);
		request.setAttribute("community_data", community_data);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/community_xxxx.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	//メッセージ送信
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");

		String community_id=request.getParameter("community_id");
		String user_id=request.getParameter("user_id");
		String remark_text=request.getParameter("remark_text");

		request.setAttribute("community_id",community_id);
		request.setAttribute("user_id",user_id);
		request.setAttribute("remark",remark_text);

		CommunityDao cDao = new CommunityDao();
		Remark remark＝new Remark(community_id,user_id,remark_text);

		cDao.insert(remark);
		// メニューページにフォワードする
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/community.jsp");
		//dispatcher.forward(request, response);
		}


}
