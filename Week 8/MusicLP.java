package com.rit.hw.assignment8B;

public class MusicLP implements Comparable<MusicLP>{
    int year;
    String artist;
    String title;
    float length;
    int tracks;

    public MusicLP(int year, String artist, String title, float length, int tracks){
        this.year = year;
        this.artist = artist;
        this.title = title;
        this.length = length;
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return this.title;
    }

    @Override
    public int compareTo(MusicLP o) {
        if (Integer.valueOf(this.year).compareTo(Integer.valueOf(o.year)) != 0) {
            return Integer.valueOf(this.year).compareTo(Integer.valueOf(o.year));
        } else if (this.artist.compareTo(o.artist) != 0) {
            return this.artist.compareTo(o.artist);
        } else if (this.title.compareTo(o.title) != 0) {
            return this.title.compareTo(o.title);
        }else if (Float.valueOf(this.year).compareTo(Float.valueOf(o.year)) != 0) {
            return Float.valueOf(this.year).compareTo(Float.valueOf(o.year));
        } else {
            return Integer.valueOf(this.tracks).compareTo(Integer.valueOf(o.tracks));
        }
    }
}
