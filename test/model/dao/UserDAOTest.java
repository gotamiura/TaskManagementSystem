package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class UserDAOTest {

	@Test
	void test1() {
		UserDAO userDAO = new UserDAO();
		try {
			boolean valid = userDAO.validate("shanmathi", "shan");
			assertTrue(valid);
			//valid = userDAO.validate("shanmathi", "shn");
			//assertFalse(valid);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test2() {
		UserDAO userDAO = new UserDAO();
		try {
			String userName = userDAO.userName("shanmathi", "shan");
			assertEquals("シャンマティ",userName);			
			//userName = userDAO.userName("shanmathi", "shn");
			//assertNull(userName);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
}
