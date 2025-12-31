package com.example.democrud.Entity;

import java.time.LocalDate;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("COVER")
public class Cover extends Song {

    private String coverArtist;

    public Cover() {
        super();
    }

    public Cover(String title, String artist, LocalDate released, String coverArtist) {
        super(title, artist, released);
        this.coverArtist = coverArtist;
    }

    public String getCoverArtist() {
        return coverArtist;
    }

    public void setCoverArtist(String coverArtist) {
        this.coverArtist = coverArtist;
    }
}