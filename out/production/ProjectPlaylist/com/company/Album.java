package com.company;

import java.util.ArrayList;
import java.util.LinkedList;


public class Album {

    private String name;
    private ArrayList<Song> songs;

    public Album(String name){
        this.name = name;
        this.songs = new ArrayList<Song>();
    }

    public String getName(){
        return name;
    }


    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            this.songs.add(new Song(title,duration));
            return true;
        }
        return false;
    }

    public Song findSong(String title){
        for(int i = 0; i < songs.size(); i++){
            Song checkSong = songs.get(i);
            if(checkSong.getTitle().equals(title)){
                return checkSong;
            }
        }
        return null;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playList){
        Song checkSong = findSong(title);
        if(checkSong != null){
            playList.add(checkSong);
            return true;
        }
        System.out.println(checkSong + " does not exist.");
        return false;
    }

}
