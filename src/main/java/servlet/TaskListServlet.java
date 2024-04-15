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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<TaskCategoryBean> taskList = null;
		TaskCategoryDAO dao = new TaskCategoryDAO();

		try {
			taskList = dao.selectAll();// 商品マスタから商品情報を取得
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// リクエストスコープへの属性の設定
		HttpSession session = request.getSession();
		session.setAttribute("taskList", taskList);

		// 商品一覧画面への転送
		RequestDispatcher rd = request.getRequestDispatcher("task-list.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    // リクエストのエンコーディング方式を指定
	    request.setCharacterEncoding("UTF-8");

	    // 選択されたタスクのIDを取得
	    int taskId = Integer.parseInt(request.getParameter("task_id"));

	    TaskCategoryDAO dao = new TaskCategoryDAO();
	    TaskCategoryBean taskDetail = null;

	    try {
	        // 選択されたタスクの詳細情報を取得
	        taskDetail = dao.selectTask(taskId);
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    // 取得した詳細情報をセッションに保存
	    HttpSession session = request.getSession();
	    session.setAttribute("taskDetail", taskDetail);

	    // リダイレクトまたはフォワード先の指定
	    response.sendRedirect("task-list.jsp"); 

	}

}
