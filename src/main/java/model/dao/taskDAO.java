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
	public TMSBean getTask(int task_id) throws ClassNotFoundException, SQLException {
	    TMSBean bean = null;
	    
	    StringBuilder sb = new StringBuilder();
	    sb.append("SELECT ");
	    sb.append("t1.task_name, ");
	    sb.append("t2.category_name, ");
	    sb.append("t1.limit_date, ");
	    sb.append("t3.user_name, ");
	    sb.append("t4.status_name, ");
	    sb.append("t1.memo ");
	    sb.append("FROM ");
	    sb.append("t_task AS t1 ");
	    sb.append("LEFT JOIN m_category AS t2 ");
	    sb.append("ON t1.category_id = t2.category_id ");
	    sb.append("LEFT JOIN m_user AS t3 ");
	    sb.append("ON t1.user_id = t3.user_id ");
	    sb.append("LEFT JOIN m_status AS t4 ");
	    sb.append("ON t1.status_code = t4.status_code ");
	    sb.append("WHERE ");
	    sb.append("t1.task_id = ? ");

	    String sql = sb.toString();

	    try (Connection con = ConnectionManager.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql)) {
	        pstmt.setInt(1, task_id);
	        try (ResultSet res = pstmt.executeQuery()) {
	            if (res.next()) {
	                bean = new TMSBean();    
	                bean.setTaskName(res.getString("task_name"));
	                bean.setCategoryName(res.getString("category_name"));
	                bean.setLimitDate(res.getDate("limit_date"));
	                bean.setUserName(res.getString("user_name"));
	                bean.setStatusName(res.getString("status_name"));
	                bean.setMemo(res.getString("memo"));
	            }
	        }
	    }
	    return bean;
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


