package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;
import model.entity.TaskBean;
import model.entity.UserBean;
public class taskDAO {
	
	/**
	 * このメソッドは、m_category テーブルからカテゴリ名を取得します。
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
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
	
	/**
	 * このメソッドは、t_task テーブルにデータを挿入するためのメソッドです。
	 * @param taskBean
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int insert(TaskBean taskBean) throws ClassNotFoundException, SQLException {
		
		int count = 0;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO t_task(task_name,category_id, limit_date,user_id,status_code,memo) VALUES (?, ?, ?, ?, ?,?)")) {
				
				pstmt.setString(1,taskBean.getTask_name());
				pstmt.setInt(2,taskBean.getCategory_id());
				pstmt.setDate(3,taskBean.getLimit_date());
				pstmt.setString(4,taskBean.getUser_id());
				pstmt.setString(5, taskBean.getStatus_code());
				pstmt.setString(6,taskBean.getMemo());
				
				count = pstmt.executeUpdate();
		}
		
		return count;
		
	}
	
/**
 * このメソッドは、m_user テーブルからユーザー名を取得します。
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
public List<UserBean> getUserName() throws ClassNotFoundException, SQLException {
		
		List<UserBean> userList = new ArrayList<UserBean>();
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM m_user")) {
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				String user_id = res.getString("user_id");
				String user_name = res.getString("user_name");
				
				UserBean userBean = new UserBean();	
				userBean.setUser_id(user_id);
				userBean .setUser_name(user_name);
				userList.add(userBean);
			}
		}
		return userList;
		
	}
}
