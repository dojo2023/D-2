package servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.ArticleDao;
import model.Article;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
@MultipartConfig
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
		String img1Path="", img2Path="", img3Path="";

		//仮に記事を作成
				Article tentative = new Article();
				String tentativeLang[] = new String[16];
				String tentativePurp[] = new String[11];
				String tentativeCert[] = new String[14];
				Arrays.fill(tentativeLang,"");
				Arrays.fill(tentativePurp, "");
				Arrays.fill(tentativeCert,"");

				tentative.setArticleLanguage(tentativeLang);
				tentative.setArticlePurpose(tentativePurp);
				tentative.setArticleCertification(tentativeCert);

				ArticleDao aDao = new ArticleDao();
				aDao.insert(tentative);


		//各値を取得
				String articleTitle = request.getParameter("title");
				String userId = (String)session.getAttribute("user");
				String[] articleLanguage = request.getParameterValues("language");
				String[] articlePurpose = request.getParameterValues("purpose");
				String articleCareer = request.getParameter("career");
				String[] articleCertification = request.getParameterValues("certification");
				String articleText = request.getParameter("text");
				//name属性ごとにファイルをPartオブジェクトとして取得
				Part articleImg1 = request.getPart("img1");
				Part articleImg2 = request.getPart("img2");
				Part articleImg3 = request.getPart("img3");

		//リクエストスコープに格納
		request.setAttribute("articleTitle",articleTitle);
		request.setAttribute("userId",userId);
		request.setAttribute("articleLanguage",articleLanguage);
		request.setAttribute("articlePurpose",articlePurpose);
		request.setAttribute("articleCareer",articleCareer);
		request.setAttribute("articleCertification",articleCertification);
		request.setAttribute("articleText",articleText);
		request.setAttribute("articleImg1",articleImg1);
		request.setAttribute("articleImg2",articleImg2);
		request.setAttribute("articleImg3",articleImg3);


		//確認ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/PostResult.jsp");
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

	// ファイル名を取得するメソッド
    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] elements = contentDisposition.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }




}


