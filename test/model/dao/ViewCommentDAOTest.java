package model.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import model.entity.EnterCommentsBean;

class ViewCommentDAOTest {

	@Test
	void test() {
		int taskId = 53;
		ViewCommentDAO dao = new ViewCommentDAO();
		
		EnterCommentsBean enterComments;
		try {
			enterComments = dao.selectComments(taskId);
			assertEquals(taskId,enterComments.getTaskId());
			assertEquals("task21",enterComments.getTaskName());
			assertEquals("shanmathi",enterComments.getUserId());
			assertEquals("シャンマティ",enterComments.getUserName());
			assertEquals("uuuuu",enterComments.getComment());
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

}

