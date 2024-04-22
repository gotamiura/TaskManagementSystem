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

import model.dao.taskDAO;
import model.entity.CategoryBean;
import model.entity.TaskBean;
import model.entity.UserBean;

/**
 * Servlet implementation class TaskRegisterServlet
 */
@WebServlet("/TaskRegisterServlet")
public class TaskRegisterServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		taskDAO dao = new taskDAO();
		List<CategoryBean> category = null;
		List<UserBean> users = null;
		try {
			category = dao.getCategory();
			users = dao.getUserName();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("TaskCategory", category);
		session.setAttribute("PersoninCharge", users);
		
		RequestDispatcher rd = request.getRequestDispatcher("task-register.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// DAOのインスタンス化
		taskDAO dao = new taskDAO();
		String taskName = request.getParameter("taskName");
		String userName = request.getParameter("personIncharge");
		String memo = request.getParameter("memo");
		// Beanのインスタンス化
		TaskBean taskBean = new TaskBean();
		taskBean.setTaskName(taskName);
		taskBean.setUserId(userName);
		taskBean.setMemo(memo);
		
		int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
		Date deadLine = Date.valueOf(request.getParameter("deadLine"));
		String statusCode = request.getParameter("statusCode");
		
		taskBean.setCategoryId(categoryCode);
		taskBean.setLimitDate(deadLine);
		taskBean.setStatusCode(statusCode);

		int count = 0;
		
		try {
			
			count = dao.insert(taskBean);// 登録処理
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("register-failure.jsp");// 登録失敗画面
			rd.forward(request, response);
		}
		
		if (count != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("register-success.jsp");// 登録成功画面
			rd.forward(request, response);
		}
		
	}
}