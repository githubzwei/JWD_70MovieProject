package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.MovieRepository;

/**
 * Servlet implementation class SelectedMovieServlet
 */
@WebServlet("/selected-movie")
public class SelectedMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectedMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] movies=request.getParameterValues("mname");
		if(movies!=null) {
			int movieId = Integer.parseInt(movies[0]);
			MovieRepository movieRepo = new MovieRepository();
			int i=movieRepo.rentMovie(1, movieId);
			if(i!=0) {
				response.sendRedirect("welcome.jsp");
			}else {
				
			}
		}
	}

}
