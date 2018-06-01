/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtistsAndAlbums;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Austin LaBerta
 */
public class MusicDB {
	private Connection connection;
	private String dbUrl;
    
    public MusicDB() {
        dbUrl = "jdbc:sqlite:music_artists.sqlite";
		
		try {
			connection = DriverManager.getConnection(dbUrl);
		} catch (SQLException e) {
			System.err.println(e);
		}
    }
	
	public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
	
	public Artist[] populateArtists() {
		ArrayList<Artist> artists = new ArrayList<>();
		Artist[] artistArray;
		String sql = "SELECT * FROM Artists ORDER BY Name";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                int artistID = rs.getInt("ArtistID");
                Artist art = new Artist(artistID, name);
				artists.add(art);
            }
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			System.err.println(ex);
		}
		
		artistArray = new Artist[artists.size()];
		return artists.toArray(artistArray);
	}
	
	public Album[] populateAlbums(Artist[] artists) {
		ArrayList<Album> albums = new ArrayList<>();
		Album[] albumArray;
		String sql = "SELECT * FROM Albums ORDER BY Name";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("Name");
                int artistID = rs.getInt("ArtistID");
				int albumID = rs.getInt("AlbumID");
                Album album = new Album(albumID, artistID, name);
				albums.add(album);
            }
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			System.err.println(ex);
		}
		albumArray = new Album[albums.size()];
		return (Album[]) albums.toArray(albumArray);
	}
}
