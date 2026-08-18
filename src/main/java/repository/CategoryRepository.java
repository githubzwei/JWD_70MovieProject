package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CategoryBean;


public class CategoryRepository {

	public List<CategoryBean> getAllCategories() {
		List<CategoryBean> catList = new ArrayList<CategoryBean>();

		String sql = "SELECT * FROM category";
		try (Connection con = DBConnection.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql)) {

		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CategoryBean obj=new CategoryBean();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				
				catList.add(obj);
				
			}
		} catch (SQLException e) {
			System.out.println("category list error : " + e.getMessage());
		}

		return catList;
	}
	

}
