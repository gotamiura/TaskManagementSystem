package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
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
