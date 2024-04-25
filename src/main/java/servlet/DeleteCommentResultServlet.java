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

import model.dao.CommentDeleteDAO;
import model.dao.DeleteCommentDAO;
import model.entity.EnterCommentsBean;

/**
 * Servlet implementation class CommentDeleteResultServlet
 */
@WebServlet("/DeleteCommentResultServlet")
public class DeleteCommentResultServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		CommentDeleteDAO deletedao = new CommentDeleteDAO();
		DeleteCommentDAO deleteComments = new DeleteCommentDAO();
		int processingNumber = 0; //処理件数
		EnterCommentsBean DeleteComment = null;
		HttpSession session = request.getSession();
		//taskIdの取得
		int commentId = (int)session.getAttribute("commentId");
		
		try {

			// 削除処理
			processingNumber = deletedao.deleteTask(commentId);

			// 削除処理が成功した場合、削除されたタスクの詳細情報を取得
			if (processingNumber > 0) {
				DeleteComment = deleteComments.selectComments(commentId);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// taskDetail をリクエストスコープに設定
		request.setAttribute("DeleteComment", DeleteComment);
		// 処理件数をリクエストスコープに設定
		request.setAttribute("processingNumber", processingNumber);
		
		// 削除結果画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher("comment-delete-result.jsp");
		rd.forward(request, response);
	}
}