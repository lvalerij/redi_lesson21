package com.company;

import com.company.Entities.Artist;
import com.company.Entities.Track;
import com.company.Entities.User;


public class StreamingService {
    static Player player = new Player();

    public static void main(String... args) {
        // Part 1. create some data
        User user1 = new User("John", 1);
        User user2 = new User("Kate", 2);
        Artist artist1 = new Artist("Eagles", 1);
        Artist artist2 = new Artist("Michael Jackson", 2);
        Artist artist3 = new Artist("Beatles", 3);
        Track track1 = new Track(artist1, "Hotel California",1);
        Track track2 = new Track(artist2, "Smooth criminal",2);
        Track track3 = new Track(artist2, "Thriller",3);
        Track track4 = new Track(artist3, "Hey Jude",4);
        Track track5 = new Track(artist3, "Yesterday",5);
        Track track6 = new Track(artist3, "Yellow submarine",6);
        Track track7 = new Track(artist3, "Let it be",7);

        // Part 2. play music
        player.play(track3, user1);
        player.play(track1, user1);
        player.play(track2, user2);
        player.play(track3, user1);
        player.play(track1, user2);
        player.play(track1, user2);
        player.play(track1, user2);
        player.play(track1, user2);
        player.play(track1, user2);
        player.play(track1, user1);
        player.play(track3, user1);
        player.play(track4, user1);
        player.play(track5, user1);
        player.play(track6, user1);

        // Part 3. call the statistics from player

        // Who was their top artist?
        // Which was their favorite track?

        showTopArtist(user1);
        showFavoriteTrack(user1);

//      Who is my top fan? (Most played tracks)
//      How many different users have streamed my music?
        showTopFanForArtist(artist3);
        showDifferentUsersForArtist(artist3);

        // How many streams have there been in total?
        showTotalStreamsNumber();
    }

    static void showTopArtist(User user){
        String response = "For user " + user.getName() + " favorite artist is " + player.getFavoriteArtistForUser(user).getName();
        System.out.println(response);
    }

    static void showFavoriteTrack(User user){
        String response = "For user " + user.getName() + " favorite track is " + player.getFavoriteTrackForUser(user).getName() + " by " + player.getFavoriteTrackForUser(user).getArtist().getName();
        System.out.println(response);
    }

    static void showTopFanForArtist(Artist artist){
        String response = "For artist " + artist.getName() + " top fan is " + player.getTopFanForArtist(artist).getName();
        System.out.println(response);
    }

    static void showDifferentUsersForArtist(Artist artist){
        String response = "For artist " + artist.getName() + " different users that streamed artist's music is " + player.getDifferentUserCountForArtist(artist);
        System.out.println(response);
    }

    static void showTotalStreamsNumber() {
        System.out.println("Streams number that have been played in total is " + player.getTotalStreams());
    }
}
