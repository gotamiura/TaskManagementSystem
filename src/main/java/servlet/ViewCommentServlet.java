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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		//String userId = request.getParameter("userId");
		ViewCommentDAO viewDao = new ViewCommentDAO();
		List<EnterCommentsBean> comments = null;
		try {
			comments = viewDao.showComments(taskId);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("Comments", comments);

		RequestDispatcher rd = request.getRequestDispatcher("EnterCommentsServlet");
		rd.forward(request, response);

	}

}
