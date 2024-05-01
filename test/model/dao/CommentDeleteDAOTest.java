package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommentDeleteDAOTest {
	private CommentDeleteDAO dao = new CommentDeleteDAO();
	private static final int COMMENT_ID = 51;
	@BeforeEach
	void setUp() throws Exception {
		dao = new CommentDeleteDAO();
	}

	@AfterEach
	void tearDown() throws Exception {
        String sql = "INSERT INTO t_comment (comment_id,task_id, user_id, comment) VALUES (?, ?, ?, ?)";
        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, COMMENT_ID);
            pstmt.setInt(2, 44);
            pstmt.setString(3, "miura");
            pstmt.setString(4, "aaaaaaaaaa");

            pstmt.executeUpdate();
        } catch (SQLException e) {
            // 例外が発生した場合の処理
            e.printStackTrace(); // 例外情報を出力
        }
    }

	@Test
	void test1() throws ClassNotFoundException {
		
		int process = 1;
		int result = 0;

		try {
			result = dao.deleteTask(COMMENT_ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		assertEquals(process, result);
	}


}
