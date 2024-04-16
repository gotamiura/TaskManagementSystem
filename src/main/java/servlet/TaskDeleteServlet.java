package servlet;

import java.io.IOException;
import java.sql.SQLException;

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
@WebServlet("/TaskDeleteServlet")
public class TaskDeleteServlet extends HttpServlet {

	/**
	 * @param HttpServletRequest request, HttpServletResponse response この引数は使用しない
	 * @throws ServletException, IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストからタスクIDを取得
		int taskId = Integer.parseInt(request.getParameter("taskId"));

		// TaskCategoryDAOをインスタンス化
		TaskCategoryDAO dao = new TaskCategoryDAO();

		try {
			// タスクIDを元にタスク詳細を取得
			TaskCategoryBean taskDetail = dao.selectTask(taskId);

			// セッションを取得または新規作成
			HttpSession session = request.getSession();

			// タスク詳細をセッションにセット
			session.setAttribute("taskDetail", taskDetail);

			// 削除確認画面にリダイレクト
			response.sendRedirect("task-delete-confirm.jsp");

		} catch (SQLException | ClassNotFoundException e) {
			// エラーハンドリング
			e.printStackTrace();
		}

	}
}
