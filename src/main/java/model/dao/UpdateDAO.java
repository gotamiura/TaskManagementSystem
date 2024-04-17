package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.TaskCategoryBean;

public class UpdateDAO {
    public int updateTask(TaskCategoryBean updateItem) throws ClassNotFoundException, SQLException {
    	int processingNumber = 0; //処理件数
  
		String sql = "UPDATE t_task SET task_name = ?, category_id = ?, limit_date = ?, user_id =?, status_code=?, memo =? WHERE task_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setString(1, updateItem.getTaskName());
			pstmt.setInt(2, updateItem.getCategoryId());
			pstmt.setDate(3, updateItem.getLimitDate());
			pstmt.setString(4, updateItem.getUserId());
			pstmt.setString(5,updateItem.getStatusCode());
			pstmt.setString(6, updateItem.getMemo());
			pstmt.setInt(7, updateItem.getTaskId());
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
    	
    }
    public int getCategoryId(String cName) throws ClassNotFoundException, SQLException {
    	int categoryId = 0;
    	String sql = "SELECT category_id FROM m_category WHERE category_name = cName";
    	try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
    		ResultSet res = pstmt.executeQuery();
    		categoryId = res.getInt("category_id");
    	}
		return categoryId;
    	
    }
	public String getUserId(String uName) throws ClassNotFoundException, SQLException {
		String userId = null;
		String sql = "SELECT user_id FROM m_user WHERE user_name = uName";
    	try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
    		ResultSet res = pstmt.executeQuery();
    		userId = res.getString("user_id");
    	}
		return userId;
	}
	public String getStatusCode(String sName) throws ClassNotFoundException, SQLException {
		String statusCode = null;
		String sql = "SELECT status_code FROM m_status WHERE status_name = sName";
    	try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
    		ResultSet res = pstmt.executeQuery();
    		statusCode = res.getString("status_code");
    	}
		return statusCode;
	}
	
}
