package com.example.democrud.Entity;

import java.time.LocalDate;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ORIGINAL")

public class OriginalSong extends Song {

    private String originalArtist;

    public OriginalSong() {
        super();
    }

    public OriginalSong(String title, String artist, LocalDate released, String originalArtist) {
        super(title, artist, released);
        this.originalArtist = originalArtist;
    }

    public String getOriginalArtist() {
        return originalArtist;
    }

    public void setOriginalArtist(String originalArtist) {
        this.originalArtist = originalArtist;
    }
}