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

	public List<EnterCommentsBean> showComments(int taskId) throws ClassNotFoundException, SQLException {

		List<EnterCommentsBean> commentList = new ArrayList<>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"SELECT c.comment_id, c.task_id, t.task_name, c.user_id, u.user_name, c.comment, c.update_datetime FROM t_comment c left join t_task t on c.task_id = t.task_id left join m_user u on c.user_id = u.user_id WHERE c.task_id = ?")) {

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
