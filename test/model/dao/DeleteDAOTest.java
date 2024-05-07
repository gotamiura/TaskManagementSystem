package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeleteDAOTest {
	private DeleteDAO dao = new DeleteDAO();
	private final int TASK_ID = 53;

	@BeforeEach
	void setUp() throws Exception {
		dao = new DeleteDAO();
	}

	@AfterEach
	void tearDown() throws Exception {

		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO t_task( ");
		sb.append("task_id ");
		sb.append(",task_name ");
		sb.append(", category_id ");
		sb.append(", limit_date");
		sb.append(", user_id ");
		sb.append(", status_code ");
		sb.append(", memo) ");
		sb.append("VALUES (? , ? , ? , ? , ? , ? , ?) ");
		String sql1 = sb.toString();
		String sql2 = "INSERT INTO t_comment (comment_id,task_id, user_id, comment) VALUES (?, ?, ?, ?)";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt1 = con.prepareStatement(sql1);
				PreparedStatement pstmt2 = con.prepareStatement(sql2)) {
			pstmt1.setInt(1, 53);
			pstmt1.setString(2, "task21");
			pstmt1.setInt(3, 2);
			pstmt1.setDate(4, null);
			pstmt1.setString(5, "shanmathi");
			pstmt1.setString(6, "50");
			pstmt1.setString(7, "Inprogress");

			pstmt2.setInt(1, 64);
			pstmt2.setInt(2, TASK_ID);
			pstmt2.setString(3, "miura");
			pstmt2.setString(4, "uuuuu");

			pstmt1.executeUpdate();
			pstmt2.executeUpdate();

		} catch (SQLException e) {
			// 例外が発生した場合の処理
			e.printStackTrace(); // 例外情報を出力
		}
	}

	@Test
	void test1() throws SQLException {

		int process = 2;
		int result = 0;

		result = dao.deleteTask(TASK_ID);

		assertEquals(process, result);

	}

}
