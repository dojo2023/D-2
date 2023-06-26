package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDao;
import dao.CommunityDao;
import model.Article;
import model.Community;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String query = request.getParameter("query");
		String target = request.getParameter("search");
		if (target.equals("記事検索")) {
			ArticleDao aDao = new ArticleDao();
			ArrayList<Article> articleResults = aDao.select(query);
			request.setAttribute("articleResults", articleResults);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/article_search.jsp");
			dispatcher.forward(request, response);
		} else if (target.equals("コミュニティ検索")) {
			CommunityDao cDao = new CommunityDao();
			ArrayList<Community> communityResults = cDao.select(query);
			request.setAttribute("communityResults", communityResults);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/community_search.jsp");
			dispatcher.forward(request, response);
		}
	}

}
