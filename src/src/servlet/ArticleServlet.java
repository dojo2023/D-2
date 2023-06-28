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

import dao.ArticleDao;
import dao.UserDao;
import model.Article;
import model.Comment;
import model.User;

/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet("/article")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		int articleId = Integer.parseInt(request.getParameter("article_id"));
		ArticleDao aDao = new ArticleDao();
		UserDao uDao = new UserDao();
		Article article = aDao.load(articleId);
		ArrayList<Comment> commentData = aDao.getComment(articleId);
		request.setAttribute("comment", commentData);
		request.setAttribute("article", article);
		String writerName = uDao.getUserNameById(article.getUserId());
		request.setAttribute("writerName",writerName);
		//コメントのユーザーIdとユーザー名を一致させるcommenterを準備
		ArrayList<String> commenter = new ArrayList<String>();

		for(Comment c: commentData) {
			commenter.add(uDao.getUserNameById(c.getUserId()));
		}
		request.setAttribute("commenter",commenter);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/article.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		ArticleDao aDao = new ArticleDao();
		UserDao uDao = new UserDao();
		//いいねとコメントの処理
		String target = request.getParameter("form");
		if(target.equals("favs")) {
			int articleId = Integer.parseInt(request.getParameter("articleId"));
			aDao.addFavs(articleId);
		}else if(target.equals("コメント")){
			int articleId = Integer.parseInt(request.getParameter("articleId"));
			String comment = request.getParameter("comment");
			String userId = ((User)session.getAttribute("user")).getUserId();
			aDao.setComment(articleId, userId, comment);
			ArrayList<Comment> commentData = aDao.getComment(articleId);
			request.setAttribute("comment", commentData);
			//記事データの再取得
			Article article = aDao.load(articleId);
			request.setAttribute("article", article);
			//制作者のユーザー名の再取得
			String writerName = uDao.getUserNameById(userId);
			request.setAttribute("writerName",writerName);
			//コメントのユーザーIdとユーザー名を一致させるcommenterを準備
			ArrayList<String> commenter = new ArrayList<String>();

			for(Comment c: commentData) {
				commenter.add(uDao.getUserNameById(c.getUserId()));
			}
			request.setAttribute("commenter",commenter);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/article.jsp");
			dispatcher.forward(request, response);
		}


	}

}
