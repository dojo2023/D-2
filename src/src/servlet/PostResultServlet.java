package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.ArticleDao;
import model.Article;
import model.User;

/**
 * Servlet implementation class PostResultServlet
 */
@WebServlet("/post_result")
public class PostResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		ArticleDao aDao = new ArticleDao();
		String errormessage = "";
		int articleId = 0;	//空の記事のidを入れる。updateでも代入されたものを使用


		//各値を取得
		String articleTitle = request.getParameter("article_title");
		String userId = ((User)session.getAttribute("user")).getUserId();
		System.out.println("ユーザーID"+userId);
		String sendLang = request.getParameter("sendLang");
		System.out.println("sendLang;"+sendLang);
		String[] articleLanguage=sendLang.substring(1).split(",");
		String sendPurp=request.getParameter("sendPurp");
	    String[] articlePurpose=sendPurp.substring(1).split(",");
	    String sendCert=request.getParameter("sendCert");
	    String[] articleCertification=sendCert.substring(1).split(",");
		String articleCareer = request.getParameter("article_career");
		String articleText = request.getParameter("article_text");
		String article_img1 = request.getParameter("article_img1");
		String article_img2 = request.getParameter("article_img2");
		String article_img3 = request.getParameter("article_img3");
		System.out.println(articleTitle);

		System.out.println(sendPurp);
		System.out.println(sendCert);

		//空の記事の作成
		articleId = aDao.insertGetId();	//空の記事idがarticle_idに入った。
		//このarticle_idを使ってarticleImg*Pathを書き換える。

		//画像1のパスの書き換え。
		if(article_img1 !="") {
			String OldName = article_img1.substring(article_img1.lastIndexOf("/")+1);		//古い画像の名前だけを取り出した
			File fOld =new File("C:\\dojo6\\src\\WebContent\\upload\\"+OldName);	//古い画像のパス（書き換えできる形）を登録
			int idx = article_img1.lastIndexOf(".");
			String extName =article_img1.substring(idx);	//extNameに拡張子が入っている 例）.png
			String NewName ="article"+articleId+"img1"+extName;		//新しいファイル名を設定（後でファイルの名前を変える際に使用）
			article_img1 = "/product_D2/upload/article"+articleId+"img1"+extName;	//新しいPathがarticle_img1に上書きされた

			//uploadフォルダの画像の名前の書き換え
			File fNew =new File("C:\\dojo6\\src\\WebContent\\upload\\"+NewName);

			if(fOld.exists()) {
				fOld.renameTo(fNew);
				System.out.println("ファイル名を変更しました。");
			} else {
				System.out.println("ファイルが存在しません。");
				article_img1 ="";
			}
		}

		//画像2のパスの書き換え。
		if(article_img2 !="") {
			String OldName = article_img2.substring(article_img2.lastIndexOf("/")+1);		//古い画像の名前だけを取り出した
			File fOld =new File("C:\\dojo6\\src\\WebContent\\upload\\"+OldName);	//古い画像のパス（書き換えできる形）を登録
			int idx = article_img2.lastIndexOf(".");
			String extName =article_img2.substring(idx);	//extNameに拡張子が入っている 例）.png
			String NewName ="article"+articleId+"img2"+extName;		//新しいファイル名を設定（後でファイルの名前を変える際に使用）
			article_img2 = "/product_D2/upload/article"+articleId+"img2"+extName;	//新しいPathがarticle_img1に上書きされた

			//uploadフォルダの画像の名前の書き換え
			File fNew =new File("C:\\dojo6\\src\\WebContent\\upload\\"+NewName);

			if(fOld.exists()) {
				fOld.renameTo(fNew);
				System.out.println("ファイル名を変更しました。");
			} else {
				System.out.println("ファイルが存在しません。");
				article_img2 ="";
			}
		}

		//画像3のパスの書き換え。
		if(article_img3 !="") {
			String OldName = article_img3.substring(article_img3.lastIndexOf("/")+1);		//古い画像の名前だけを取り出した
			File fOld =new File("C:\\dojo6\\src\\WebContent\\upload\\"+OldName);	//古い画像のパス（書き換えできる形）を登録
			int idx = article_img3.lastIndexOf(".");
			String extName =article_img3.substring(idx);	//extNameに拡張子が入っている 例）.png
			String NewName ="article"+articleId+"img3"+extName;		//新しいファイル名を設定（後でファイルの名前を変える際に使用）
			article_img3 = "/product_D2/upload/article"+articleId+"img3"+extName;	//新しいPathがarticle_img1に上書きされた

			//uploadフォルダの画像の名前の書き換え
			File fNew =new File("C:\\dojo6\\src\\WebContent\\upload\\"+NewName);

			if(fOld.exists()) {
				fOld.renameTo(fNew);
				System.out.println("ファイル名を変更しました。");
			} else {
				System.out.println("ファイルが存在しません。");
				article_img3 ="";
			}
		}

		//登録する記事の内容をArticle型の変数に代入
		Article article = new Article(articleId, articleTitle, userId,"","",
				articleLanguage, articlePurpose, articleCareer, articleCertification,
				0,articleText,article_img1, article_img2, article_img3);

		//空の記事に中身を登録
		if(aDao.update(article)) {
			errormessage ="none";
		} else {
			errormessage = "sql error";
		}
		System.out.println("errormessage:"+errormessage);

		//通知ページにarticle_idを渡すため変数articleをリクエストスコープに保存
		request.setAttribute("article", article);
		request.setAttribute("errormessage", errormessage);

		//確認ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/post_result.jsp");//本当は("/WEB-INF/jsp/post_result.jsp")
		dispatcher.forward(request, response);
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
