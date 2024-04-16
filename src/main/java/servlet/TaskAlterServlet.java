package servlet;

import java.io.IOException;
import java.sql.Date;
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
import model.dao.taskDAO;
import model.entity.TMSBean;
import model.entity.TaskCategoryBean;

/**
 * Servlet implementation class TaskAlterServlet
 */
@WebServlet("/TaskAlterServlet")
public class TaskAlterServlet extends HttpServlet {
	
	private static final String task_id = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		taskDAO dao = new taskDAO();
		TMSBean bean = new TMSBean();
		try {
			int taskId =Integer.parseInt(request.getParameter("task_id"));
			List<TMSBean> task = dao.getTask(taskId);
			HttpSession session = request.getSession();
			session.setAttribute("TaskDetail", task);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("task-alter-form.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		// セッションオブジェクトの取得
		HttpSession session = request.getSession();
		// 使用するクラスのインスタンス化
		TaskCategoryDAO dao = new TaskCategoryDAO();
		TaskCategoryBean updateItem = new TaskCategoryBean();
		
		updateItem.setStatusName(request.getParameter("taskName"));
		updateItem.setCategoryName(request.getParameter("categoryCode"));
		updateItem.setLimitDate(Date.valueOf(request.getParameter("deadLine")));
		updateItem.setUserName(request.getParameter("personIncharge"));
		updateItem.setStatusName(request.getParameter("statusCode"));
		updateItem.setMemo(request.getParameter("memo"));
		String url ="";
	
		int count = 0;
		try {
			count = dao.updateTask(updateItem);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		if(count != 0) {
			url = "update-success.jsp";
		}
		else {
			url = "update-failure.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
			
	}

}
