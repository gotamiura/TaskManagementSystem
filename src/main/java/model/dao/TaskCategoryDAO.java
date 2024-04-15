package model.dao;

import java.sql.Connection;
import java.sql.Date;
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
                ResultSet res = stmt.executeQuery("SELECT t1.task_name , t2.category_name , t1.limit_date , t3.user_name , t4.status_name , t1.memo FROM task_db.t_task t1 LEFT JOIN task_db.m_category t2 ON t1.category_id = t2.category_id LEFT JOIN task_db.m_user t3 ON t1.user_id = t3.user_id  LEFT JOIN task_db.m_status t4 ON t1.status_code = t4.status_code ORDER BY user_name")) {

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
                task.setLimitDate(limitDate);
                task.setUserName(userId);
                task.setStatusName(statusName);
                task.setMemo(memo);

                taskList.add(task);

            }
        }
        return taskList;
    }
    
    public int updateTask(TaskCategoryBean taskResult) {
    	
    }
    public int deleteTask(TaskCategoryBean taskResult) {
    	
    }
    
    
    

}
