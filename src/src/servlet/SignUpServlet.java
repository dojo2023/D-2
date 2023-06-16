package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/sign_up")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/sign_up.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");
		String userName = request.getParameter("username");
		String[] language = request.getParameterValues("language");
		String[] purpose = request.getParameterValues("purpose");
		String career = request.getParameter("career");
		String[] certification = request.getParameterValues("certification");
		UserDao uDao = new UserDao();
		if (!uDao.isExistingId(userId)) {
			User user = new User(userId, password, userName, language,
				purpose, career, certification);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/sign_up_confirm.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("isExistingId", "t");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/sign_up.jsp");
			dispatcher.forward(request, response);
		}
	}

}
