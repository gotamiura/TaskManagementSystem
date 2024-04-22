package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskDetailDAO;
import model.entity.TaskCategoryBean;

/**
 * TaskDetailDAOを使った業務処理を行うクラスです。
 * @author goutamiura
 */
@WebServlet("/TaskDeleteServlet")
public class TaskDeleteServlet extends HttpServlet {

	/**
	 * @param request,response この引数は使用しない
	 * @throws ServletException, IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストからタスクIDを取得
		int taskId = Integer.parseInt(request.getParameter("taskId"));

		// TaskCategoryDAOをインスタンス化
		TaskDetailDAO dao = new TaskDetailDAO();
		
		//taskDetailを初期化
		TaskCategoryBean taskDetail = null;

		try {
			// タスクIDを元にタスク詳細を取得
			taskDetail = dao.selectTask(taskId);

		} catch (SQLException | ClassNotFoundException e) {
			// エラーハンドリング
			e.printStackTrace();
		}
		
		// セッションを取得または新規作成
		HttpSession session = request.getSession();

		// タスク詳細をセッションにセット
		session.setAttribute("taskDetail", taskDetail);

		// 削除確認画面にリダイレクト
		response.sendRedirect("task-delete-confirm.jsp");


	}
}
