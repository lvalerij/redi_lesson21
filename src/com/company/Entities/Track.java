package com.company.Entities;

public class Track {
    private long id;
    private Artist artist;
    private String name;


    public Track(Artist artist, String name, long id) {
        this.artist = artist;
        this.name = name;
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
