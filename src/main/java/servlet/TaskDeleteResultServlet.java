package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DeleteDAO;
import model.dao.TaskDetailDAO;
import model.entity.TaskCategoryBean;

/**
 * TaskCategoryDAOを使った業務処理を行うクラスです。
 * @author goutamiura
 */
@WebServlet("/TaskDeleteResultServlet")
public class TaskDeleteResultServlet extends HttpServlet {
	/**
	 * @param HttpServletRequest request, HttpServletResponse response この引数は使用しない
	 * @throws ServletException, IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		DeleteDAO deletedao = new DeleteDAO();
		TaskDetailDAO detaildao = new TaskDetailDAO();
		int processingNumber = 0; //処理件数
		TaskCategoryBean taskDetail = null; // taskDetail の初期化

		try {
			// 削除処理
			int taskId = Integer.parseInt(request.getParameter("taskId"));
			processingNumber = deletedao.deleteTask(taskId);

			// 削除処理が成功した場合、削除されたタスクの詳細情報を取得
			if (processingNumber > 0) {
				taskDetail = detaildao.selectTask(taskId);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// taskDetail をリクエストスコープに設定
		request.setAttribute("taskDetail", taskDetail);
		// 処理件数をリクエストスコープに設定
		request.setAttribute("processingNumber", processingNumber);

		// 削除結果画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher("task-delete-result.jsp");
		rd.forward(request, response);
	}
}