package com.company.Statistics;

public class RediStreamingStatistics {

    int totalPlays;

    public void recordPlay(){
        this.totalPlays = this.totalPlays + 1;
    }

    public int getTotalPlays() {
        return totalPlays;
    }
}
