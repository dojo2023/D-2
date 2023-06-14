package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class SignUpResultServlet
 */
@WebServlet("/sign_up_result")
public class SignUpResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		String sendLang = request.getParameter("sendLang");
		String[] language = sendLang.substring(1).split(",");
		String sendPurp = request.getParameter("sendPurp");
		String[] purpose = sendPurp.substring(1).split(",");
		String career = request.getParameter("career");
		String sendCert = request.getParameter("sendCert");
		String[] certification = sendCert.substring(1).split(",");
		User user = new User(userId, password, userName, language,
				purpose, career, certification);
		UserDao uDao = new UserDao();
		uDao.addUser(user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/sign_up_result.jsp");
		dispatcher.forward(request, response);
	}

}
