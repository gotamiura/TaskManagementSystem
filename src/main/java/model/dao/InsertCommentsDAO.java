package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertCommentsDAO {

    public int insertComments(int taskId, String userId, String comment) throws ClassNotFoundException, SQLException {
        int count = 0;
        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO t_comment (task_id, user_id, comment) VALUES (?, ?, ?)")) {

            pstmt.setInt(1, taskId);
            pstmt.setString(2, userId);
            pstmt.setString(3, comment);

            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            // 例外が発生した場合の処理
            e.printStackTrace(); // 例外情報を出力
        }
        return count;
    }
}
