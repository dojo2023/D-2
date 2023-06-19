package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ArticleDao;
import dao.CommunityDao;
import model.Article;
import model.Community;
import model.User;

/**
 * Servlet implementation class TopServlet
 */
@WebServlet("/top")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user;
		ArticleDao aDao = new ArticleDao();
		CommunityDao cDao = new CommunityDao();
		Article[] recommendArticle = null;
		Community[] recommendCommunity = null;
		Article[] writtenArticle = null;
		try {
			user = (User)session.getAttribute("user");
			recommendArticle = aDao.getRecommendArticle(user.getUserId());
			recommendCommunity = cDao.getRecommendCommunity(user.getUserId());
			writtenArticle = aDao.getWrittenArticle(user.getUserId());
		} catch (NullPointerException e) {
			user = new User("ゲスト");
			session.setAttribute("user", user);
			recommendArticle = aDao.getRecommendArticle();
			recommendCommunity = cDao.getRecommendCommunity();
		} finally {
			session.setAttribute("recArticle", recommendArticle);
			session.setAttribute("recCommunity", recommendCommunity);
			session.setAttribute("wriArticle", writtenArticle);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String query = request.getParameter("query");
		String target = request.getParameter("search");
		if (target.equals("記事検索")) {
			ArticleDao aDao = new ArticleDao();
			Article[] articleResults = aDao.searchArticle(query);
			session.setAttribute("articleResults", articleResults);
			response.sendRedirect("/WEB-INF/jsp/article_search.jsp");
		} else if (target.equals("コミュニティ検索")) {
			CommunityDao cDao = new CommunityDao();
			Community[] communityResults = cDao.searchCommunity(query);
			session.setAttribute("communityResults", communityResults);
			response.sendRedirect("/WEB-INF/jsp/community_search.jsp");
		}
	}

}
