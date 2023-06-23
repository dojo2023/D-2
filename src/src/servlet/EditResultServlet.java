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
@WebServlet("/edit_result")
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
	      String userId=request.getParameter("userId");
	      String articleCreate=request.getParameter("articleCreate");
	      String articleUpdate=request.getParameter("articleUpdate");

	      String sendLang=request.getParameter("sendLang");
	      String[] articleLanguage=sendLang.substring(1).split(",");
	      String sendPurp=request.getParameter("sendPurp");
	      String[] articlePurpose=sendPurp.substring(1).split(",");
	      String sendCert=request.getParameter("sendCert");
	      String[] articleCertification=sendCert.substring(1).split(",");
	      String articleCareer=request.getParameter("career");
	      int articleFavs=Integer.parseInt(request.getParameter("articleFavs"));
	      String articleText=request.getParameter("text");
	      String articleImg1=request.getParameter("img1");
	      String articleImg2=request.getParameter("img2");
	      String articleImg3=request.getParameter("img3");

	   // リクエスト属性に編集対象の記事をセット
	      Article article = new Article(articleId,articleTitle,userId,articleCreate,articleUpdate,
	    		  articleLanguage,articlePurpose,articleCareer,articleCertification,articleFavs,
	    		  articleText,articleImg1,articleImg2,articleImg3);

       //DAOを作ってDAOのメソッドを使って更新
	      ArticleDao aDao=new ArticleDao();
	      aDao.update(article);

	    //編集完了通知ページにフォワードする
request.setAttribute("article_data",article);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_result.jsp");
			dispatcher.forward(request, response);
	}

}
