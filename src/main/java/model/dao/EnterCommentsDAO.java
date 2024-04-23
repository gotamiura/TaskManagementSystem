package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.EnterCommentsBean;

public class EnterCommentsDAO {
	
	public EnterCommentsBean selectComments(int taskId) throws SQLException, ClassNotFoundException {
	EnterCommentsBean enterComments = null;

	try(
	Connection con = ConnectionManager.getConnection();
	PreparedStatement pstmt = con.prepareStatement(
			"SELECT t1.task_id, t1.task_name, t3.user_id, t3.user_name, t2.comment FROM task_db.t_task t1 LEFT JOIN task_db.t_comment t2 ON t1.task_id = t2.task_id LEFT JOIN task_db.m_user t3 ON t1.user_id = t3.user_id WHERE t1.task_id = ?"))
	{
        pstmt.setInt(1, taskId);
        try (ResultSet res = pstmt.executeQuery()) {
            if (res.next()) {
            	enterComments = new EnterCommentsBean();
            	enterComments.setTaskId(res.getInt("task_id"));
            	enterComments.setTaskName(res.getString("task_Name"));
                enterComments.setUserId(res.getString("user_id"));
                enterComments.setUserName(res.getString("user_name"));
            	enterComments.setComment(res.getString("comment"));
            }
        }
	}
	
	return enterComments;
}
}
