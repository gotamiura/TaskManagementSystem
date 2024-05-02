package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import model.entity.TaskCategoryBean;

class TaskDetailDAOTest {

	@Test
	void test() {
		int taskId = 53;
		TaskDetailDAO dao = new TaskDetailDAO();
		TaskCategoryBean taskDetail = null;
		try {
			taskDetail = dao.selectTask(taskId);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		assertEquals(taskId,taskDetail.getTaskId());
		assertEquals("task21",taskDetail.getTaskName());
		assertEquals(2,taskDetail.getCategoryId());
		assertEquals("既存商品：改良プロジェクト",taskDetail.getCategoryName());
		assertEquals(null,taskDetail.getLimitDate());
		assertEquals("shanmathi",taskDetail.getUserId());
		assertEquals("シャンマティ",taskDetail.getUserName());
		assertEquals("50",taskDetail.getStatusCode());
		assertEquals("着手",taskDetail.getStatusName());
		assertEquals("Inprogress",taskDetail.getMemo());
	}
}
