/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtistsAndAlbums;

import java.util.ArrayList;

/**
 *
 * @author Austin LaBerta
 */
public class Artist {
	private int artistID;
	private String name;
	private ArrayList<Album> albums;
	public Artist(int a, String b) {
		artistID = a;
		name = b;
		albums = new ArrayList<>();
	}
	
	public int getArtistID() {
		return artistID;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		String output = "";
		output+= name + "\n";
		for(int x = 0; x < albums.size(); x++) {
			output+= "\t" + albums.get(x) + "\n";
		}
		
		return output;
	}
	
	public void addAlbum(Album album) {
		albums.add(album);
	}

}
