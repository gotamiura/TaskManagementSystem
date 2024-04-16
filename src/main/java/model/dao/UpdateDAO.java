package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.TaskCategoryBean;

public class UpdateDAO {
    public int updateTask(TaskCategoryBean taskResult) throws ClassNotFoundException, SQLException {
    	int processingNumber = 0; //処理件数
  
		String sql = "UPDATE t_task SET task_name = ?, category_id = ?, limit_date = ?, user_id =?, status_code=?, memo =? WHERE task_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setString(1, taskResult.getTaskName());
			pstmt.setString(2, taskResult.getCategoryName());
			pstmt.setDate(3, taskResult.getLimitDate());
			pstmt.setString(4, taskResult.getUserId());
			pstmt.setString(5,taskResult.getStatusCode());
			pstmt.setString(6, taskResult.getMemo());
			pstmt.setInt(7, taskResult.getTaskId());
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
    	
    }

}
