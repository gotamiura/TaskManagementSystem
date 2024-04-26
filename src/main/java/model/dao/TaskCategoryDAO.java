package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskCategoryBean;

public class TaskCategoryDAO {

	public List<TaskCategoryBean> selectAll() throws SQLException, ClassNotFoundException {

		List<TaskCategoryBean> taskList = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("t1.task_id ");
        sb.append(",t1.task_name ");
        sb.append(",t2.category_name ");
        sb.append(",t1.limit_date ");
        sb.append(",t3.user_id ");
        sb.append(",t3.user_name ");
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
        sb.append("ORDER BY ");
        sb.append("task_id ");

        String sql = sb.toString();

        try (Connection con = ConnectionManager.getConnection();
             Statement stmt = con.createStatement();
             ResultSet res = stmt.executeQuery(sql)) {

			while (res.next()) {
				int taskId = res.getInt("task_id");
				String taskName = res.getString("task_name");
				String categoryName = res.getString("category_name");
				Date limitDate = res.getDate("limit_date");
				String userId = res.getString("user_id");
				String userName = res.getString("user_name");
				String statusName = res.getString("status_name");
				String memo = res.getString("memo");

				TaskCategoryBean task = new TaskCategoryBean();
				task.setTaskId(taskId);
				task.setTaskName(taskName);
				task.setCategoryName(categoryName);
				task.setLimitDate(limitDate); // Date型のままセット
				task.setUserId(userId);
				task.setUserName(userName);
				task.setStatusName(statusName);
				task.setMemo(memo);

				taskList.add(task);
			}

		}
		return taskList;
	}

}