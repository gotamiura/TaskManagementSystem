package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.TaskCategoryBean;

public class UpdateDAO {
    public int updateTask(TaskCategoryBean updateItem) throws ClassNotFoundException, SQLException {
    	int processingNumber = 0; //処理件数
  
		String sql = "UPDATE t_task SET task_name = ?, category_id = ?, limit_date = ?, user_id = ?,status_code = ?,memo = ? WHERE task_id = ?";
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
    public String getCategoryName(int category_id) throws ClassNotFoundException, SQLException {
    	String categoryName = null;
    	String sql = "SELECT category_name FROM m_category WHERE category_id = ?";
    	try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
    		pstmt.setInt(1, category_id); 
    		ResultSet res = pstmt.executeQuery();
    		if(res.next()) {
    			categoryName = res.getString("category_name");
    			
    		}
    	}
    	return categoryName;
		
    	
    }
	public String getUserName(int user_id) throws ClassNotFoundException, SQLException {
		String userName = null;
		String sql = "SELECT user_name FROM m_user WHERE user_id = ?";
    	try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
    		pstmt.setInt(1, user_id); 
    		ResultSet res = pstmt.executeQuery();
    		if(res.next()) {
    			userName = res.getString("user_name");
    		}
    	}
		return userName;
	}
	public String getStatusName(String status_code) throws ClassNotFoundException, SQLException {
		String statusName = null;
		String sql = "SELECT status_name FROM m_status WHERE status_code = ?";
    	try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
    		pstmt.setString(1, status_code); 
    		ResultSet res = pstmt.executeQuery();
    		if(res.next()) {
    			statusName = res.getString("status_name");
    		}
    	}
		return statusName;
	}
	
	
}
