package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDao;
import model.Article;
/**
 * Servlet implementation class EditConfirmServlet
 */
@WebServlet("/EditResultServlet")
public class EditResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの文字コードを指定
	      request.setCharacterEncoding("UTF-8");

		//リクエストパラメータの取得
	      int articleId=Integer.parseInt(request.getParameter("articleId"));
	      String articleTitle=request.getParameter("title");
	      String[] articleLanguage=request.getParameterValues("language");
	      String[] articlePurpose=request.getParameterValues("purpose");
	      String[] articleCertification=request.getParameterValues("certification");
	      String articleCareer=request.getParameter("career");
	      String articleText=request.getParameter("text");
	      String articleImg1=request.getParameter("img1");
	      String articleImg2=request.getParameter("img2");
	      String articleImg3=request.getParameter("img3");

	   // リクエスト属性に編集対象の記事をセット
	      Article article = new Article();
	      article.setArticleId(articleId);
	      article.setArticleTitle(articleTitle);
	      article.setArticleLanguage(articleLanguage);
	      article.setArticlePurpose(articlePurpose);
	      article.setArticleCertification(articleCertification);
	      article.setArticleCareer(articleCareer);
	      article.setArticleText(articleText);
	      article.setArticleImg1(articleImg1);
	      article.setArticleImg2(articleImg2);
	      article.setArticleImg3(articleImg3);

       //DAOを作ってDAOのメソッドを使って更新
	      ArticleDao aDao=new ArticleDao();
	      aDao.update(article);

	    //編集完了通知ページにフォワードする

	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_result.jsp");
			dispatcher.forward(request, response);
	}

}
