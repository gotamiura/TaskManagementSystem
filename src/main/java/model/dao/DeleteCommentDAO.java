package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.EnterCommentsBean;

public class DeleteCommentDAO {

	public EnterCommentsBean selectComments(int commentId) throws SQLException, ClassNotFoundException {
		EnterCommentsBean deleteComments = null;

		try (
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"SELECT t1.task_id, t1.task_name, t3.user_id, t3.user_name, t2.comment_id, t2.comment, t2.update_datetime FROM task_db.t_task t1 INNER JOIN task_db.t_comment t2 ON t1.task_id = t2.task_id INNER JOIN task_db.m_user t3 ON t1.user_id = t3.user_id WHERE t2.comment_id = ?")) {
			pstmt.setInt(1, commentId);
			try (ResultSet res = pstmt.executeQuery()) {
				if (res.next()) {
					deleteComments = new EnterCommentsBean();
					deleteComments.setTaskId(res.getInt("task_id"));
					deleteComments.setTaskName(res.getString("task_Name"));
					deleteComments.setUserId(res.getString("user_id"));
					deleteComments.setUserName(res.getString("user_name"));
					deleteComments.setTaskId(res.getInt("comment_id"));
					deleteComments.setComment(res.getString("comment"));
					deleteComments.setUpdateDatetime(res.getTimestamp("update_datetime"));
				}
			}
		}

		return deleteComments;
	}
}
