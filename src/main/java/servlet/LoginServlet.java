package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = null;
		// DAOの生成
		UserDAO userDao = new UserDAO();
		// セッションオブジェクトを生成
		HttpSession session = request.getSession();
		// 入力されたユーザIDとパスワードを取得する
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		try {
			//ユーザは入力されたユーザIDとパスワードを確認する
			if (userDao.validate(userId, password)) {
				url = "menu.jsp";//メニュー画面
				//ユーザは入力されたユーザIDとパスワードからユーザ名を取得する
				String userName = userDao.userName(userId, password);
				// セッションスコープへの属性の設定
				session.setAttribute("UserName", userName);
			} else {
				url = "login-failure.jsp";//ログイン失敗画面
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
