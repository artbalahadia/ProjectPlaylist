package com.company;

import java.util.*;

public class Main {

    // This albums ArrayList will store all albums that will be added/created
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        // Adding JCole's album - Revenge of the dreamers
        Album album = new Album("Revenge of the Dreamers");
        album.addSong("Middle Child",3.33);
        album.addSong("Under The Sun", 3.22);
        album.addSong("Self Love", 3.43);
        album.addSong("Swivel", 3.15);
        album.addSong("Wells Fargo",2.03);
        albums.add(album);

        // Adding Logic's album - Everybody
        album = new Album("Everybody");
        album.addSong("Everybody",2.43);
        album.addSong("Confess", 5.44);
        album.addSong("Killing Spree", 3.27);
        album.addSong("America",5.32);
        album.addSong("Take It Back",6.41);
        albums.add(album);

        // Adding songs to playlist
        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlaylist("Middle Child", playList);
        albums.get(0).addToPlaylist("Under The Sun", playList);
        albums.get(1).addToPlaylist("Everybody", playList);
        albums.get(1).addToPlaylist("Confess", playList);

        start(playList);
    }

    // playListMenu will provide user with controls in our playlist
    public static void playListMenu(){
        System.out.println("Controls: \n Please select from the following options \n");
        System.out.println(
                "1 - Play next song \n" +
                "2 - Play previous song \n" +
                "3 - Replay current song \n" +
                "4 - List songs in playlist \n" +
                "5 - Print controls \n" +
                "6 - Remove current song from playlist \n" +
                "0 - Exit application \n");
    }

    // start will initialize our playList application
    public static void start(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> i = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("No songs in playlist.");
            return;
        } else {
            System.out.println("Now playing " + i.next().toString());
            playListMenu();
        }


        while(!quit){
            int control = scanner.nextInt();
            scanner.nextLine();

            switch(control){
                case 1:
                    if(!forward){
                        // This checks the list and moves forward to display the next song
                        if(i.hasNext()) {
                            i.next();
                        }
                        forward = true;
                    }
                    if(i.hasNext()){
                        System.out.println("Now playing " + i.next().toString());
                    } else {
                        System.out.println("End of playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        // This checks the list and moves backward to display the previous song
                        if(i.hasPrevious()) {
                            i.previous();
                        }
                        forward = false;
                    }
                    if(i.hasPrevious()){
                        System.out.println("Now playing " + i.previous().toString());
                    } else {
                        System.out.println("Start of playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(i.hasPrevious()){
                            System.out.println("Replaying " + i.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("Start of playlist");
                        }
                    } else {
                        if(i.hasNext()){
                            System.out.println("Replaying " + i.next().toString());
                            forward = true;
                        } else {
                            System.out.println("End of playlist");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    playListMenu();
                    break;
                case 6:
                    if(playList.size() > 0){
                        i.remove();
                        if (i.hasNext()){
                            System.out.println("Now playing " + i.next());
                        } else if(i.hasPrevious()){
                            System.out.println("Now playing " + i.previous());
                        }
                    }
                    break;
                case 0:
                    System.out.println("Till next time! #StayChill");
                    quit = true;
                    break;
            }
        }
    }

    // printList iterates through playlist and prints all songs in playlist
    public static void printList(LinkedList<Song> playlist){
        Iterator<Song> i = playlist.iterator();
        System.out.println("--------- Tracks ---------");
        while(i.hasNext()){
            System.out.println(i.next());
        }
        System.out.println("--------------------------");
    }


}
