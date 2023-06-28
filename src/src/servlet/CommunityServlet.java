package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommunityDao;
import dao.UserDao;
import model.Community;
import model.Remark;
import model.User;

/**
 * Servlet implementation class CommunityServlet
 */
@WebServlet("/community")
public class CommunityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	//メッセージ表示
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		int communityId;
		String communityIdStr = (String)session.getAttribute("community_id_ss");
		if (communityIdStr != null) {
			communityId = Integer.parseInt(communityIdStr);
			session.removeAttribute("community_id_ss");
		} else {
			communityId=Integer.parseInt(request.getParameter("communityId"));
		}
		CommunityDao cDao=new CommunityDao();

		Community community_data=cDao.getCommunityById(communityId);
		//コミュニティ名、コミュニティタグ

		ArrayList<Remark> chat_data=cDao.getRemarks(communityId);
		//ユーザー名、日付時間、テキスト内容

		ArrayList<String> member_data=cDao.getMember(communityId);
		//ユーザー名
        ArrayList<String> speaker_data=new ArrayList<String>();

        UserDao uDao=new UserDao();
        for(Remark r:chat_data) {
        	speaker_data.add(uDao.getUserNameById(r.getUserId()));
        }
		request.setAttribute("chat_data", chat_data);
		request.setAttribute("community_data", community_data);
		request.setAttribute("member_data",member_data);
		request.setAttribute("speaker_data",speaker_data);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/community_xxxx.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	//メッセージ送信
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        HttpSession session=request.getSession();
		request.setCharacterEncoding("UTF-8");
        String communityIdStr=request.getParameter("community_id");
		int community_id=Integer.parseInt(communityIdStr);
		User user=(User)session.getAttribute("user");
		String user_id=user.getUserId();
		String remark_text=request.getParameter("remark_text");



		CommunityDao cDao = new CommunityDao();
		Remark remark=new Remark(0,community_id,user_id,remark_text,"");

		cDao.insert(remark);
		//コミュニティページにフォワードする
		Community community_data=cDao.getCommunityById(community_id);
		ArrayList<Remark> chat_data=cDao.getRemarks(community_id);
		ArrayList<String> member_data=cDao.getMember(community_id);
        ArrayList<String> speaker_data=new ArrayList<String>();
        UserDao uDao=new UserDao();
        for(Remark r:chat_data) {
        	speaker_data.add(uDao.getUserNameById(r.getUserId()));
        }
		request.setAttribute("chat_data", chat_data);
		request.setAttribute("community_data", community_data);
		request.setAttribute("member_data",member_data);
		request.setAttribute("speaker_data",speaker_data);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/community_xxxx.jsp");
		dispatcher.forward(request, response);
		}


}
