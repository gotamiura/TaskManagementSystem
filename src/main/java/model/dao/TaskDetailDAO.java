package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.TaskCategoryBean;

/**
 * t-taskテーブルにm_userテーブル、m_categoryテーブル、m_statusテーブルを内部結合したDAOです。
 * @author goutamiura
 */
public class TaskDetailDAO {

	/**
	 * 指定したタスクIDのレコード１つを返します。
	 * @param taskId タスクID
	 * @return 指定した内容のレコード１つ
	 * @throws SQLException, ClassNotFoundException
	 */
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
}
