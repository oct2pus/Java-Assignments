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
public class ArtistsAndAlbums {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// populate variables
		MusicDB db = new MusicDB();
		Artist[] artists = db.populateArtists();
		Album[] albums = db.populateAlbums(artists);
		addAlbumsToArtists(artists, albums);
		
		// display
		System.out.println("Artists and Album Listings\n");
		
		System.out.println("Artists\n-------");
		for(int x = 0; x < artists.length; x++) {
			System.out.println(artists[x].getName());
		}
		
		System.out.println("\nAlbums\n------");
		for(int x = 0; x < albums.length; x++) {
			System.out.println(albums[x].toString());
		}
		
		System.out.println("\nAlbums By Artist\n----------------");
		for(int x = 0; x < artists.length; x++) {
			System.out.print(artists[x].toString());
		}
		
		System.out.print("\n");
	}
	
	public static void addAlbumsToArtists(Artist[] artists, Album[] albums) {
		for (int x = 0; x < artists.length; x++) {
			for (int y = 0; y < albums.length; y++) {
				if (artists[x].getArtistID() == albums[y].getArtistID()) {
					artists[x].addAlbum(albums[y]);
				}
			}
		}
	}
}
