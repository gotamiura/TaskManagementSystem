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

		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(
						"SELECT t1.task_id, t1.task_name, t2.category_name, t1.limit_date, t3.user_id, t3.user_name, t4.status_name, t1.memo "
								+
								"FROM task_db.t_task t1 " +
								"LEFT JOIN task_db.m_category t2 ON t1.category_id = t2.category_id " +
								"LEFT JOIN task_db.m_user t3 ON t1.user_id = t3.user_id " +
								"LEFT JOIN task_db.m_status t4 ON t1.status_code = t4.status_code " +
								"ORDER BY user_name,task_id")) {
			
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