package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 */
public class UserDAO {
	
	/**
	 * この方法でユーザIDとパスワードをデータベースにいるからtrue戻る、無いからfalse戻る。
	 * @param userId
	 * @param password
	 * @return boolean型。
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean validate(String userId, String password) throws ClassNotFoundException, SQLException {
		boolean validate = false;
	
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM m_user WHERE user_id = ? && password = ?")){
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				validate = true;
			}	
		}		
		return validate;
	}
	/**
	 * この方法でユーザIDとパスワードを作って、ユーザ名を取得します。
	 * @param userId
	 * @param password
	 * @return ユーザ名
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public String userName(String userId, String password) throws ClassNotFoundException, SQLException {
		String userName = null;
	
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM m_user WHERE user_id = ? && password = ?")){
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				userName = res.getString("user_name");
			}	
		} 
		return userName;
	}
}
