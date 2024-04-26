package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertCommentsDAO {

	public int insertComments(int taskId, String userId, String comment) throws ClassNotFoundException, SQLException {
		int count = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT ");
        sb.append("INTO t_comment(task_id, user_id, comment) ");
        sb.append("VALUES (? , ? , ? ) ");

        String sql = sb.toString();

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {


				pstmt.setInt(1,taskId);
				pstmt.setString(2,userId);
				pstmt.setString(3, comment);
				
				count = pstmt.executeUpdate();
		}
		
		return count;
	}
}
