package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.entity.EnterCommentsBean;

public class ViewCommentDAO {

	public EnterCommentsBean selectComments(int taskId) throws SQLException, ClassNotFoundException {
		EnterCommentsBean enterComments = null;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"SELECT t1.task_id, t1.task_name, t3.user_id, t3.user_name, t2.comment FROM task_db.t_task t1 LEFT JOIN task_db.t_comment t2 ON t1.task_id = t2.task_id LEFT JOIN task_db.m_user t3 ON t1.user_id = t3.user_id WHERE t1.task_id = ?")) {
			pstmt.setInt(1, taskId);
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				enterComments = new EnterCommentsBean();
				enterComments.setTaskId(res.getInt("task_id"));
				enterComments.setTaskName(res.getString("task_Name"));
				enterComments.setUserId(res.getString("user_id"));
				enterComments.setUserName(res.getString("user_name"));
				enterComments.setComment(res.getString("comment"));
			}

		}

		return enterComments;
	}

	public List<EnterCommentsBean> showComments(int taskId) throws ClassNotFoundException, SQLException {

		List<EnterCommentsBean> commentList = new ArrayList<>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"SELECT c.comment_id, c.task_id, t.task_name, c.user_id, u.user_name, c.comment, c.update_datetime FROM t_comment c JOIN t_task t on c.task_id = t.task_id JOIN m_user u on c.user_id = u.user_id WHERE c.task_id = ? ORDER BY c.comment_id")) {

			pstmt.setInt(1, taskId);
			//pstmt.setString(2, userId);

			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				int commentId = res.getInt("comment_id");
				int taskId1 = res.getInt("task_id");
				String taskName = res.getString("task_name");
				String userId1 = res.getString("user_id");
				String userName = res.getString("user_name");
				String comment = res.getString("comment");
				Timestamp updateDate = res.getTimestamp("update_datetime");

				EnterCommentsBean commentBean = new EnterCommentsBean();
				commentBean.setCommentId(commentId);
				commentBean.setTaskId(taskId1);
				commentBean.setTaskName(taskName);
				commentBean.setUserId(userId1);
				commentBean.setUserName(userName);
				commentBean.setComment(comment);
				commentBean.setUpdateDatetime(updateDate);

				commentList.add(commentBean);
			}
		}
		return commentList;
	}

}
