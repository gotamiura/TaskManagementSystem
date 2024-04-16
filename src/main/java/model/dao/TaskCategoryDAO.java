package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskCategoryBean;

/**
 * t-taskテーブルにm_userテーブル、m_categoryテーブル、m_statusテーブルを内部結合したDAOです。
 * @author goutamiura
 */
public class TaskCategoryDAO {

	/**
	 * タスク一覧のリストを返します。
	 * @return タスク一覧のリスト
	 * @throws SQLException, ClassNotFoundException
	 */
	public List<TaskCategoryBean> selectAll()
			throws SQLException, ClassNotFoundException {

		List<TaskCategoryBean> taskList = new ArrayList<TaskCategoryBean>();

		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(
						"SELECT t1.task_name , t2.category_name , t1.limit_date , t3.user_name , t4.status_name , t1.memo FROM task_db.t_task t1 LEFT JOIN task_db.m_category t2 ON t1.category_id = t2.category_id LEFT JOIN task_db.m_user t3 ON t1.user_id = t3.user_id  LEFT JOIN task_db.m_status t4 ON t1.status_code = t4.status_code ORDER BY user_name")) {

			// 結果の操作
			while (res.next()) {
				String taskName = res.getString("task_name");
				String categoryName = res.getString("category_name");
				Date date = res.getDate("limit_date");
				LocalDate limitDate = date.toLocalDate();
				String userId = res.getString("user_name");
				String statusName = res.getString("status_name");
				String memo = res.getString("memo");

				TaskCategoryBean task = new TaskCategoryBean();
				task.setTaskName(taskName);
				task.setCategoryName(categoryName);
				task.setLimitDate(Date.valueOf(limitDate));
				task.setUserName(userId);
				task.setStatusName(statusName);
				task.setMemo(memo);

				taskList.add(task);

			}
		}
		return taskList;
	}

	    public TaskCategoryBean selectTask(int taskId) throws SQLException, ClassNotFoundException {
	        TaskCategoryBean taskDetail = null;

	        try (Connection con = ConnectionManager.getConnection();
	             PreparedStatement pstmt = con.prepareStatement(
	                     "SELECT t1.task_id, t1.task_name, t2.category_name, t1.limit_date, t3.user_name, t4.status_name, t1.memo " +
	                     "FROM task_db.t_task t1 " +
	                     "LEFT JOIN task_db.m_category t2 ON t1.category_id = t2.category_id " +
	                     "LEFT JOIN task_db.m_user t3 ON t1.user_id = t3.user_id " +
	                     "LEFT JOIN task_db.m_status t4 ON t1.status_code = t4.status_code " +
	                     "WHERE t1.task_id = ?")) {
	            pstmt.setInt(1, taskId);
	            try (ResultSet res = pstmt.executeQuery()) {
	                if (res.next()) {
	                    taskDetail = new TaskCategoryBean();
	                    taskDetail.setTaskId(res.getInt("task_id"));
	                    taskDetail.setTaskName(res.getString("task_name"));
	                    taskDetail.setCategoryName(res.getString("category_name"));
	                    taskDetail.setLimitDate(res.getDate("limit_date"));
	                    taskDetail.setUserName(res.getString("user_name"));
	                    taskDetail.setStatusName(res.getString("status_name"));
	                    taskDetail.setMemo(res.getString("memo"));
	                }
	            }
	        }

	        return taskDetail;
	    }

	public int deleteTask(int taskId) throws SQLException, ClassNotFoundException {

		String sql = "DELETE FROM t_task WHERE task_id = ?";
		int processingNumber = 0; //処理件数
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setInt(1, taskId);
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
            
    public int updateTask(TaskCategoryBean taskResult) throws ClassNotFoundException, SQLException {
    	int processingNumber = 0; //処理件数

		String sql = "UPDATE t_task SET task_name = ?, category_id = ?, limit_date = ?, user_id =?, status_code=?, memo =? WHERE task_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setString(1, taskResult.getTaskName());
			pstmt.setString(2, taskResult.getCategoryName());
			pstmt.setDate(3, taskResult.getLimitDate());
			pstmt.setString(4, taskResult.getUserId());
			pstmt.setString(5,taskResult.getStatusCode());
			pstmt.setString(6, taskResult.getMemo());
			pstmt.setString(7, "1");
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
    	
    }

}
