package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;
import model.entity.TMSBean;
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
				categoryBean.setCategoryId(category_id);
				categoryBean .setCategoryName(category_name);

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
	    StringBuilder sb = new StringBuilder();
	    sb.append("INSERT INTO t_task( ");
	    sb.append("task_name ");
	    sb.append(", category_id ");
	    sb.append(", limit_date");
	    sb.append(", user_id ");
	    sb.append(", status_code ");
	    sb.append(", memo) ");
	    sb.append("VALUES (? , ? , ? , ? , ? , ? ) ");
	    String sql = sb.toString();

	    try (Connection con = ConnectionManager.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1,taskBean.getTaskName());
				pstmt.setInt(2,taskBean.getCategoryId());
				pstmt.setDate(3,taskBean.getLimitDate());
				pstmt.setString(4,taskBean.getUserId());
				pstmt.setString(5, taskBean.getStatusCode());
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
				userBean.setUserId(user_id);
				userBean .setUserName(user_name);
				userList.add(userBean);
			}
		}
		return userList;
		
	}

	public List<TMSBean> setStatusName() throws ClassNotFoundException, SQLException {
		List<TMSBean> statusList = new ArrayList<TMSBean>();
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM m_status")) {
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				String status_code = res.getString("status_code");
				String status_name = res.getString("status_name");
				
				TMSBean tBean = new TMSBean();	
				tBean.setStatusCode(status_code);
				tBean.setStatusName(status_name);
				statusList.add(tBean);
			}
		}
		return statusList;
	}
}


