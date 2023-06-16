package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDAO;
import model.Article;
/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	   // 編集対象の記事IDを取得
	      int articleId = Integer.parseInt(request.getParameter("articleId"));

      //DAOのメソッドを呼び出して編集対象の記事を取得
	  ArticleDAO articleDAO=new ArticleDAO();
      Article article = articleDAO.getArticleById(articleId);
      request.setAttribute("article", article);

		// 編集ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		//リクエストパラメータの文字コードを指定
	      request.setCharacterEncoding("UTF-8");

	      if(request.getParameter("SUBMIT").equals("プレビュー")) {


		//リクエストパラメータの取得
	      int articleId=Integer.parseInt(request.getParameter("articleId"));
	      String articleTitle=request.getParameter("title");
	      String[] articleLanguage=request.getParameterValues("language");
	      String[] articlePurpose=request.getParameterValues("purpose");
	      String[] articleCertification=request.getParameterValues("certification");
	      String articleCareer=request.getParameter("career");
	      String articleText=request.getParameter("text");

	   // リクエスト属性に編集対象の記事をセット
	      Article article = new Article();
	      article.setId(articleId);
	      article.setTitle(articleTitle);
	      article.setLanguage(articleLanguage);
	      article.setPurpose(articlePurpose);
	      article.setCertification(articleCertification);
	      article.setCareer(articleCareer);
	      article.setText(articleText);

	      request.setAttribute("article", article);


        //編集確認ページにフォワードする

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_confirm.jsp");
		dispatcher.forward(request, response);
	      }
	      else if(request.getParameter("SUBMIT").equals("削除")) {
	    	  int articleId=Integer.parseInt(request.getParameter("articleId"));
	    	  if (articleDao.delete(articleId)) {	// 削除成功
					request.setAttribute("result",
					new Result("削除成功！", "記事を削除しました。"));
				}
				else {						// 削除失敗
					request.setAttribute("result",
					new Result("削除失敗！", "記事を削除できませんでした。"));
				}

	      }

	      //記事削除完了ページにフォワードする
	      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_result.jsp");
			dispatcher.forward(request, response);

	}



}
