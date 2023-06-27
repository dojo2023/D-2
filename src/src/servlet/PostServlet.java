package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.User;
/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/post")
@MultipartConfig (location = "C:\\dojo6\\src\\WebContent\\upload",maxFileSize=700000) // アップロードファイルの一時的な保存先
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
		Part articleImg1 = null;
		Part articleImg2 = null;
		Part articleImg3 = null;
		String errorMessage = "";
		String articleImg1Path = "",articleImg2Path = "",articleImg3Path = "";


		//各値を取得
		String articleTitle = request.getParameter("article_title");
		String userId = ((User)session.getAttribute("user")).getUserId();
		String[] articleLanguage = request.getParameterValues("language");
		String[] articlePurpose = request.getParameterValues("purpose");
		String articleCareer = request.getParameter("career");
		String[] articleCertification = request.getParameterValues("certification");
		String articleText = request.getParameter("article_text");
		//確認用にコンソールに表示
		System.out.printf("articleTitle=%s\n",articleTitle);
		System.out.printf("UserId=%s\n",userId);
		System.out.printf("articleCareer=%s\n",articleCareer);
		System.out.printf("articleText=%s\n",articleText);
		for(int i=0; i<articleLanguage.length; i++) {
			System.out.printf("articleLanguage=%s\n",articleLanguage[i]);
		}
		for(int i=0; i<articlePurpose.length; i++) {
			System.out.printf("article_purpose=%s\n",articlePurpose[i]);
		}
		for(int i=0; i<articleCertification.length; i++) {
			System.out.printf("article_Certification=%s\n",articleCertification[i]);
		}


		//リクエストスコープに格納
		request.setAttribute("articleTitle",articleTitle);
		request.setAttribute("userId",userId);
		request.setAttribute("articleLanguage",articleLanguage);
		request.setAttribute("articlePurpose",articlePurpose);
		request.setAttribute("articleCareer",articleCareer);
		request.setAttribute("articleCertification",articleCertification);
		request.setAttribute("articleText",articleText);
		session.setAttribute("articleImg1",articleImg1);
		session.setAttribute("articleImg2",articleImg2);
		session.setAttribute("articleImg3",articleImg3);
		System.out.printf("%s",articleText);

		try {
			//name属性ごとにファイルをPartオブジェクトとして取得
			articleImg1 = request.getPart("img1");
			if(articleImg1.getSize()!=0) {
				String ImgName1 = "tempImg1";
				String extName = this.getFileName(articleImg1);
				int idx = extName.lastIndexOf(".");
				extName = extName.substring(idx);
				ImgName1 += extName;
				articleImg1.write(ImgName1);
				//System.out.printf("%s\n",ImgName1 );	//確認用
				articleImg1Path = "/D2sample/upload/"+ImgName1;
			}else if (articleImg1.getSize()==0) {
					articleImg1Path = "";
				}
		}
		catch(IllegalStateException e) {
			articleImg1Path = "";
			errorMessage = "ファイルのサイズが大きすぎるのでアップロードできませんでした。";
		}

		try {
			articleImg2 = request.getPart("img2");
			if(articleImg2.getSize()!=0) {
				String ImgName2 = "tempImg2";
				String extName = this.getFileName(articleImg2);
				int idx = extName.lastIndexOf(".");
				extName = extName.substring(idx);
				ImgName2 += extName;
				articleImg2.write(ImgName2);
				//System.out.printf("%s\n",ImgName1 );	//確認用
				articleImg2Path = "/D2sample/upload/"+ImgName2;
			} else if (articleImg2.getSize()==0) {
				articleImg2Path = "";
			}
		}
		catch(IllegalStateException e) {
			articleImg2Path = "";
			errorMessage = "ファイルのサイズが大きすぎるのでアップロードできませんでした。";
		}

		try {
			articleImg3 = request.getPart("img3");
			if(articleImg3.getSize()!=0) {
				String ImgName3 = "tempImg3";
				String extName = this.getFileName(articleImg3);
				int idx = extName.lastIndexOf(".");
				extName = extName.substring(idx);
				ImgName3 += extName;
				articleImg3.write(ImgName3);
				//System.out.printf("%s\n",ImgName1 );	//確認用
				articleImg3Path = "/D2sample/upload/"+ImgName3;
			}else if (articleImg3.getSize()==0) {
				articleImg3Path = "";
				}
		}
		catch(IllegalStateException e) {
			articleImg3Path = "";
			errorMessage = "ファイルのサイズが大きすぎるのでアップロードできませんでした。";
		}



		request.setAttribute("articleImg1Path",articleImg1Path);
		request.setAttribute("articleImg2Path",articleImg2Path);
		request.setAttribute("articleImg3Path",articleImg3Path);
		request.setAttribute("errorMessage", errorMessage);


		try {
			Thread.sleep(5000);
		}
		catch(InterruptedException e){
			Thread.currentThread().interrupt();
		}

		//確認ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/post_confirm.jsp");
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





