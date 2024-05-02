package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.entity.CategoryBean;
import model.entity.TMSBean;
import model.entity.TaskBean;
import model.entity.UserBean;

class taskDAOTest {

	@Test
	void test1() {
		List<CategoryBean> categoryList = new ArrayList<CategoryBean>();
		taskDAO taskDao = new taskDAO();
		//ファイル読み込みで使用する３つのクラス
		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;

		try {
			categoryList = taskDao.getCategory();

			fi = new FileInputStream("task_db.m_category.csv");
			is = new InputStreamReader(fi);
			br = new BufferedReader(is);

			//読み込み行
			String line;

			//読み込み行数の管理
			int i = 0;

			//列名を管理する為の配列
			String[] arr = null;

			//1行ずつ読み込みを行う
			try {
				while ((line = br.readLine()) != null) {
					//先頭行は列名
					if (i == 0) {
						arr = line.split(",");
					} else {
						//カンマで分割した内容を配列に格納する
						String[] data = line.split(",");
						assertEquals(Integer.parseInt(data[0]), categoryList.get(i - 1).getCategoryId());
						assertEquals(data[1].toString(), categoryList.get(i - 1).getCategoryName());
						assertNull(categoryList.get(i-1).getUpdateDatetime());
					}
					i++;
				}
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	@Test
	void test2() {
		TaskBean taskBean = new TaskBean();
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
			e.printStackTrace();
		}
		assertEquals(1, count);
	}
	
	@Test
	void test3() {
		List<UserBean> userList = new ArrayList<UserBean>();
		taskDAO taskDao = new taskDAO();
		//ファイル読み込みで使用する３つのクラス
		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;

		try {
			userList = taskDao.getUserName();

			fi = new FileInputStream("task_db.m_user.csv");
			is = new InputStreamReader(fi);
			br = new BufferedReader(is);

			//読み込み行
			String line;

			//読み込み行数の管理
			int i = 0;

			//列名を管理する為の配列
			String[] arr = null;

			//1行ずつ読み込みを行う
			try {
				while ((line = br.readLine()) != null) {

					//先頭行は列名
					if (i == 0) {
						arr = line.split(",");
					} else {

						//カンマで分割した内容を配列に格納する
						String[] data = line.split(",");
						assertEquals(Integer.parseInt(data[0]), userList.get(i - 1).getUserId());
						assertEquals(data[1].toString(), userList.get(i - 1).getUserName());
						assertNull(userList.get(i-1).getUpdateDatetime());
					}
					i++;
				}
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	@Test
	void test4() {
		List<TMSBean> statusList = new ArrayList<TMSBean>();
		taskDAO taskDao = new taskDAO();
		//ファイル読み込みで使用する３つのクラス
		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;

		try {
			statusList = taskDao.setStatusName();

			fi = new FileInputStream("task_db.m_status.csv");
			is = new InputStreamReader(fi);
			br = new BufferedReader(is);

			//読み込み行
			String line;

			//読み込み行数の管理
			int i = 0;

			//列名を管理する為の配列
			String[] arr = null;

			//1行ずつ読み込みを行う
			try {
				while ((line = br.readLine()) != null) {

					//先頭行は列名
					if (i == 0) {
						arr = line.split(",");
					} else {

						//カンマで分割した内容を配列に格納する
						String[] data = line.split(",");
						assertEquals(data[0], statusList.get(i - 1).getStatusCode());
						assertEquals(data[1].toString(), statusList.get(i - 1).getStatusName());
					}
					i++;
				}
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
	}
}
