package com.company.Statistics;

import com.company.Entities.User;

import java.util.HashMap;
import java.util.Map;

public class ArtistStatistics {
    Map<User, Integer> trackPlays = new HashMap<>();

    public void recordPlay(User user){
        if (trackPlays.get(user) == null) {
            trackPlays.put(user,0);
        }
        int totalStreams = this.trackPlays.get(user) + 1;
        this.trackPlays.put(user, totalStreams);
    }

    public User getTopFan() {
        int maxStreamsUser = 0;
        User topFan = null;
        for (User user : trackPlays.keySet()) {
            int streamsNumber = trackPlays.get(user);
            if (streamsNumber > maxStreamsUser) {
                maxStreamsUser = streamsNumber;
                topFan = user;
            }
        }
        return topFan;
    }

    public int getDifferentUserCount() {
        return trackPlays.keySet().size();
    }


}
