package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import model.entity.TaskBean;

class taskDAOTest {
	
	TaskBean taskBean = new TaskBean();
	@Test
	void test1() {
		taskDAO taskDao = new taskDAO();
        taskBean.setTaskName("coverage");
        taskBean.setCategoryId(2);
        taskBean.setLimitDate(new Date(System.currentTimeMillis()));
        taskBean.setUserId("shanmathi");
        taskBean.setStatusCode("50");
        taskBean.setMemo("Test memo");

        int count = 0;
		try {
			count = taskDao.insert(taskBean);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        assertEquals(1, count);
	}
}
