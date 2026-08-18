package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.CategoryBean;
import model.MovieBean;

public class MovieRepository {

	public List<MovieBean> getMoviesByCatId(int categoryId) {
		List<MovieBean> movList = new ArrayList<MovieBean>();

		String sql = "SELECT * FROM movie where category_id=?";
		try (Connection con = DBConnection.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql)) {
		
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MovieBean obj=new MovieBean();
				obj.setId(rs.getInt("id"));
				obj.setTitle(rs.getString("title"));
				obj.setDescription(rs.getString("description"));
				obj.setDuration(rs.getString("duration"));
				obj.setReleaseYear(rs.getDate("release_year").toLocalDate());
				obj.setCategoryId(rs.getInt("category_id"));
				
				movList.add(obj);
			}
		} catch (SQLException e) {
			System.out.println("movie list error : " + e.getMessage());
		}

		return movList;
	}
	
	public int rentMovie(int memberId,int movieId) {

		int i = 0;

		String sql = "insert into movie_rented(member_id,movie_id) values(?,?)";

		try (Connection con = DBConnection.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, memberId);
			ps.setInt(2, movieId);
			
			i = ps.executeUpdate();
			

		} catch (SQLException e) {
			System.out.println("movie rented error : " + e.getMessage());
		}

		return i;

	}
	
}
