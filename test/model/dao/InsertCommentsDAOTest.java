package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class InsertCommentsDAOTest {

	@Test
	void test() {
		int insert = 0;
		InsertCommentsDAO insertCommentDAO = new InsertCommentsDAO();
		try {
			insert = insertCommentDAO.insertComments(18, "shanmathi", "coverage");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		assertEquals(1, insert);
	}

}
