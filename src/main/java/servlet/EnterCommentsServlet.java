package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.EnterCommentsDAO;
import model.entity.EnterCommentsBean;

/**
 * Servlet implementation class 
 */
@WebServlet("/EnterCommentsServlet")
public class EnterCommentsServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		
		// リクエストからタスクIDを取得
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		
		// EnterCommentsDAOをインスタンス化
		EnterCommentsDAO insertComments = new EnterCommentsDAO();
		
		//taskCommentsを初期化
		EnterCommentsBean comments = null;
		
		try {
			comments = insertComments.selectComments(taskId);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	// セッションを取得または新規作成
	HttpSession session = request.getSession();

	// タスク詳細をセッションにセット
	session.setAttribute("comments", comments);

	// 削除確認画面にリダイレクト
	response.sendRedirect("enter-comments.jsp");


}
}