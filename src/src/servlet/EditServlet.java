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
import model.Article;
import model.User;
/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	   // 編集対象の記事IDを取得
	      int articleId = Integer.parseInt(request.getParameter("article_id"));

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
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		//リクエストパラメータの文字コードを指定
	      request.setCharacterEncoding("UTF-8");
	      ArticleDao aDao=new ArticleDao();

	      if(request.getParameter("SUBMIT").equals("プレビューへ進む")) {


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
	      article.setUserId(user.getUserId());
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
	      else if(request.getParameter("SUBMIT").equals("記事を削除する")) {
	    	  int articleId=Integer.parseInt(request.getParameter("articleId"));
	    	  aDao.delete(articleId);

	    //topページにレスポンス
	    	  response.sendRedirect("/product_D2/top");

	      }


	}



}
