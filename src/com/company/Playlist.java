package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {

    private String playlist;
    private ArrayList<Album> albums;
    private LinkedList<Song> playList = new LinkedList<Song>();

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
            System.out.println(albumName + " has been added.");
            return true;
        }
        return false;
    }

    public boolean addSong(String albumName, String song, double duration){
        Album thisAlbum = findAlbum(albumName);
        if(thisAlbum != null){
            thisAlbum.addSong(song, duration);
            System.out.println(song + " has been added.");
        }
        return false;
    }

    public boolean addToPlaylist(String albumName, String song){
        Album thisAlbum = findAlbum(albumName);
        if(thisAlbum != null){
            Song thisSong = thisAlbum.findSong(song);
            if(thisSong != null){
                playList.add(thisSong);
                System.out.println(thisSong + " is now in your playlist.");
            }
        }
        return false;
    }

    public boolean listSongs(){
        if(playList != null){
            for(int i = 0; i < playList.size(); i++){
                System.out.println(i+1 + ". " + playList.get(i));
            }
            return true;
        } else {
            System.out.println("Playlist is currently empty.");
            return false;
        }
    }





}
