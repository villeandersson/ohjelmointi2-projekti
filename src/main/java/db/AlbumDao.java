package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Album;

public class AlbumDao {

	private Database db = new Database();

	public List<Album> getAlbums(String id) {
		String selectAll = "SELECT AlbumId, Title FROM Album WHERE ArtistId = ? ORDER BY Title ASC;";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Album> allAlbums = new ArrayList<>();
		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectAll);
			statement.setString(1, id);
			results = statement.executeQuery();
			while (results.next()) {
				long AlbumId = results.getLong("AlbumId");
				String title = results.getString("Title");
				
				Album a = new Album(AlbumId, title);
				allAlbums.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return allAlbums;
	}

}
