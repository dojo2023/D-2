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
	  ArticleDao aDao=new ArticleDao();
      Article article = aDao.load(articleId);
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
	      ArticleDao aDao=new ArticleDao();

	      if(request.getParameter("SUBMIT").equals("プレビュー")) {


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

	      request.setAttribute("article", article);


        //編集確認ページにフォワードする

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_confirm.jsp");
		dispatcher.forward(request, response);
	      }
	      else if(request.getParameter("SUBMIT").equals("削除")) {
	    	  int articleId=Integer.parseInt(request.getParameter("articleId"));
	    	  aDao.delete(articleId);

	    //topページにレスポンス
	    	  response.sendRedirect("/product_D2/top");

	      }


	}



}
