package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskDetailDAO;
import model.entity.TaskCategoryBean;

/**
 * Servlet implementation class TaskDeleteConfirmationServlet
 */
@WebServlet("/TaskDeleteConfirmationServlet")
public class TaskDeleteConfirmationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 選択されたタスクのIDを取得
        int taskId = Integer.parseInt(request.getParameter("task_id"));

        // タスクのIDを使って詳細情報を取得
        TaskDetailDAO dao = new TaskDetailDAO();
        TaskCategoryBean taskDetail = null;
        try {
            taskDetail = dao.selectTask(taskId); // データベースから詳細情報を取得
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // セッションに詳細情報を保存
        HttpSession session = request.getSession();
        session.setAttribute("taskDetail", taskDetail);

        // リクエストスコープにも保存
        request.setAttribute("taskDetail", taskDetail);

        // 確認画面にフォワード
        RequestDispatcher rd = request.getRequestDispatcher("task-delete-confirm.jsp");
        rd.forward(request, response);
    }
}
