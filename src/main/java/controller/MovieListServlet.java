package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MovieBean;
import repository.MovieRepository;

/**
 * Servlet implementation class MovieListServlet
 */
@WebServlet("/movie-list")
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String catId = request.getParameter("catId");
		if(!catId.isEmpty()) {
			int id = Integer.parseInt(catId);
			MovieRepository movRepo = new MovieRepository();
			List<MovieBean> movlist =movRepo.getMoviesByCatId(id);
			System.out.println("movlist : "+movlist);
			request.setAttribute("movie_list", movlist);
			request.getRequestDispatcher("movie_list.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
