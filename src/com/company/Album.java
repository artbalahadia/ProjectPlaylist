package com.company;

import java.util.LinkedList;


public class Album {

    private String name;
    private LinkedList<Song> album;

    public Album(String name){
        this.name = name;
        this.album = new LinkedList<Song>();
    }

    public String getName(){
        return name;
    }

    public LinkedList<Song> getSongs(){
        return album;
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            this.album.add(new Song(name,duration));
            return true;
        } else {
            System.out.println(title + " is already in the album.");
            return false;
        }
    }

    public Song findSong(String title){
        for(int i = 0; i < album.size(); i++){
            Song checkSong = album.get(i);
            if(checkSong.getTitle().equals(title)){
                return checkSong;
            }
        }
        return null;
    }

}
