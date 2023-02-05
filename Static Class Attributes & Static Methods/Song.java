public class Song {
	private String title;
	private String artist;
	private int length;
	private static int songsCount = 0; //creating a static attribute which is exclusive to it's class which will be the same for all objects from song class.
	
	public Song(String title, String artist, int length) {this.title = title; this.artist = artist; this.length = length; songsCount++;} //every time ab obejct belonging to sound class is created, it will add 1 to count.}
	public String getTitle() {return this.title;}
	public String getArtist() {return this.artist;}
	public int getLength() {return this.length;}
	public int getSongsCount() {return songsCount;}
}
