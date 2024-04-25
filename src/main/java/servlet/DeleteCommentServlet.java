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
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		
		// リクエストからタスクIDを取得
		String taskName = request.getParameter("taskName");
		String userName = request.getParameter("userName");
		String comment = request.getParameter("comment");
		String updateDateTime = request.getParameter("updateDateTime");
		int taskID = Integer.parseInt(request.getParameter("taskID"));
		int commentID = Integer.parseInt(request.getParameter("commentID"));
		
		
		//confirmCommentsを初期化
		EnterCommentsBean confirmComments = new EnterCommentsBean();

		confirmComments.setTaskName(taskName);
		confirmComments.setUserName(userName);
		confirmComments.setComment(comment);
		confirmComments.setUpdateDatetime(Timestamp.valueOf(updateDateTime));
		confirmComments.setTaskId(taskID);
		confirmComments.setCommentId(commentID);

		HttpSession session = request.getSession();

		// タスク詳細をセッションにセット
		session.setAttribute("confirmComments", confirmComments);

		// 削除確認画面にリダイレクト
		request.getRequestDispatcher("comment-delete-confirm.jsp").forward(request, response);


	}
}

