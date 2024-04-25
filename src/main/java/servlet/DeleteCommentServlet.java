package servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.EnterCommentsBean;

/**
 * Servlet implementation class DeleteCommentServlet
 */
@WebServlet("/DeleteCommentServlet")
public class DeleteCommentServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストからタスクIDを取得
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		String userId = request.getParameter("userId");
		int commentId = Integer.parseInt(request.getParameter("commentId"));
		String updateDateTime = request.getParameter("updateDateTime");
		
		//confirmCommentsを初期化
		EnterCommentsBean confirmComments = new EnterCommentsBean();

		confirmComments.setTaskId(taskId);
		confirmComments.setUserId(userId);
		confirmComments.setCommentId(commentId);
		confirmComments.setUpdateDatetime(Timestamp.valueOf(updateDateTime));

		HttpSession session = request.getSession();

		// タスク詳細をセッションにセット
		session.setAttribute("confirmComments", confirmComments);

		// 削除確認画面にリダイレクト
		request.getRequestDispatcher("comment-delete-confirm.jsp").forward(request, response);


	}
}

