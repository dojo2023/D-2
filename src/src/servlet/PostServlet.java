package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Article;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインサーブレットにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/post.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータを取得する。（Article型の変数に格納）
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		Article article_data = new Article(
				0,
				request.getParameter("title"),
				(String)session.getAttribute("user"),
				"",
				"",
				request.getParameterValues("language"),
				request.getParameterValues("purpose"),
				request.getParameter("career"),
				request.getParameterValues("certification"),
				0,
				request.getParameter("text"),
				"",
				"",
				""
				);

		//リクエストスコープに格納
		request.setAttribute("article_data",article_data);

		//確認ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/PostConfirmServlet.java");
		dispatcher.forward(request, response);


		/* 以下登録機能はPostConfirmServlet.javaにて行う
		登録処理を行う
		ArticleDao aDao = new ArticleDao();
		if(aDao.insert(new Article(articleId, articleTitle, userId, articleCreate,
				 articleUpdate, articleLanguage, articlePurpose, articleCareer, articleCertification,
				 articleFavs, articleText, articleImg1, articleImg2, articleImg3) )) {
		String message = "登録しました！";
		request.setAttribute("message", message);
		}
		else {
			String message = "登録に失敗しました";
			request.setAttribute("message", message);
		}
		//結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/PostResult.jsp");
		dispatcher.forward(request, response);
		*/

	}
}
