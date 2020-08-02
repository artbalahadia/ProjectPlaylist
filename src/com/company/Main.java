package com.company;

public class Main {

    public static void main(String[] args) {
        Playlist playList = new Playlist("myPlaylist");

        // Add album (Macklemore)
        playList.addAlbum("Gemini");

        // Add songs from the album
        playList.addSong("Gemini","Glorious", 3.40);
        playList.addSong("Gemini", "Willy Wonka", 3.43);

        // Add song to playlist
        playList.addToPlaylist("Gemini","Glorious");

        // Show current playlist
        playList.listSongs();
    }
}
