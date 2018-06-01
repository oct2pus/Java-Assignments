/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtistsAndAlbums;

/**
 *
 * @author Austin LaBerta
 */
public class Album {
	private int artistID,
		albumID;
	private String name;
	
	Album(int a, int b, String c) {
		albumID = a;
		artistID = b;
		name = c;
	}
	
	public int getArtistID() {
		return artistID;
	}
	
	public int getAlbumID() {
		return albumID;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
