package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.EnterCommentsBean;

public class DeleteCommentDAO {

	/**
	 * このメソッドはコメントの削除確認画面に表示されるデータを返します。
	 * @param commentId
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public EnterCommentsBean selectComments(int commentId) throws SQLException, ClassNotFoundException {
		EnterCommentsBean deleteComments = null;

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append("t1.task_id ");
		sb.append(",t1.task_name ");
		sb.append(",t3.user_id ");
		sb.append(",t3.user_name ");
		sb.append(",t2.comment_id ");
		sb.append(",t2.comment ");
		sb.append(",t2.update_datetime ");
		sb.append("FROM ");
		sb.append("task_db.t_task t1 ");
		sb.append("INNER JOIN task_db.t_comment t2 ");
		sb.append("ON t1.task_id = t2.task_id ");
		sb.append("INNER JOIN task_db.m_user t3 ");
		sb.append("ON t1.user_id = t3.user_id ");
		sb.append("WHERE ");
		sb.append("t2.comment_id = ? ");

		String sql = sb.toString();
		// データベース接続の取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, commentId);// プレースホルダへの値の設定
			try (ResultSet res = pstmt.executeQuery()) {
				if (res.next()) {
					// 結果の取得
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
