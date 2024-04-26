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

import model.dao.InsertCommentsDAO;
import model.entity.EnterCommentsBean;

/**
 * Servlet implementation class CommentsResultServlet
 */
@WebServlet("/CommentsResultServlet")
public class CommentsResultServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		EnterCommentsBean comments = (EnterCommentsBean) session.getAttribute("NewComments");		
		int taskId = comments.getTaskId();
		String commentUserId = (String)session.getAttribute("UserId");
		String comment = request.getParameter("comments");
		// InsertCommentsDAOをインスタンス化
		InsertCommentsDAO insertComments = new InsertCommentsDAO();

		try {
			// 登録処理
			insertComments.insertComments(taskId, commentUserId, comment);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("ViewCommentServlet");
		rd.forward(request, response);
	}
}
