package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;

public class taskDAO {
	public List<CategoryBean> getCategory() throws ClassNotFoundException, SQLException {
		
		List<CategoryBean> categoryList = new ArrayList<CategoryBean>();
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM m_category")) {
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				int category_id = res.getInt("category_id");
				String category_name = res.getString("category_name");
				
				CategoryBean categoryBean = new CategoryBean();	
				categoryBean.setCategory_id(category_id);
				categoryBean .setCategory_name(category_name);

				categoryList.add(categoryBean);
			}
		}
		return categoryList;
		
	}
}
