package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class UserDAOTest {

	@Test
	void test1() {
		UserDAO userDAO = new UserDAO();
		boolean valid = false;
		try {
			valid = userDAO.validate("shanmathi", "shan");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		assertTrue(valid);
		//valid = userDAO.validate("shanmathi", "shn");
		//assertFalse(valid);
	}
	
	@Test
	void test2() {
		UserDAO userDAO = new UserDAO();
		String userName = "";
		try {
			userName = userDAO.userName("shanmathi", "shan");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		assertEquals("シャンマティ",userName);			
		//userName = userDAO.userName("shanmathi", "shn");
		//assertNull(userName);
	}
	
}
