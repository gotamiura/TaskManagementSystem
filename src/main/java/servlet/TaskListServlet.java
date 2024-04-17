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
 * TaskCategoryDAOを使った業務処理を行うクラスです。
 * @author goutamiura
 */
@WebServlet("/TaskListServlet")
public class TaskListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @param request,response この引数は使用しない
	 * @throws ServletException, IOException
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

}
