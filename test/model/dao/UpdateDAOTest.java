package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import model.entity.TaskCategoryBean;

class UpdateDAOTest {

	@Test
	void test1() {
		UpdateDAO updateDao = new UpdateDAO();
        TaskCategoryBean updateItem = new TaskCategoryBean();
        updateItem.setTaskId(18); // Assuming this task ID exists in the test data
        updateItem.setTaskName("Updated Task");
        updateItem.setCategoryId(2);
        updateItem.setLimitDate(Date.valueOf("2024-06-01"));
        updateItem.setUserId("shanmathi");
        updateItem.setStatusCode("00");
        updateItem.setMemo("Updated memo");

        int processingNumber = 0;
		try {
			processingNumber = updateDao.updateTask(updateItem);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

        assertEquals(1, processingNumber);
	}
	
	@Test
	void test2() {
		UpdateDAO updateDao = new UpdateDAO();
		String categoryName = null;
		try {
			categoryName = updateDao.getCategoryName(1);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		assertEquals("A",categoryName);
		
		
	}
	@Test
	void test3() {
		UpdateDAO updateDao = new UpdateDAO();
		String userName = null;
		try {
			userName = updateDao.getUserName("shanmathi");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		assertEquals("シャンマティ", userName);		
	}
	@Test
	void test4() {
		UpdateDAO updateDao = new UpdateDAO();
		String statusName = null;
		try {
			statusName = updateDao.getStatusName("50");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		assertEquals("着手", statusName);		
	}

}
