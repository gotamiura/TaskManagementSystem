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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskDetailDAO dao = new TaskDetailDAO();
		try {
			int taskId =Integer.parseInt(request.getParameter("task_id"));
			TaskCategoryBean task = dao.selectTask(taskId);
			HttpSession session = request.getSession();
			session.setAttribute("TaskId", taskId);
			session.setAttribute("TaskDetail", task);
			
			taskDAO taskdao = new taskDAO();
			List<CategoryBean> category = taskdao.getCategory();
			List<UserBean> users = taskdao.getUserName();
			List<TMSBean> status = taskdao.setStatusName();
			session.setAttribute("TaskCategory", category);
			session.setAttribute("PersoninCharge", users);
			session.setAttribute("Status", status);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("task-alter-form.jsp");
		rd.forward(request, response);
	}

	/**
	 * @param cName 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		// セッションオブジェクトの取得
		HttpSession session = request.getSession();
		// 使用するクラスのインスタンス化
		UpdateDAO updateDao = new UpdateDAO();
		
		TaskCategoryBean updateItem = new TaskCategoryBean();
	
		try {
			String categoryName = updateDao.getCategoryName(Integer.parseInt(request.getParameter("categoryName")));
			String userName = updateDao.getUserName(Integer.parseInt(request.getParameter("userName")));
			String statusName = updateDao.getStatusName(Integer.parseInt(request.getParameter("statusName")));
		
			updateItem.setTaskId((int)session.getAttribute("TaskId"));
			updateItem.setTaskName(request.getParameter("taskName"));
			updateItem.setCategoryId(Integer.parseInt( request.getParameter("categoryName")));
			updateItem.setLimitDate(Date.valueOf(request.getParameter("deadLine")));
			updateItem.setUserId(request.getParameter("userName"));
			updateItem.setStatusCode(request.getParameter("statusName"));
			updateItem.setMemo(request.getParameter("memo"));
			
			int count = updateDao.updateTask(updateItem);
			if(count == 0){
				session.setAttribute("message", "次のデータを変更できませんでした。");
			}
			else {
				session.setAttribute("message", "次のデータを変更しました。");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("TaskName", request.getParameter("taskName"));
		session.setAttribute("CategoryName",categoryName);
		session.setAttribute("LimitDate", Date.valueOf(request.getParameter("deadLine")));
		session.setAttribute("UserName", userName);
		session.setAttribute("StatusCode", statusName);
		session.setAttribute("memo", request.getParameter("memo"));
		
		RequestDispatcher rd = request.getRequestDispatcher("task-alter-result.jsp");
		rd.forward(request, response);
			
	}

}
