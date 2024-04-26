package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * t-taskテーブルのDAOです。
 * @author goutamiura
 */
public class DeleteDAO {

	/**
	 * 指定されたタスクIDのレコード１つを削除します。
	 * @param taskId タスクID
	 * @return 処理したレコード件数
	 * @throws SQLException, ClassNotFoundException
	 */
	public int deleteTask(int taskId) {

		String sql1 = "DELETE FROM t_comment WHERE task_id = ?";
		String sql2 = "DELETE FROM t_task WHERE task_id = ?";
		int processingNumber = 0; //処理件数
		try (Connection con = ConnectionManager.getConnection();) {

			try (PreparedStatement pstmt1 = con.prepareStatement(sql1);
					PreparedStatement pstmt2 = con.prepareStatement(sql2);) {
				con.setAutoCommit(false);
				// プレースホルダへの値の設定
				pstmt1.setInt(1, taskId);
				pstmt2.setInt(1, taskId);
				processingNumber += pstmt1.executeUpdate();//コメント削除処理
				processingNumber += pstmt2.executeUpdate();//タスク削除処理
				con.commit();
			} catch (SQLException e) {
				con.rollback();
				processingNumber = 0;
				e.printStackTrace();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return processingNumber;
	}
}
