package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.TaskCategoryBean;

public class UpdateDAO {
	/**
	 * タスクテーブルのタスクを更新します。
	 * @param updateItem
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int updateTask(TaskCategoryBean updateItem) throws ClassNotFoundException, SQLException {
		int processingNumber = 0; //処理件数

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE t_task ");
        sb.append("SET ");
        sb.append("task_name = ? ");
        sb.append(",category_id = ? ");
        sb.append(",limit_date = ? ");
        sb.append(",user_id = ? ");
        sb.append(",status_code = ? ");
        sb.append(",memo = ? ");
        sb.append("WHERE ");
        sb.append("task_id = ? ");

        String sql = sb.toString();

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
			// プレースホルダへの値の設定
			pstmt.setString(1, updateItem.getTaskName());
			pstmt.setInt(2, updateItem.getCategoryId());
			pstmt.setDate(3, updateItem.getLimitDate());
			pstmt.setString(4, updateItem.getUserId());
			pstmt.setString(5, updateItem.getStatusCode());
			pstmt.setString(6, updateItem.getMemo());
			pstmt.setInt(7, updateItem.getTaskId());
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;

	}

	/**
	 * カテゴリ ID を使用してカテゴリ名を取得します。
	 * @param category_id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public String getCategoryName(int category_id) throws ClassNotFoundException, SQLException {
		String categoryName = null;
		String sql = "SELECT category_name FROM m_category WHERE category_id = ?";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, category_id);
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				categoryName = res.getString("category_name");

			}
		}
		return categoryName;

	}

	/**
	 * ユーザID を使用してユーザ名を取得します。
	 * @param user_id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public String getUserName(String user_id) throws ClassNotFoundException, SQLException {
		String userName = null;
		String sql = "SELECT user_name FROM m_user WHERE user_id = ?";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, user_id);
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				userName = res.getString("user_name");
			}
		}
		return userName;
	}

	/**
	 * ステータスコードを使用してステータス名を取得します。
	 * @param status_code
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public String getStatusName(String status_code) throws ClassNotFoundException, SQLException {
		String statusName = null;
		String sql = "SELECT status_name FROM m_status WHERE status_code = ?";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, status_code);
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				statusName = res.getString("status_name");
			}
		}
		return statusName;
	}

}
