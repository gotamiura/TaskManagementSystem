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

import model.dao.TaskDetailDAO;
import model.dao.UpdateDAO;
import model.dao.taskDAO;
import model.entity.CategoryBean;
import model.entity.TMSBean;
import model.entity.TaskCategoryBean;
import model.entity.UserBean;

/**
 * Servlet implementation class TaskAlterServlet
 */
@WebServlet("/TaskAlterServlet")
public class TaskAlterServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TaskDetailDAO dao = new TaskDetailDAO();
		int taskId = Integer.parseInt(request.getParameter("task_id"));
		TaskCategoryBean task = null;
		taskDAO taskdao = new taskDAO();
		List<CategoryBean> category = null;
		List<UserBean> users = null;
		List<TMSBean> status = null;

		try {
			task = dao.selectTask(taskId);
			category = taskdao.getCategory();
			users = taskdao.getUserName();
			status = taskdao.setStatusName();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("TaskId", taskId);
		session.setAttribute("TaskDetail", task);
		session.setAttribute("AlterTaskCategory", category);
		session.setAttribute("AlterPersoninCharge", users);
		session.setAttribute("AlterStatus", status);

		RequestDispatcher rd = request.getRequestDispatcher("task-alter-form.jsp");
		rd.forward(request, response);
	}

	/**
	 * @param cName 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		// セッションオブジェクトの取得
		HttpSession session = request.getSession();
		// 使用するクラスのインスタンス化
		UpdateDAO updateDao = new UpdateDAO();

		TaskCategoryBean updateItem = new TaskCategoryBean();

		String categoryName = null;
		String userName = null;
		String statusName = null;
		int count = 0;
		updateItem.setTaskId((int) session.getAttribute("TaskId"));
		updateItem.setTaskName(request.getParameter("taskName"));
		updateItem.setCategoryId(Integer.parseInt(request.getParameter("categoryName")));
		updateItem.setLimitDate(Date.valueOf(request.getParameter("deadLine")));
		updateItem.setUserId(request.getParameter("userName"));
		updateItem.setStatusCode(request.getParameter("statusName"));
		updateItem.setMemo(request.getParameter("memo"));

		try {
			count = updateDao.updateTask(updateItem);
			categoryName = updateDao.getCategoryName(Integer.parseInt(request.getParameter("categoryName")));
			userName = updateDao.getUserName(request.getParameter("userName"));
			statusName = updateDao.getStatusName(request.getParameter("statusName"));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if (count == 0) {
			session.setAttribute("message", "次のデータを変更できませんでした。");
		} else {
			session.setAttribute("message", "次のデータを変更しました。");
		}
		session.setAttribute("TaskName", request.getParameter("taskName"));
		session.setAttribute("CategoryName", categoryName);
		session.setAttribute("LimitDate", Date.valueOf(request.getParameter("deadLine")));
		session.setAttribute("UserName", userName);
		session.setAttribute("StatusCode", statusName);
		session.setAttribute("memo", request.getParameter("memo"));

		RequestDispatcher rd = request.getRequestDispatcher("task-alter-result.jsp");
		rd.forward(request, response);

	}

}
