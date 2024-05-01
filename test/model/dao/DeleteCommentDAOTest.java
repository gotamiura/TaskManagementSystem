package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import model.entity.EnterCommentsBean;

class DeleteCommentDAOTest {

	@Test
	void test() {
		int commentId = 3;
		DeleteCommentDAO deleteCommentDAO = new DeleteCommentDAO();

		EnterCommentsBean enterCommentsBean;
		try {
			enterCommentsBean = deleteCommentDAO.selectComments(commentId);
			assertEquals(7, enterCommentsBean.getTaskId());
			assertEquals("task3", enterCommentsBean.getTaskName());
			assertEquals("shanmathi", enterCommentsBean.getUserId());
			assertEquals("シャンマティ", enterCommentsBean.getUserName());
			assertEquals(3, enterCommentsBean.getCommentId());
			assertEquals("welcome", enterCommentsBean.getComment());
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

}
