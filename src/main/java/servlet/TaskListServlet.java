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

import model.dao.TaskCategoryDAO;
import model.entity.TaskCategoryBean;

/**
 * Servlet implementation class ItemListServlet
 */
@WebServlet("/TaskListServlet")
public class TaskListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		List<TaskCategoryBean> taskList = null;
//		// DAOの生成
//		TaskCategoryDAO dao = new TaskCategoryDAO();
//
//		try {
//			// 商品マスタから商品情報を取得
//			taskList = dao.selectAll();
//		} catch (SQLException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		// リクエストスコープへの属性の設定
//		request.setAttribute("taskList", taskList);
//
//		// 商品一覧画面への転送
//		RequestDispatcher rd = request.getRequestDispatcher("task-list.jsp");
//		rd.forward(request, response);
//	}
//}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<TaskCategoryBean> taskList = null;
	    TaskCategoryDAO dao = new TaskCategoryDAO();

	    try {
	        taskList = dao.selectAll();
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    if (taskList != null) {
	        request.setAttribute("taskList", taskList);
	    }

	    RequestDispatcher rd = request.getRequestDispatcher("task-list.jsp");
	    rd.forward(request, response);
	}
}