package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ArtistDao;
import model.Artist;

@WebServlet("/list")
public class ArtistListServlet extends HttpServlet{
	
	private ArtistDao dao = new ArtistDao();
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Artist> artists = this.dao.getAllArtists();
			
		req.setAttribute("artists", artists);
		req.getRequestDispatcher("/WEB-INF/artistList.jsp").forward(req, resp);
		//haetaan kaikki artistit, välitetään jsp-sivulle
		resp.getWriter().println(artists);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String itemTitle = req.getParameter("Name");

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\Chinook_Sqlite.sqlite");
			statement = connection.prepareStatement("INSERT INTO Artist (Name) VALUES (?)");
			statement.setString(1, itemTitle);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (results != null) {
				try {
					results.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {

				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {

				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		resp.sendRedirect("/list");
	}

}
