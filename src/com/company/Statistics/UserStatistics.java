package com.company.Statistics;

import com.company.Entities.Artist;
import com.company.Entities.Track;

import java.util.HashMap;
import java.util.Map;

public class UserStatistics {
    Map<Track, Integer> trackPlays = new HashMap<>();
    Map<Artist, Integer> artistPlays = new HashMap<>();

    public void recordPlay(Track track) {
        if (trackPlays.get(track) == null) {
            trackPlays.put(track, 0);
        }
        if (artistPlays.get(track.getArtist()) == null) {
            artistPlays.put(track.getArtist(), 0);
        }
        int totalTrackStreams = this.trackPlays.get(track) + 1;
        this.trackPlays.put(track, totalTrackStreams);
        int totalArtistStreams = this.artistPlays.get(track.getArtist()) + 1;
        this.artistPlays.put(track.getArtist(), totalArtistStreams);
    }

    public Track getFavoriteTrack() {
        int currentMax = 0;
        Track maxTrack = null;
        for(Track t : trackPlays.keySet()) {
            int trackNumber = trackPlays.get(t);
            if (trackNumber > currentMax) {
                currentMax = trackNumber;
                maxTrack = t;
            }
        }
        if (currentMax == 0) {
            System.out.println("No streams, therefore no top track");
            return maxTrack;
        }
        return maxTrack;
    }

    public Artist getFavoriteArtist() {
        int currentMax = 0;
        Artist maxArtist = null;
        for(Artist a : artistPlays.keySet()) {
            int artistNumber = artistPlays.get(a);
            if (artistNumber > currentMax) {
                currentMax = artistNumber;
                maxArtist = a;
            }
        }
        if (currentMax == 0) {
            System.out.println("No streams, therefore no favorite artist");
            return maxArtist;
        }
        return maxArtist;
    }
}
