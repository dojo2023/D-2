package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

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
		ArrayList<Article> recommendArticle = new ArrayList<Article>();
		ArrayList<Community> recommendCommunity = new ArrayList<Community>();
		ArrayList<Article> writtenArticle = new ArrayList<Article>();
		if (Objects.nonNull(session.getAttribute("user"))) {
			user = (User)session.getAttribute("user");
			recommendArticle = aDao.getRecommendArticle(user);
			recommendCommunity = cDao.getRecommendCommunity(user);
			writtenArticle = aDao.getmyArticle(user.getUserId());
		} else {
			user = new User("ゲスト");
			session.setAttribute("user", user);
			recommendArticle = aDao.getRecommendArticle();
			recommendCommunity = cDao.getRecommendCommunity();
		}
		for (Community com: recommendCommunity) {
			System.out.print(com.getCommunityName());
		}
		session.setAttribute("recArticle", recommendArticle);
		session.setAttribute("recCommunity", recommendCommunity);
		session.setAttribute("wriArticle", writtenArticle);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
		dispatcher.forward(request, response);
	}
}
