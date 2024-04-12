package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;
import model.entity.TaskBean;

public class taskDAO {
	public List<CategoryBean> getCategory() throws ClassNotFoundException, SQLException {
		
		List<CategoryBean> categoryList = new ArrayList<CategoryBean>();
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM m_category")) {
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				int category_id = res.getInt("category_id");
				String category_name = res.getString("category_name");
				
				CategoryBean categoryBean = new CategoryBean();	
				categoryBean.setCategory_id(category_id);
				categoryBean .setCategory_name(category_name);

				categoryList.add(categoryBean);
			}
		}
		return categoryList;
		
	}
	
	public int insert(TaskBean taskBean) throws ClassNotFoundException, SQLException {
		
		int count = 0;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO m_task(task_name,category_id, limit_date,user_id,memo) VALUES (?, ?, ?, ?, ?)")) {
			ResultSet res = pstmt.executeQuery();
				
				String task_name = res.getString("task_name");
				int category_id = res.getInt("category_id");
				Date limit_date = res.getDate("limit_date");
				String user_id = res.getString("user_id");
				//Reader status_code = res.getCharacterStream("status_code");
				String memo	= res.getString("memo");
				
				pstmt.setString(1, task_name);
				pstmt.setInt(2, category_id);
				pstmt.setDate(3, limit_date);
				pstmt.setString(4, user_id);
				//pstmt.setCharacterStream(5, status_code);
				pstmt.setString(5, memo);
				
				count = pstmt.executeUpdate();
		}
		
		return count;
		
	}
}
