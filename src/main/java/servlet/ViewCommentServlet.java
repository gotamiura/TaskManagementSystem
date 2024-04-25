package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.ViewCommentDAO;
import model.entity.EnterCommentsBean;

/**
 * Servlet implementation class ViewCommentServlet
 */
@WebServlet("/ViewCommentServlet")
public class ViewCommentServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		// リクエストからタスクIDを取得
		int taskId = Integer.parseInt(request.getParameter("taskId"));


		ViewCommentDAO viewDao = new ViewCommentDAO();

		//taskCommentsを初期化
		EnterCommentsBean newComments = null;
		List<EnterCommentsBean> oldComments = null;
		try {
			oldComments = viewDao.showComments(taskId);
			newComments = viewDao.selectComments(taskId);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// セッションを取得または新規作成
		HttpSession session = request.getSession();
		session.setAttribute("OldComments", oldComments);
		session.setAttribute("NewComments", newComments);
		

		// 削除確認画面にリダイレクト
		RequestDispatcher rd = request.getRequestDispatcher("enter-comments.jsp");
		rd.forward(request, response);
	}

}
