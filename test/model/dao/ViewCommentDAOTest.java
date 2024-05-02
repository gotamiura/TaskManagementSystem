package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.entity.EnterCommentsBean;

class ViewCommentDAOTest {
	private ViewCommentDAO dao = new ViewCommentDAO();
	private EnterCommentsBean enterComments = null;
	
//	@Test
	void test_selectComments() {
		int taskId = 46;

		try {
			enterComments = dao.selectComments(taskId);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		assertEquals(taskId,enterComments.getTaskId());
		assertEquals("製品ローンチの準備",enterComments.getTaskName());
		assertEquals("shanmathi",enterComments.getUserId());
		assertEquals("シャンマティ",enterComments.getUserName());
		assertEquals("mmmmmmmmmmmmmmmm",enterComments.getComment());
	}
	
	@Test
	void test_showComments() {
		int taskId = 43;
		
		List<EnterCommentsBean> commentList = new ArrayList<>();
		ViewCommentDAO dao = new ViewCommentDAO();
		
		//ファイル読み込みで使用する３つのクラス
		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;

		try {
			commentList = dao.showComments(taskId);
			//読み込みファイルのインスタンス生成
			//ファイル名を指定する
			fi = new FileInputStream("task_db.t_comment.csv");
			is = new InputStreamReader(fi);
			br = new BufferedReader(is);

			//読み込み行
			String line;

			//読み込み行数の管理
			int i = 0;

			//列名を管理する為の配列
			String[] arr = null;

			//1行ずつ読み込みを行う
			while ((line = br.readLine()) != null) {

				//先頭行は列名
				if (i == 0) {

					arr = line.split(",");

				} else {

					//カンマで分割した内容を配列に格納する
					String[] data = line.split(",");

					assertEquals(Integer.parseInt(data[0]), commentList.get(i - 1).getCommentId());
	                assertEquals(Integer.parseInt(data[1]), commentList.get(i - 1).getTaskId());
	                assertEquals(data[2], commentList.get(i - 1).getUserId());
//	                assertEquals(data[3], commentList.get(i - 1).getComment());
	                assertEquals(Timestamp.valueOf(data[4]), commentList.get(i - 1).getUpdateDatetime());

				}

				//行数のインクリメント
				i++;

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

