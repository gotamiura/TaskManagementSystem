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

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("t1.task_id ");
        sb.append(",t1.task_name ");
        sb.append(",t1.category_id ");
        sb.append(",t2.category_name ");
        sb.append(",t1.limit_date ");
        sb.append(",t1.user_id ");
        sb.append(",t3.user_name ");
        sb.append(",t1.status_code ");
        sb.append(",t4.status_name ");
        sb.append(",t1.memo ");
        sb.append("FROM ");
        sb.append("task_db.t_task t1 ");
        sb.append("LEFT JOIN task_db.m_category t2 ");
        sb.append("ON t1.category_id = t2.category_id ");
        sb.append("LEFT JOIN task_db.m_user t3 ");
        sb.append("ON t1.user_id = t3.user_id ");
        sb.append("LEFT JOIN task_db.m_status t4 ");
        sb.append("ON t1.status_code = t4.status_code ");
        sb.append("WHERE ");
        sb.append("t1.task_id = ? ");

        String sql = sb.toString();

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, taskId);
            try (ResultSet res = pstmt.executeQuery()) {
                if (res.next()) {
                    taskDetail = new TaskCategoryBean();
                    taskDetail.setTaskId(res.getInt("task_id"));
                    taskDetail.setTaskName(res.getString("task_name"));
                    taskDetail.setCategoryId(res.getInt("category_id"));
                    taskDetail.setCategoryName(res.getString("category_name"));
                    taskDetail.setLimitDate(res.getDate("limit_date"));
                    taskDetail.setUserId(res.getString("user_id"));
                    taskDetail.setUserName(res.getString("user_name"));
                    taskDetail.setStatusCode(res.getString("status_code"));
                    taskDetail.setStatusName(res.getString("status_name"));
                    taskDetail.setMemo(res.getString("memo"));
                }
            }
        }

        return taskDetail;
    }
}
