package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentDeleteDAO {
	public int deleteTask(int commentId) throws SQLException, ClassNotFoundException {

		String sql = "DELETE FROM t_comment WHERE comment_id = ?";
		int processingNumber = 0; //処理件数
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setInt(1, commentId);
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
}
