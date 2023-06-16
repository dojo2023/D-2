package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditConfirmServlet
 */
@WebServlet("/EditConfirmServlet")
public class EditConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

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
	      String articleLink=request.getParameter("link");

	    //編集完了通知ページにフォワードする

	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_result.jsp");
			dispatcher.forward(request, response);
	}

}
