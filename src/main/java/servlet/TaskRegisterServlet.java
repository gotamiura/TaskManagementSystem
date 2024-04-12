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
		try {
			List<CategoryBean> category = dao.getCategory();
			HttpSession session = request.getSession();
			session.setAttribute("TaskCategory", category);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("task-register.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		taskDAO dao = new taskDAO();
		String taskName = request.getParameter("taskName");
		String userName = request.getParameter("userName");
		String memo = request.getParameter("memo");
		
		TaskBean taskBean = new TaskBean();
		taskBean.setTask_name(taskName);
		taskBean.setUser_id(userName);
		taskBean.setMemo(memo);
		
		try {
			
			int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
			Date deadLine = Date.valueOf(request.getParameter("deadLine"));
			//char[] statusCode =request.getParameter("statusCode");
			
			taskBean.setCategory_id(categoryCode);
			taskBean.setLimit_date(deadLine);
			//taskBean.setStatus_code(statusCode);

			int count = dao.insert(taskBean);
			if (count != 0) {
				RequestDispatcher rd = request.getRequestDispatcher("register-success.jsp");
				rd.forward(request, response);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("register-failure.jsp");
			rd.forward(request, response);
		}
		
	}

}
