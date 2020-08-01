package com.company;

import java.util.ArrayList;

public class Playlist {

    private String playlist;
    private ArrayList<Album> albums;

    public Playlist(String name){
        this.playlist = name;
        this.albums = new ArrayList<Album>();
    }

    public Album findAlbum(String albumName){
        for(int i = 0; i < albums.size(); i ++){
            Album checkedAlbum = albums.get(i);
            if(checkedAlbum.getName().equals(albumName)){
                return checkedAlbum;
            }
        }
        return null;
    }

    public boolean addAlbum(String albumName){
        if(findAlbum(albumName) == null){
            albums.add(new Album(albumName));
            return true;
        }
        return false;
    }

    public boolean addSong(String albumName, String song, double duration){
        Album thisAlbum = findAlbum(albumName);
        if(thisAlbum != null){
            thisAlbum.addSong(song, duration);
        }
        return false;
    }



}
