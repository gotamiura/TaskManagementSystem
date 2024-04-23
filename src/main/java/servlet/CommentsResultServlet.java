package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EnterCommentsDAO;
import model.dao.InsertCommentsDAO;
import model.entity.EnterCommentsBean;

/**
 * Servlet implementation class CommentsResultServlet
 */
@WebServlet("/CommentsResultServlet")
public class CommentsResultServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		
		// リクエストからタスクIDを取得
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		
		// InsertCommentsDAOをインスタンス化
		InsertCommentsDAO insertComments = new InsertCommentsDAO();
		
		// EnterCommentsDAOをインスタンス化
		EnterCommentsDAO enterComments = new EnterCommentsDAO();
		
		int processingNumber = 0; //処理件数
		
		//taskCommentsを初期化
		EnterCommentsBean Comments = null;
		
		try {

			// 登録処理
			processingNumber = insertComments.selectComments(taskId);

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
		
	}

}
