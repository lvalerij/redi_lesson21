package com.company;



import com.company.Entities.Artist;
import com.company.Entities.Track;
import com.company.Entities.User;
import com.company.Statistics.ArtistStatistics;
import com.company.Statistics.RediStreamingStatistics;
import com.company.Statistics.UserStatistics;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private RediStreamingStatistics rediStatistics = new RediStreamingStatistics();
    private Map<User, UserStatistics> userStatistics = new HashMap<>();
    private Map<Artist, ArtistStatistics> artistStatistics = new HashMap<>();

    public void play(Track track, User user) {
        rediStatistics.recordPlay();
        if (userStatistics.get(user) == null) {
            userStatistics.put(user, new UserStatistics());
        }
        userStatistics.get(user).recordPlay(track);
        if (artistStatistics.get(track.getArtist()) == null) {
            artistStatistics.put(track.getArtist(), new ArtistStatistics());
        }
        artistStatistics.get(track.getArtist()).recordPlay(user);
        System.out.println("User "+ user.getName() + " plays the track "+ track.getName());
    }

    public User getTopFanForArtist(Artist artist) {
        return artistStatistics.get(artist).getTopFan();
    }

    public Integer getDifferentUserCountForArtist(Artist artist) {
        return artistStatistics.get(artist).getDifferentUserCount();
    }

    public Track getFavoriteTrackForUser(User user) {
        return userStatistics.get(user).getFavoriteTrack();
    }

    public Artist getFavoriteArtistForUser(User user) {
        return userStatistics.get(user).getFavoriteArtist();
    }

    public int getTotalStreams() {
        return rediStatistics.getTotalPlays();
    }


}
